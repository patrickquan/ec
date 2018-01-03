package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;

import java.util.List;

/**
 * 在线帐户仓库MySQL的实现
 */
public class MySQLAccountRepositoryImpl implements AccountRepository {
    public void addAccount(LoginAccount loginAccount) {

    }

    public LoginAccount getAccount(String accountId, String sysName) {
        return null;
    }

    public void removeAccount(String accountId, String sysName) {

    }

    public void updateAccount(LoginAccount loginAccount) {

    }

    public List<LoginAccount> getAccounts() {
        return null;
    }
}
