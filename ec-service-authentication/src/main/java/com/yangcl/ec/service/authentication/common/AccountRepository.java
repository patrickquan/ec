package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;

import java.util.List;

public interface AccountRepository {
    public void addAccount(LoginAccount loginAccount);
    public LoginAccount getAccount(String accountId,String sysName);
    public void removeAccount(String accountId,String sysName);
    public List<LoginAccount> getAccounts();
}
