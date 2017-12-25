package com.yangcl.ec.api.erp.service.erp.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangcl.ec.api.erp.mapper.EmployeeMapper;
import com.yangcl.ec.api.erp.service.erp.EmployeeService;
import com.yangcl.ec.common.entity.erp.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    public long add(Employee employee) {
        return employeeMapper.insert(employee);
    }

    public long remove(long sysno) {
        return employeeMapper.delete(sysno);
    }

    public long edit(Employee employee) {
        return employeeMapper.update(employee);
    }

    public Employee get(long sysno) {
        return employeeMapper.get(sysno);
    }

    public PageInfo<Employee> select(Map<String,Object> where) {
        PageHelper.startPage(Integer.parseInt(where.get("pageNo").toString()),Integer.parseInt(where.get("pageSize").toString()));
        PageInfo<Employee> pageInfo=new PageInfo<Employee>(employeeMapper.select(where));
        return pageInfo;
    }

    public List<Employee> selectByDepartmentSysNo(long sysno) {
        return employeeMapper.selectByDepartmentSysNo(sysno);
    }
}
