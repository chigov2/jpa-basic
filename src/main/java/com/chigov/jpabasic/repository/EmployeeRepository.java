package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Employee;
import com.chigov.jpabasic.entity.Review;
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

    public List<Employee> retrieveAllEmployees(){
        return em.createQuery("select p from Employee p",Employee.class).getResultList();
    }
}
