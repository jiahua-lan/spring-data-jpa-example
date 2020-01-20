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
@RequestMapping("/employees")
public class EmployeeHandler {

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

}
