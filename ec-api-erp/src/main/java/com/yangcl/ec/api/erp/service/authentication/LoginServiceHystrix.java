package com.yangcl.ec.api.erp.service.authentication;

import org.springframework.stereotype.Component;

@Component
public class LoginServiceHystrix implements LoginService {
    public String test() {
        return "sorry";
    }
}
