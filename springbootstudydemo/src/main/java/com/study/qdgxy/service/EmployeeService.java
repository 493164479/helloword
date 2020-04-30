package com.study.qdgxy.service;

import com.study.qdgxy.mapper.EmployeeMapper;
import com.study.qdgxy.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> getAllEmp(){
        return employeeMapper.getAllEmp();
    }

    public void addEmp(Employee employee){
        employeeMapper.addEmp(employee);
    }

    public Employee findEmpById(int id){
        return employeeMapper.findEmpByID(id);
    }

    public void updateEmp(Employee employee){
        employeeMapper.updateEmp(employee);
    }

    public void deleteEmp(Integer id){
        employeeMapper.deleteEmp(id);
    }
}
