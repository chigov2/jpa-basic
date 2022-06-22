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
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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
        Optional<Course> byId = repository.findById(1001L);

    }


}