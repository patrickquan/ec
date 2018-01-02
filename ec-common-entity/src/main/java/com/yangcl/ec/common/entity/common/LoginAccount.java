package com.yangcl.ec.common.entity.common;
import java.util.List;

public class LoginAccount {
    private String accountId;
    private String accountName;
    private String otherName;
    private String username;
    private String password;
    private List<String> permissions;
    private String sysName;
    private String token;

    public LoginAccount(){}
    public LoginAccount(String accountId){
        this.accountId=accountId;
    }
    public LoginAccount(String accountId,String accountName){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username="";
        this.password="";
        this.otherName="";
        this.sysName="";
        this.permissions=null;
    }
    public LoginAccount(String accountId,String accountName,String username){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password="";
        this.otherName="";
        this.sysName="";
        this.permissions=null;
    }
    public LoginAccount(String accountId,String accountName,String username,String password){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName="";
        this.sysName="";
        this.permissions=null;
    }
    public LoginAccount(String accountId,String accountName,String username,String password,String otherName){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName=otherName;
        this.sysName="";
        this.permissions=null;
    }
    public LoginAccount(String accountId,String accountName,String username,String password,String otherName,String sysName){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName=otherName;
        this.sysName=sysName;
        this.permissions=null;
    }
    public LoginAccount(String accountId,List<String> permissions){
        this.accountId=accountId;
        this.accountName="";
        this.username="";
        this.password="";
        this.otherName="";
        this.sysName="";
        this.permissions=permissions;
    }
    public LoginAccount(String accountId,String accountName,List<String> permissions){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username="";
        this.password="";
        this.otherName="";
        this.sysName="";
        this.permissions=permissions;
    }
    public LoginAccount(String accountId,String accountName,String username,List<String> permissions){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password="";
        this.otherName="";
        this.sysName="";
        this.permissions=permissions;
    }
    public LoginAccount(String accountId,String accountName,String username,String password,List<String> permissions){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName="";
        this.sysName="";
        this.permissions=permissions;
    }
    public LoginAccount(String accountId,String accountName,String username,String password,String otherName,List<String> permissions){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName=otherName;
        this.sysName="";
        this.permissions=permissions;
    }
    public LoginAccount(String accountId,String accountName,String username,String password,String otherName,String sysName,List<String> permissions){
        this.accountId=accountId;
        this.accountName=accountName;
        this.username=username;
        this.password=password;
        this.otherName=otherName;
        this.sysName=sysName;
        this.permissions=permissions;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }


    public String getSysName() {
        return sysName;
    }

    public void setSysName(String sysName) {
        this.sysName = sysName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
