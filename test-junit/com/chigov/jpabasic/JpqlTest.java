package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.Query;
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
        List resultList = em.createNamedQuery("query_get_all_courses").getResultList();
        logger.info("Select c From Course c -> {}",resultList);
        //Select c From Course c -> [Course{Web Services in 100 Steps'},
        // Course{Angular in 100 Steps- Updated'},
        // Course{JPA in 50 steps'},
        // Course{Spring boot in 90 steps'},
        // Course{Hibernate in 500 steps'}]
    }
    @Test
    public void jpql_typed() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_all_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c -> {}",resultList);
        }

    @Test
    public void jpql_where() {
        TypedQuery<Course> query = em.createNamedQuery("query_get_90_courses", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Select c From Course c where name like '%90 Steps' -> {}",resultList);
    }

    @Test//Courses without students -> [Course{Spring boot in 90 steps'}]
    public void jpqlCoursesWithoutStudents() {
        TypedQuery<Course> query = em.createQuery(
                "Select c From Course c where c.students is empty", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses without students -> {}",resultList);

    }


    @Test//courses with more than 2 students
    public void jpqlCoursesWithAtList2Students() {
        TypedQuery<Course> query = em.createQuery(
                "Select c From Course c where size(c.students) >=2", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses where students >=2 -> {}",resultList);
        //Courses where students >=2 -> [Course{JPA in 50 steps'}]
    }

    @Test//how many students courses have
    public void jpqlOrderCoursesWithNumberOfStudents() {
        TypedQuery<Course> query = em.createQuery(
                "Select c From Course c order by size(c.students) desc", Course.class);
        List<Course> resultList = query.getResultList();
        logger.info("Courses ordered by size >=2 -> {}",resultList);
//Courses ordered by size >=2 -> [Course{Spring boot in 90 steps'},
// Course{Hibernate in 500 steps'}, Course{JPA in 50 steps'}]
    }

    @Test//courses with more than 2 students
    public void jpqlWithPassport1234() {
        TypedQuery<Student> query = em.createQuery(
                "Select c From Student c where c.passport.number like '%1234%'", Student.class);
        List<Student> resultList = query.getResultList();
        logger.info("Select c From Student c where c.passport.number like '%1234%' -> {}",resultList);
        //Courses where students >=2 -> [Course{JPA in 50 steps'}]
    }

    @Test
    public void join() {
      Query query = em.createQuery(
                "Select c,s from Course c JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result: resultList){
            logger.info("Course {} Student {}",result[0],result[1]);
        }
    }

    @Test
    public void leftJoin() {
        Query query = em.createQuery(
                "Select c,s from Course c LEFT JOIN c.students s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result: resultList){
            logger.info("Course {} Student {}",result[0],result[1]);
        }
    }

    @Test
    public void crossJoin() {
        Query query = em.createQuery(
                "Select c, s from Course c, Student s");
        List<Object[]> resultList = query.getResultList();
        logger.info("Result size -> {}",resultList.size());
        for (Object[] result: resultList){
            logger.info("Course {} Student {}",result[0],result[1]);
        }
    }
}