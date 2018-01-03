package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 在线用户仓库的内存实现
 */
public class MemoryAccountRepositoryImpl implements AccountRepository {

    //在线用户静态集合
    private static List<LoginAccount> ONLINE_ACCOUNT_LIST=new ArrayList<LoginAccount>();

    public void addAccount(LoginAccount loginAccount) {
        boolean isAdd=true;
        if(isAdd){
            ONLINE_ACCOUNT_LIST.add(loginAccount);
        }
    }
    public LoginAccount getAccount(String accountId, String sysName) {
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        for(LoginAccount la:las){
            if(la.getAccountId().equals(accountId) && la.getSysName().equals(sysName)){
                return la;
            }
        }
        return null;
    }
    public LoginAccount getAccount(String accountId, String sysName, String token) {
        LoginAccount loginAccount=null;
        for(int i=0;i<ONLINE_ACCOUNT_LIST.size();i++){
            LoginAccount la=ONLINE_ACCOUNT_LIST.get(i);
            if(la.getAccountId().equals(accountId) && la.getSysName().equals(sysName) && la.getToken().equals(token)){
                loginAccount=la;
            }
        }
        return null;
    }
    public LoginAccount getAccount(String accountId, String sysName, String token,Long expiration) {
        LoginAccount loginAccount=null;
        for(int i=0;i<ONLINE_ACCOUNT_LIST.size();i++){
            LoginAccount la=ONLINE_ACCOUNT_LIST.get(i);
            if(la.getAccountId().equals(accountId) && la.getSysName().equals(sysName) && la.getToken().equals(token)){
                //判断如果过期则移除登录帐户
                if(la.getLastLoginTime().compareTo(new Date(System.currentTimeMillis()-expiration*1000))<0 ){
                    ONLINE_ACCOUNT_LIST.remove(i);
                }else{
                    loginAccount=la;
                }
            }
        }
        return null;
    }
    public void removeAccount(String accountId, String sysName,String token) {
        for(int i=0;i<ONLINE_ACCOUNT_LIST.size();i++){
            if(ONLINE_ACCOUNT_LIST.get(i).getAccountId().equals(accountId) &&
                    ONLINE_ACCOUNT_LIST.get(i).getSysName().equals(sysName) &&
                    ONLINE_ACCOUNT_LIST.get(i).getToken().equals(token)){
                ONLINE_ACCOUNT_LIST.remove(i);
            }
        }
    }
    public void updateAccount(LoginAccount loginAccount) {
        for(int i=0;i<ONLINE_ACCOUNT_LIST.size();i++){
            if(ONLINE_ACCOUNT_LIST.get(i).getAccountId().equals(loginAccount.getAccountId()) && ONLINE_ACCOUNT_LIST.get(i).getSysName().equals(loginAccount.getSysName())){
                ONLINE_ACCOUNT_LIST.set(i,loginAccount);
            }
        }
    }

    public List<LoginAccount> getAccounts() {
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        return las;
    }
}
