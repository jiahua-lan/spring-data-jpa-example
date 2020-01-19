package com.miaostar.repository;

import com.miaostar.entity.Department;

import java.util.List;

public interface CustomDepartmentRepository {
    List<Department> findAllDepartments();
}
