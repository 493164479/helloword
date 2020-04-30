package com.study.qdgxy.controller;

import com.study.qdgxy.pojo.Employee;
import com.study.qdgxy.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/emp")
    public String showEmps(Model model){
        List<Employee> allEmp = employeeService.getAllEmp();
        model.addAttribute("emps",allEmp);
        return "list";
    }

    @GetMapping("/addemp")
    public String addemp(){
        return "add";
    }

    @PostMapping("/addemp")
    public String addemp(Employee employee){
        employeeService.addEmp(employee);
        return "redirect:/emp";
    }

    @GetMapping("/updateemp/{id}")
    public String updateemp(@PathVariable("id") Integer id,Model model){
        Employee empById = employeeService.findEmpById(id);
        model.addAttribute("employee",empById);
        return "modify";
    }


    @PostMapping("/modify/{id}")
    public String updateEmp(@PathVariable("id") Integer id,Employee employee){
        employee.setId(id);
        Date birth = employee.getBirth();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(birth);
        log.info(format);
        employeeService.updateEmp(employee);
        return "redirect:/emp";
    }

    @GetMapping("/deleteemp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeService.deleteEmp(id);
        return "redirect:/emp";
    }
}
