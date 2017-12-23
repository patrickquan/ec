/**
 * Feign服务客户端接口，实现熔断
 */
package com.yangcl.ec.api.erp.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="test-service",fallback = TestServiceHystrix.class)
public interface TestService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String hello();
}
