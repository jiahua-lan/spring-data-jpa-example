package com.miaostar.handler;

import com.miaostar.entity.Department;
import com.miaostar.entity.Employee;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping("/departments")
public class DepartmentHandler {

    @GetMapping("/{id}")
    public HttpEntity<?> find(@PathVariable("id") Department department) {
        return ResponseEntity.ok(department);
    }

    @GetMapping("/{id}/employees")
    public HttpEntity<?> findEmployees(@PathVariable("id") Department department) {
        Set<Employee> employees = Collections.emptySet();
        if (Objects.nonNull(department)) {
            employees = department.getEmployees();
        }
        return ResponseEntity.ok(employees);
    }
}
