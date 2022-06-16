package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.repository.CourseRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class JpaBasicApplicationTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    CourseRepository repository;

    @Test
    public void findById() {
       Course course = repository.findById(1001L);
      assertEquals("JPA in 50 steps",course.getName());
        System.out.println("hello3");
    }

    @Test
    @DirtiesContext
    public void deleteById() {
        repository.deleteById(1003L);
        assertNull(repository.findById(1003L));
    }

    @Test
    @DirtiesContext
    public void save() {
        //get a course
        Course course = repository.findById(1001L);
        //check the name of the course
        assertEquals("JPA in 50 steps",course.getName());

        //update details
        course.setName("JPA in 50 steps - Update");
        repository.save(course);

        //check the value
        course = repository.findById(1001L);
        assertEquals("JPA in 50 steps - Update", course.getName());
        logger.info(course.getName());
    }
}