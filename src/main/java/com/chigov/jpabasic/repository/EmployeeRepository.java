package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepository {
    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //insert employee
    //retrieve employee

    public void insertEmployee(Employee employee){
        em.persist(employee);
    }

    public List<PartTimeEmployee> retrievePartTimeEmployees(){
        return em.createQuery("select p from PartTimeEmployee p", PartTimeEmployee.class).getResultList();
    }
    public List<FullTimeEmployee> retrieveFullTimeEmployees(){
        return em.createQuery("select p from FullTimeEmployee p", FullTimeEmployee.class).getResultList();
    }
}
