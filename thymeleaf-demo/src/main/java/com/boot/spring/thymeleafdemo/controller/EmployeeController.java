package com.boot.spring.thymeleafdemo.controller;

import com.boot.spring.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private List<Employee> employees;

    @PostConstruct
    private void loadData() {
        employees = List.of(
                new Employee(1, "Leslie", "Andrews", "leslie@gmail.com"),
                new Employee(2, "Emma", "Baumgarten", "emma@yahoo.com"),
                new Employee(3, "Avani", "Gupta", "avani@fastmail.com"));
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employees);
        return "list-employees";
    }

}
