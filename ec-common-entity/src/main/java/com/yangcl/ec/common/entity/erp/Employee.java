package com.yangcl.ec.common.entity.erp;

import com.yangcl.ec.common.entity.BaseEntity;

import java.util.Date;
import java.util.List;

/**
 * 员工实体类
 */
public class Employee extends BaseEntity {
    private Long sysno;
    private Department department;
    private String employeeNo;
    private String employeeName;
    private String employeePhoto;
    private Boolean employeeSex;
    private Date employeeBirthday;
    private String employeeJobTitle;
    private List<User> users;

    public Long getSysno() {
        return sysno;
    }

    public void setSysno(Long sysno) {
        this.sysno = sysno;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeePhoto() {
        return employeePhoto;
    }

    public void setEmployeePhoto(String employeePhoto) {
        this.employeePhoto = employeePhoto;
    }

    public Boolean isEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(Boolean employeeSex) {
        this.employeeSex = employeeSex;
    }

    public Date getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(Date employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeJobTitle() {
        return employeeJobTitle;
    }

    public void setEmployeeJobTitle(String employeeJobTitle) {
        this.employeeJobTitle = employeeJobTitle;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
