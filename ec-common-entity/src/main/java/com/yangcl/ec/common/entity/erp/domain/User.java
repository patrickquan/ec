package com.yangcl.ec.common.entity.erp.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 帐户实体类
 */
public class User extends BaseDomain {
    private Long sysno;
    private Employee employee;
    private String loginName;
    private String loginPwd;
    private Date lastLoginTime;
    private String lastLoginIp;
    private Boolean loginLock;
    private List<Role> roles;
    private Long employeeSysno;

    //取得所有权限
    public List<String> getPermissionStringList(){
        List<String> result=new ArrayList<String>();
        for (Role r:roles) {
            for (Permission p:r.getPermissions()){
                if(!result.contains(p.getResource())){
                    result.add(p.getResource());
                }
            }
        }
        return result;
    }

    public Long getSysno() {
        return sysno;
    }

    public void setSysno(Long sysno) {
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

    public Boolean isLoginLock() {
        return loginLock;
    }

    public void setLoginLock(Boolean loginLock) {
        this.loginLock = loginLock;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Long getEmployeeSysno() {
        return employeeSysno;
    }

    public void setEmployeeSysno(Long employeeSysno) {
        this.employeeSysno = employeeSysno;
    }
}
