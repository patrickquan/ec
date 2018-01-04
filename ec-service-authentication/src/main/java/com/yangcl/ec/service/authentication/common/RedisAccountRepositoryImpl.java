package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;

import java.util.List;

/**
 * 在线用户仓库的Redis实现
 */
public class RedisAccountRepositoryImpl implements AccountRepository {
    public void addAccount(LoginAccount loginAccount) {

    }

    public LoginAccount getAccount(String accountId, String sysName) {
        return null;
    }

    public LoginAccount getAccount(String accountId, String sysName, String token) {
        return null;
    }

    public void removeAccount(String accountId, String sysName,String token) {

    }
    public LoginAccount getAccount(String accountId, String sysName, String token,Long expiration) {return null;}

    public LoginAccount getAccount(String accountId, String sysName, String token, Long expiration, Boolean refreshExpiration) {
        return null;
    }

    public LoginAccount getAccount(LoginAccount loginAccount, String token, Long expiration, Boolean refreshExpiration) {
        return null;
    }

    public void updateAccount(LoginAccount loginAccount) {

    }

    public void updateAccount(LoginAccount loginAccount, String token) {

    }

    public List<LoginAccount> getAccounts() {
        return null;
    }
}
