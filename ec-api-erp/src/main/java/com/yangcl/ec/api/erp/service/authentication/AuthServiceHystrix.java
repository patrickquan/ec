package com.yangcl.ec.api.erp.service.authentication;

import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthService {
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

    public JsonResult<LoginAccount> refreshAccount(String token) {
        JsonResult<LoginAccount> jsonResult=new JsonResult<LoginAccount>();
        jsonResult.setCode("500");
        jsonResult.setMessage("熔断");
        return jsonResult;
    }
}
