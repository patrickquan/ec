package com.yangcl.ec.service.authentication.controller;

import com.yangcl.ec.common.entity.common.LoginAccount;
import com.yangcl.ec.service.authentication.common.AccountFactory;
import com.yangcl.ec.service.authentication.common.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
public class ToolsController {

    @Value("${account.repository}")
    private String accountRepositoryName;

    private AccountRepository accountRepository;

    @PostConstruct
    public void  init(){
        AccountFactory accountFactory=new AccountFactory();
        accountRepository=accountFactory.getInstance(accountRepositoryName);
    }

    @RequestMapping(value = "/tools/accounts",method = RequestMethod.GET)
    public String accountList(Model model){
        List<LoginAccount> accounts=accountRepository.getAccounts();
        model.addAttribute("accounts",accounts);
        return "accounts";
    }

    @RequestMapping(value = "/tools/account/remove",method = RequestMethod.GET)
    public String removeAccount(@RequestParam String accountId,@RequestParam String sysName,@RequestParam String token){
        accountRepository.removeAccount(accountId,sysName,token);
        return "redirect:/tools/accounts";
    }
}
