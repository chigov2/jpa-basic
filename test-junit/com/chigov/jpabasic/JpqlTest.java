package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class JpqlTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    EntityManager em;

    @Test
    public void jpql() {
        List resultList = em.createQuery("Select c From Course c").getResultList();
        logger.info("Select c From Course c -> {}",resultList);
        //Select c From Course c -> [Course{Web Services in 100 Steps'},
        // Course{Angular in 100 Steps- Updated'},
        // Course{JPA in 50 steps'},
        // Course{Spring boot in 90 steps'},
        // Course{Hibernate in 500 steps'}]
    }
    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);
        }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createQuery("Select c From Course c where name like '%90 steps'", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c where name like '%90 Steps' -> {}",resultList);
    }

}