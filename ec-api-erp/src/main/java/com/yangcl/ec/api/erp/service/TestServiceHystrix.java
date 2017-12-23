/**
 * 熔断器实现
 */
package com.yangcl.ec.api.erp.service;

import org.springframework.stereotype.Component;

@Component
public class TestServiceHystrix implements TestService {
    @Override
    public String hello(){
        return "Soory,error,hystrix success!";
    }
}
