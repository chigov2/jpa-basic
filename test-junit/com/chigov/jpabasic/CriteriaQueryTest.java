package com.chigov.jpabasic;

import com.chigov.jpabasic.JpaBasicApplication;
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
import javax.persistence.criteria.*;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class CriteriaQueryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    EntityManager em;

    @Test
    public void jpqlCriteriaAllCourses() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List resultList2 = query.getResultList();
        logger.info("Criteria -> {}",resultList2);
    }

    //Select c From Course c where name like '%90 Steps
    @Test
    public void jpqlCriteriaAllCoursesWhere() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate like = cb.like(courseRoot.get("name"), "%90 steps");
        cq.where(like);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List resultList2 = query.getResultList();
        logger.info("Criteria -> {}",resultList2);
    }

    @Test
    public void jpqlCriteriaAllCoursesWithoutStudents() {
        CriteriaBuilder cb = em.getCriteriaBuilder();

        CriteriaQuery<Course> cq = cb.createQuery(Course.class);

        Root<Course> courseRoot = cq.from(Course.class);

        Predicate studentsIsEmpty = cb.isEmpty(courseRoot.get("students"));
        cq.where(studentsIsEmpty);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List resultList2 = query.getResultList();
        logger.info("Criteria -> {}",resultList2);
    }

    @Test//Select c from Course c JOIN c.students s
    public void join() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
        Root<Course> courseRoot = cq.from(Course.class);

        Join<Object, Object> join = courseRoot.join("students",JoinType.LEFT);

        TypedQuery<Course> query = em.createQuery(cq.select(courseRoot));

        List resultList2 = query.getResultList();
        logger.info("Criteria -> {}",resultList2);
    }
}