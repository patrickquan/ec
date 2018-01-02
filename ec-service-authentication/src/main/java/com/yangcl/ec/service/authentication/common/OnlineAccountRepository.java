package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;
import sun.rmi.runtime.Log;

import java.util.ArrayList;
import java.util.List;

public class OnlineAccountRepository {
    private static List<LoginAccount> ONLINE_ACCOUNT_LIST=new ArrayList<LoginAccount>();

    //插入在线用户
    public static void addAccount(LoginAccount loginAccount){
        boolean isAdd=true;
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        for(LoginAccount la:las){
            if(la.getAccountId().equals(loginAccount.getAccountId()) && la.getSysName().equals(loginAccount.getSysName())){
                isAdd=false;
            }
        }
        if(isAdd){
            ONLINE_ACCOUNT_LIST.add(loginAccount);
        }
    }

    //获取在线用户
    public static LoginAccount getAccountByUsername(String accountId,String sysName){
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        for(LoginAccount la:las){
            if(la.getAccountId().equals(accountId) && la.getSysName().equals(sysName)){
                return la;
            }
        }
        return null;
    }

    //获取在线用户列表
    public static List<LoginAccount> getAccounts(){
        return ONLINE_ACCOUNT_LIST;
    }
}
