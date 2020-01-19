package com.miaostar.repository;

import com.miaostar.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long>, CustomDepartmentRepository {
}
