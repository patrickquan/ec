package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.service.authentication.common.OnlineAccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class ToolsController {

    @RequestMapping(value = "/tools/onlines")
    @ResponseBody
    public List<LoginAccount> onlineAccountList(){
        return OnlineAccountRepository.getAccounts();
    }

    @RequestMapping(value = "/test")
    public String test(Model model){
        model.addAttribute("name","Dear");
        return "hello";
    }
}
