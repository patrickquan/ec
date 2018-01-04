package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.AppEnum;
import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.common.entity.common.TokenSession;
import com.yangcl.ec.service.authentication.common.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Date;

@Controller
public class SessionController {

    @Autowired
    private JwtUtil jwtUtil;

    //导入配置-是否单会话模式
    @Value("${account.online.single}")
    private Boolean accountSingle;

    //导入配置-在线帐户过期时间
    @Value("${account.online.expiration}")
    private Long accountExpiration;

    //导入配置-在线用户仓库实现名
    @Value("${account.online.repository}")
    private String accountRepositoryName;

    //导入配置-是否刷新token
    @Value("${account.jwt.refreshExpiration}")
    private Boolean refreshExpirationToken;

    //在线用户仓库接口
    private AccountRepository accountRepository;

    private SessionRepository sessionRepository;

    //初始化方法，概据配置仓库名实例化相应的仓库实现类，有Memory,Redis,MySQL三种实现
    @PostConstruct
    public void  init(){
        accountRepository= AccountFactory.getInstance(accountRepositoryName);
        sessionRepository= SessionFactory.getInstance(accountRepositoryName);
    }


    @RequestMapping(value = "/auth/session/created",method = RequestMethod.POST)
    @ResponseBody
    public JsonResult createdSession(@RequestBody TokenSession session){
        //返回包装类
        JsonResult result=new JsonResult();
        //创建token
        session.setToken(jwtUtil.createdToken(session));
        //设置帐户过期时间
        session.setExpirationTime(new Date(System.currentTimeMillis()+accountExpiration*1000));
        //判断帐户是否在线
        if(sessionRepository.getSession(session.getSessionId(),session.getSystem())!=null){
            //如果帐户在线
            if(accountSingle){
                //如果单会话模式，更新会话
                sessionRepository.updateSession(session);
            }else{
                //如果多会话模式，新增会话
                sessionRepository.addSession(session);
            }
        }else{
            //不在线，新增会话
            sessionRepository.addSession(session);
        }
        result.setCode(AppEnum.AuthResultCode.LoginSuccess.getCode());
        result.setMessage(AppEnum.AuthResultCode.LoginSuccess.getMessage());
        result.setToken(session.getToken());
        return result;
    }

    @RequestMapping(value = "/auth/session/validate",method = RequestMethod.POST)
    @ResponseBody
    public TokenSession sessionValidate(@RequestBody String token){
        TokenSession session=new TokenSession();
        //验证token是否有效
        Boolean tokenValid=jwtUtil.validateToken(token);
        if(tokenValid){
            //验证token有效期是否小于3分钟与配置是否刷新token，则生成刷新token
            Long timeMillis=jwtUtil.getExpirationDateFromToken(token).getTime()-System.currentTimeMillis();
            if(timeMillis>0 && timeMillis<180000 && refreshExpirationToken){
                session.setRefreshToken(jwtUtil.refreshToken(token));
            }
        }
        session.setToken(token);
        return session;
    }

}
