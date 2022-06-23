package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Review;
import com.chigov.jpabasic.repository.CourseRepository;
import com.chigov.jpabasic.repository.CourseSpringDataRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class CourseRepositoryJpaTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    CourseSpringDataRepository repository;
    @Autowired
    EntityManager em;

    @Test
    public void findById() {
        Optional<Course> courseOptional = repository.findById(1001L);
        //logger.info("{testtest}",courseOptional.isPresent());
        assertTrue(courseOptional.isPresent());
    }
    @Test
    public void pagination() {
        PageRequest pageRequest = PageRequest.of(0,3);
        Page<Course> pageOne = repository.findAll(pageRequest);
        logger.info("First 3 courses: {}", pageOne.getContent());

        Pageable secondPage = pageOne.nextPageable();

        Page<Course> secondPage1 = repository.findAll(secondPage);

        logger.info("Next pageable element: {}", secondPage1.getContent());
    }

    @Test
    public void findByName(){
        logger.info("Find by name -> {}",repository.findByName("JPA in 50 steps"));
        logger.info("Count by name -> {}",repository.countByName("JPA in 50 steps"));
    }

}