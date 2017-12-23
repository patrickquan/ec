package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

/**
 * 帐户实体类
 */
public class User extends BaseEntity {
    private long sysno;
    private Employee employee;
    private String loginName;
    private String loginPwd;
    private Date lastLoginTime;
    private String lastLoginIp;
    private boolean loginLock;
    private List<Role> roles;

    public long getSysno() {
        return sysno;
    }

    public void setSysno(long sysno) {
        this.sysno = sysno;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public boolean isLoginLock() {
        return loginLock;
    }

    public void setLoginLock(boolean loginLock) {
        this.loginLock = loginLock;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
