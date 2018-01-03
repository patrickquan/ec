package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.service.authentication.common.AccountFactory;
import com.yangcl.ec.service.authentication.common.AccountRepository;
import com.yangcl.ec.service.authentication.common.JwtUtil;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @Value("${account.repository}")
    private String accountRepositoryName;

    @Value("${account.single}")
    private Boolean accountSingle;

    @Value("${account.expiration}")
    private Long accountExpiration;

    private AccountRepository accountRepository;

    @PostConstruct
    public void  init(){
        AccountFactory accountFactory=new AccountFactory();
        accountRepository=accountFactory.getInstance(accountRepositoryName);
    }

    /**
     * 登录
     * @param loginAccount 帐户
     * @return JsonResult
     */
    @RequestMapping(value = "/auth/account/login",method = RequestMethod.POST)
    public JsonResult<LoginAccount> loginIn(@RequestBody LoginAccount loginAccount){
        JsonResult<LoginAccount> jsonResult=new JsonResult<LoginAccount>();
        jsonResult.setCode("200");
        jsonResult.setMessage("登录成功");

        //参数校验
        if(loginAccount==null ||
                loginAccount.getUsername()==null ||
                loginAccount.getUsername().equals("")){
            jsonResult.setCode("400");
            jsonResult.setMessage("帐户为空");
            return jsonResult;
        }

        //获取登录帐户
        LoginAccount onlineAccount=accountRepository.getAccount(loginAccount.getAccountId(),loginAccount.getSysName());
        if(onlineAccount!=null){
            loginAccount.setToken(jwtUtil.createdToken(loginAccount));
            //判断是否单会话登录，单会话登录会顶掉之前的会话
            if(accountSingle){
                accountRepository.updateAccount(loginAccount);//更新登录信息
            }else{
                accountRepository.addAccount(loginAccount);//新增登录信息
            }

        }else{
            //未登录过，创建token并添加到在线用户
            loginAccount.setToken(jwtUtil.createdToken(loginAccount));
            accountRepository.addAccount(loginAccount);//加入登录信息
        }
        jsonResult.setEntity(loginAccount);
        return jsonResult;
    }

    /**
     * 登录验证
     * @param token token
     * @return JsonResult
     */
    @RequestMapping(value = "/auth/account/validate",method = RequestMethod.POST)
    public JsonResult<LoginAccount> loginValidate(@RequestBody String token){
        JsonResult<LoginAccount> jsonResult=new JsonResult<LoginAccount>();

        //参数校验
        if(token==null || token.equals("")){
            jsonResult.setCode("400");
            jsonResult.setMessage("toke为空");
            return jsonResult;
        }

        //验证token
        LoginAccount accountResult=jwtUtil.getLoginAccountFromToken(token);
        if(accountResult==null){
            jsonResult.setCode("402");
            jsonResult.setMessage("token验证未通过");
            return jsonResult;
        }
        //查找是否在线
        accountResult= accountRepository.getAccount(accountResult.getAccountId(),accountResult.getSysName(),token,accountExpiration);
        if(accountResult==null){
            jsonResult.setCode("403");
            jsonResult.setMessage("用户不在线");
            return jsonResult;
        }
        jsonResult.setCode("200");
        jsonResult.setMessage("登录验证成功");
        jsonResult.setEntity(accountResult);
        return jsonResult;
    }
}
