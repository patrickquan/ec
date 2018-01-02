package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.service.authentication.common.OnlineAccountRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ToolsController {

    @RequestMapping(value = "/tools/accounts",method = RequestMethod.GET)
    public String accountList(Model model){
        List<LoginAccount> accounts=OnlineAccountRepository.getAccounts();
        model.addAttribute("accounts",accounts);
        return "accounts";
    }

    @RequestMapping(value = "/tools/account/remove",method = RequestMethod.GET)
    public String removeAccount(@RequestParam String accountId,@RequestParam String sysName){
        OnlineAccountRepository.removeAccount(accountId,sysName);
        return "redirect:/tools/accounts";
    }
}
