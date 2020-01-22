package com.miaostar.handler;

import com.miaostar.entity.Department;
import com.miaostar.entity.Employee;
import com.miaostar.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/employees")
public class EmployeeHandler {

    private EmployeeRepository employeeRepository;

    @Autowired
    public void setEmployeeRepository(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{id}")
    public HttpEntity<?> find(@PathVariable("id") Employee employee) {
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/{id}/departments")
    public HttpEntity<?> findDepartments(@PathVariable("id") Employee employee) {
        Set<Department> objects = Collections.emptySet();
        if (Objects.nonNull(employee)) {
            objects = employee.getDepartments();
        }
        return ResponseEntity.ok(objects);
    }

    @GetMapping
    public HttpEntity<?> findAll(Employee employee) {
        ExampleMatcher matcher = ExampleMatcher.matching();
        Example<Employee> example = Example.of(employee, matcher);
        List<Employee> employees = employeeRepository.findAll(example);
        return ResponseEntity.ok(employees);
    }

    @GetMapping(params = {"page", "size"})
    public HttpEntity<?> findAll(@PageableDefault Pageable pageable) {
        Page<Employee> page = employeeRepository.findAll(pageable);
        return ResponseEntity.ok(page);
    }

}
