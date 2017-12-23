package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import javax.management.relation.Role;
import java.util.Date;
import java.util.List;

//员工
public class UserEntity extends BaseEntity {
    private long sysno;
    private EmployeeEntity employee;
    private String loginname;
    private String loginpwd;
    private Date lastlogintime;
    private String lastloginip;
    private boolean loginlock;
    private List<Role> roles;

    public long getSysno() {
        return sysno;
    }

    public void setSysno(long sysno) {
        this.sysno = sysno;
    }

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getLoginpwd() {
        return loginpwd;
    }

    public void setLoginpwd(String loginpwd) {
        this.loginpwd = loginpwd;
    }

    public Date getLastlogintime() {
        return lastlogintime;
    }

    public void setLastlogintime(Date lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    public String getLastloginip() {
        return lastloginip;
    }

    public void setLastloginip(String lastloginip) {
        this.lastloginip = lastloginip;
    }

    public boolean isLoginlock() {
        return loginlock;
    }

    public void setLoginlock(boolean loginlock) {
        this.loginlock = loginlock;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
