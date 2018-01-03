package com.yangcl.ec.api.erp.service.authentication;

import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthService {
    public String createToken(Map<String, Object> claims) {
        return "error2";
    }

    public LoginAccount createToken(LoginAccount loginAccount) {
        return null;
    }
    public Boolean validateToken(String token) {
        return null;
    }

    public Boolean validateToken(LoginAccount loginAccount) {
        return false;
    }

    public LoginAccount getAccountByToken(String token) {
        return new LoginAccount();
    }
    public JsonResult<LoginAccount> loginIn(LoginAccount loginAccount) {
        JsonResult<LoginAccount> jsonResult=new JsonResult<LoginAccount>();
        jsonResult.setCode("500");
        jsonResult.setMessage("熔断");
        return jsonResult;
    }

    public JsonResult<LoginAccount> loginValidate(String token) {
        JsonResult<LoginAccount> jsonResult=new JsonResult<LoginAccount>();
        jsonResult.setCode("500");
        jsonResult.setMessage("熔断");
        return jsonResult;
    }
}
