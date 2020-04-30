package com.study.qdgxy.mapper;

import com.study.qdgxy.pojo.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.relational.core.sql.In;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> getAllEmp();

    void addEmp(Employee employee);

    Employee findEmpByID(@Param("id") Integer id);

    void updateEmp(Employee employee);

    void deleteEmp(@Param("id") Integer id);
}
