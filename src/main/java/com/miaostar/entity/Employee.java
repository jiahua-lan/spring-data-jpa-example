package com.miaostar.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.LinkedHashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Employee extends AbstractPersistable<Long> {

    private String name;

    private String tel;

    private String email;

    @ManyToMany
    private Set<Department> departments = new LinkedHashSet<>();
}
