package com.yangcl.ec.api.erp.service.erp.impl;

import com.github.pagehelper.PageHelper;
import com.yangcl.ec.api.erp.mapper.EmployeeMapper;
import com.yangcl.ec.api.erp.service.erp.EmployeeService;
import com.yangcl.ec.common.entity.erp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public List<Employee> selectByDepartmentSysNo(long sysno) {
        return employeeMapper.selectByDepartmentSysNo(sysno);
    }

    public Employee selectBySysno(long sysno) {
        return employeeMapper.getBySysno(sysno);
    }

    public List<Employee> selectByParams(Employee employee,int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        return employeeMapper.selectByParams(employee);
    }
}
