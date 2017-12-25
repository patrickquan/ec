package com.yangcl.ec.api.erp.mapper;

import com.yangcl.ec.common.entity.erp.Employee;

import java.util.List;

public interface EmployeeMapper {
    public List<Employee> selectByDepartmentSysNo(long sysno);
    public Employee getBySysno(long sysno);
    public List<Employee> selectByParams(Employee employee);
}
