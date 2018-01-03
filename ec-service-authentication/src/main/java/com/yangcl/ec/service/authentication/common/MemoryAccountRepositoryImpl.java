package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 在线用户仓库的内存实现
 */
@Component
public class MemoryAccountRepositoryImpl implements AccountRepository {
    private static List<LoginAccount> ONLINE_ACCOUNT_LIST=new ArrayList<LoginAccount>();

    public void addAccount(LoginAccount loginAccount) {
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

    public LoginAccount getAccount(String accountId, String sysName) {
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        for(LoginAccount la:las){
            if(la.getAccountId().equals(accountId) && la.getSysName().equals(sysName)){
                return la;
            }
        }
        return null;
    }

    public void removeAccount(String accountId, String sysName) {
        for(int i=0;i<ONLINE_ACCOUNT_LIST.size();i++){
            if(ONLINE_ACCOUNT_LIST.get(i).getAccountId().equals(accountId) && ONLINE_ACCOUNT_LIST.get(i).getSysName().equals(sysName)){
                ONLINE_ACCOUNT_LIST.remove(i);
            }
        }
    }

    public List<LoginAccount> getAccounts() {
        List<LoginAccount> las=ONLINE_ACCOUNT_LIST;
        return las;
    }
}
