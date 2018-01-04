package com.yangcl.ec.service.authentication.common;

import com.yangcl.ec.common.entity.common.LoginAccount;

import java.util.List;

/**
 * 在线帐户仓库接口
 */
public interface AccountRepository {
    /**
     * 新增一个帐户
     * @param loginAccount 帐户
     */
    public void addAccount(LoginAccount loginAccount);

    /**
     * 删除一个用户
     * @param accountId 帐户id
     * @param sysName 系统名
     */
    public void removeAccount(String accountId,String sysName,String token);

    /**
     * 更新一个帐户
     * @param loginAccount 帐户
     */
    public void updateAccount(LoginAccount loginAccount);

    /**
     * 更新一个用户
     * @param loginAccount 帐户
     * @param token 原有token
     */
    public void updateAccount(LoginAccount loginAccount,String token);

    /**
     * 获取一个帐户
     * @param accountId 帐户ID
     * @param sysName 系统名
     * @return 账户
     */
    public LoginAccount getAccount(String accountId,String sysName);

    /**
     * 获取一个帐户
     * @param accountId  帐户ID
     * @param sysName  系统名
     * @param token  token
     * @return 帐户
     */
    public LoginAccount getAccount(String accountId,String sysName,String token);

    /**
     * 获取一个帐户
     * @param accountId 帐户ID
     * @param sysName 系统名
     * @param token token
     * @param expiration 过期
     * @return 帐户
     */
    public LoginAccount getAccount(String accountId,String sysName,String token,Long expiration);
    /**
     * 获取一个帐户
     * @param accountId 帐户ID
     * @param sysName 系统名
     * @param token token
     * @param expiration 过期
     * @param refreshExpiration 是否刷新过期时间
     * @return 帐户
     */
    public LoginAccount getAccount(String accountId,String sysName,String token,Long expiration,Boolean refreshExpiration);

    /**
     *
     * @param loginAccount 帐户
     * @param token 当前token
     * @param expiration 过期时间
     * @param refreshExpiration  是否刷新过期时间
     * @return
     */
    public LoginAccount getAccount(LoginAccount loginAccount,String token,Long expiration,Boolean refreshExpiration);

    /**
     * 获取所有帐户
     * @return 帐户列表
     */
    public List<LoginAccount> getAccounts();
}
