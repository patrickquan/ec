package com.yangcl.ec.service.authentication.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
   private static final String CLAIM_KEY_USER_ACCOUNT="sub";
   private static final String CLAIM_KEY_CREATED="created";

   @Value("${jwt.secret}")
   private String secret;

   @Value("${jwt.expiration}")
   private Long expiration;

   /**
    * 生成Token
    * @return
    */
   public String createdToken(Map<String,Object> claims){
      return Jwts.builder()
              .setClaims(claims)
              .setExpiration(new Date(System.currentTimeMillis()+this.expiration*1000))
              .signWith(SignatureAlgorithm.HS256,this.secret)
              .compact();
   }

   /**
    * 刷新token
    * @param token
    * @return
    */
   public String refreshToken(String token){
      String refreshedToken;
      try{
         final Claims claims=getClaimsFromToken(token);
         claims.put(CLAIM_KEY_CREATED,new Date());
         refreshedToken=createdToken(claims);
      }catch (Exception err){
         refreshedToken=null;
      }
      return refreshedToken;
   }

   /**
    * 验证token
    * @param token
    * @return
    */
   public Boolean validateToken(String token){
      final String account=getAccountFromToken(token);
      return false;
   }

   /**
    * 从token中获取用户
    * @param token
    * @return
    */
   public String getAccountFromToken(String token){
      String account;
      try{
         final Claims claims=getClaimsFromToken(token);
         account=claims.getSubject();
      }catch (Exception err){
         account=null;
      }
      return account;
   }

   /**
    * 从token中获取自定义信息
    * @param token
    * @param key
    * @return
    */
   public Object getValueFromToken(String token,String key){
      Object result;
      try{
         final Claims claims=getClaimsFromToken(token);
         result=claims.get(key);
      }catch (Exception err){
         result=null;
      }
      return result;
   }

   /**
    * 从token中获取创建时间
    * @param token
    * @return
    */
   public Date getCreatedDateFromToken(String token){
      Date created;
      try{
         final Claims claims=getClaimsFromToken(token);
         created=new Date((Long)claims.get(CLAIM_KEY_CREATED));
      }catch (Exception err){
         created=null;
      }
      return created;
   }

   /**
    * 获取token过期时间
    * @param token
    * @return
    */
   public Date getExpirationDateFromToken(String token){
      Date expiration;
      try{
         final Claims claims=getClaimsFromToken(token);
         expiration=claims.getExpiration();
      }catch (Exception err){
         expiration=null;
      }
      return expiration;
   }

   /**
    * 从token中获取claims
    * @param token
    * @return
    */
   private Claims getClaimsFromToken(String token){
      Claims claims;
      try{
         claims=Jwts.parser()
                 .setSigningKey(secret)
                 .parseClaimsJws(token)
                 .getBody();
      }catch (Exception err){
         claims=null;
      }
      return claims;
   }

   /**
    * 判断token是否过期
    * @param token
    * @return
    */
   private Boolean isTokenExpired(String token){
      final Date expiration=getExpirationDateFromToken(token);
      Boolean result=expiration.before(new Date());
      return result;
   }
}
