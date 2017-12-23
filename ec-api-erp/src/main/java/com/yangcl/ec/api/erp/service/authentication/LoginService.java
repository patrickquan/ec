package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ec-service-authentication",fallback = LoginServiceHystrix.class)
@RequestMapping(value = "/login")
public interface LoginService {

    @RequestMapping(value = "/member")
    public String memberLogin(String username,String password);

    @RequestMapping(value = "/erp")
    public String erpLogin(String username,String password);
}
