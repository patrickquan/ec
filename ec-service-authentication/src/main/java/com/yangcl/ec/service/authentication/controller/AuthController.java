package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.common.entity.erp.domain.Permission;
import com.yangcl.ec.service.authentication.common.JwtUtil;
import com.yangcl.ec.service.authentication.common.OnlineAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 创建token
     * @param claims
     * @return
     */
    @RequestMapping(value = "/auth/token/create",method = RequestMethod.POST)
    public String createToken(@RequestBody Map<String,Object> claims){
        String token=jwtUtil.createdToken(claims);
        return token;
    }

    /**
     * 创建token
     * @param loginAccount
     * @return
     */
    @RequestMapping(value = "/auth/token/create/loginaccount",method = RequestMethod.POST)
    public LoginAccount createdToken(@RequestBody LoginAccount loginAccount){
        String token=jwtUtil.createdToken(loginAccount);
        loginAccount.setToken(token);
        OnlineAccountRepository.addAccount(loginAccount);
        return loginAccount;
    }

    /**
     * 验证token
     * @param token
     * @return
     */
    @RequestMapping(value = "/auth/token/validate",method = RequestMethod.POST)
    public Boolean validateToken(@RequestBody String token){
        return jwtUtil.validateToken(token);
    }

    /**
     * 验证token
     * @param loginAccount
     * @return
     */
    @RequestMapping(value = "/auth/token/validate/loginaccount",method = RequestMethod.POST)
    public Boolean validateToken(@RequestBody LoginAccount loginAccount){
        return jwtUtil.validateToken(loginAccount);
    }

    /**
     * 获取登录帐户信息
     * @return
     */
    @RequestMapping(value = "/auth/account/getbytoken",method = RequestMethod.POST)
    public LoginAccount getAccount(@RequestBody String token){
        LoginAccount loginAccount=jwtUtil.getLoginAccountFromToken(token);
        if(loginAccount==null){
            return null;
        }
        loginAccount= OnlineAccountRepository.getAccountByUsername(loginAccount.getAccountId(),loginAccount.getSysName());
        return loginAccount;
    }
}
