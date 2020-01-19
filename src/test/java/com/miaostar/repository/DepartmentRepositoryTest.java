package com.miaostar.repository;

import com.miaostar.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DepartmentRepositoryTest {

    @Autowired
    DepartmentRepository departmentRepository;

    @Test
    void test() {
        List<Department> departments = departmentRepository.findAllDepartments();
        Assertions.assertNotNull(departments);
    }

}