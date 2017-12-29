package com.yangcl.ec.api.erp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/test/login",method = RequestMethod.GET)
    @ResponseBody
    public String testLogin(){
        return "Login Page";
    }

    @RequestMapping(value = "/test/index",method = RequestMethod.GET)
    @ResponseBody
    public String testIndex(){
        return "Index Page";
    }

    @RequestMapping(value = "/test/error",method = RequestMethod.GET)
    @ResponseBody
    public String testError(){
        return "Error Page";
    }
}
