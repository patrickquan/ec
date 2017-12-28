package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;
@Component
@FeignClient(value = "ec-service-authentication",fallback = AuthServiceHystrix.class)
public interface AuthService {

    @RequestMapping(value = "/auth/token/create",method = RequestMethod.GET)
    public String createToken(Map<String,Object> claims);
    @RequestMapping(value = "/auth/token/validate",method = RequestMethod.GET)
    public Boolean validateToken(String token);
    @RequestMapping(value = "/auth/token/value",method = RequestMethod.GET)
    public Object getValue(String token,String ken);
}
