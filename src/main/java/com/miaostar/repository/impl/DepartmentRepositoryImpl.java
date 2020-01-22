package com.miaostar.repository.impl;

import com.miaostar.entity.Department;
import com.miaostar.repository.CustomDepartmentRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class DepartmentRepositoryImpl implements CustomDepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Department> findAllDepartments() {

        String sql = "select d.id as id, d.name as name from department d ";

        Query query = entityManager.createNativeQuery(sql, Department.class);

        return (List<Department>) query.getResultList();
    }
}
