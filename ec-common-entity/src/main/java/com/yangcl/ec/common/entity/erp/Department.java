package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import java.util.List;

/**
 * 部门实体类
 */
public class Department extends BaseEntity {
    private long sysno;
    private String departmentNo;
    private String departmentName;
    private long parentSysno;
    private List<Employee> employees;
    private List<Role> roles;

    public long getSysno() {
        return sysno;
    }

    public void setSysno(long sysno) {
        this.sysno = sysno;
    }

    public String getDepartmentNo() {
        return departmentNo;
    }

    public void setDepartmentNo(String departmentNo) {
        this.departmentNo = departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public long getParentSysno() {
        return parentSysno;
    }

    public void setParentSysno(long parentSysno) {
        this.parentSysno = parentSysno;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
