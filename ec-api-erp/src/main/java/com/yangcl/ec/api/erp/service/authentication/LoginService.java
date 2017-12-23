package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(value = "ec-service-authentication",fallback = LoginServiceHystrix.class)
public interface LoginService {

    @RequestMapping(value = "/login/test")
    public String test();
}
