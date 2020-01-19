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

        Query query = entityManager.createNativeQuery("select * from department", Department.class);

        return (List<Department>) query.getResultList();
    }
}
