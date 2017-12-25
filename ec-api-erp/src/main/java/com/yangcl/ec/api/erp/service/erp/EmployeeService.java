package com.yangcl.ec.api.erp.service.erp;

import com.github.pagehelper.PageInfo;
import com.yangcl.ec.common.entity.erp.Employee;

import java.util.List;
import java.util.Map;

public interface EmployeeService {

    public long add(Employee employee);
    public long remove(long sysno);
    public long edit(Employee employee);
    public Employee get(long sysno);
    public PageInfo<Employee> select(Map<String,Object> where);
    public List<Employee> selectByDepartmentSysNo(long sysno);
}
