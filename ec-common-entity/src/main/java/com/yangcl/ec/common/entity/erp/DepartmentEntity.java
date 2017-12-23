package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import javax.management.relation.Role;
import java.util.List;

public class DepartmentEntity extends BaseEntity {
    private long sysno;
    private String departmentNo;
    private String departmentName;
    private long parentSysno;
    private List<EmployeeEntity> employees;
    private List<RoleEntity> roles;

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

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }
}
