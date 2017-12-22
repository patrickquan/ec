package com.yangcl.ec.service.authentication.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import java.util.Date;

public class JwtUtil {

    //签发JWT
    public static String createJWT(){
        SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
        SecretKey secretKey=generalKey();
        JwtBuilder builder= Jwts.builder()
                .setId("id")                              //JWT_ID
                .setAudience("")                          //接受者
                .setClaims(null)                          //自定义属性
                .setSubject("")                           //主题
                .setIssuer("")                            //签发者
                .setIssuedAt(new Date())                  //签发时间
                .setNotBefore(new Date())                 //失效时间
                .setExpiration(new Date())                //过期时间
                .signWith(signatureAlgorithm,secretKey);  //签名算法以及密匙
        return builder.compact();
    }

    //签证JWT
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey secretKey=generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }

    private  static SecretKey generalKey(){
        return  new SecretKey() {
            @Override
            public String getAlgorithm() {
                return null;
            }

            @Override
            public String getFormat() {
                return null;
            }

            @Override
            public byte[] getEncoded() {
                return new byte[0];
            }
        };
    }
}
