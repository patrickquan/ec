package com.yangcl.ec.api.erp.service.authentication;

import com.yangcl.ec.common.entity.common.JsonResult;
import com.yangcl.ec.common.entity.common.LoginAccount;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
@FeignClient(value = "ec-service-authentication",fallback = AuthServiceHystrix.class)
public interface AuthService {
    @RequestMapping(value = "/auth/account/login",method = RequestMethod.POST)
    public JsonResult<LoginAccount> loginIn(LoginAccount loginAccount);
    @RequestMapping(value = "/auth/account/validate",method = RequestMethod.POST)
    public JsonResult<LoginAccount> loginValidate(String token);
}
