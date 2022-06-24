package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Review;
import com.chigov.jpabasic.repository.CourseRepository;
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

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class CourseRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    CourseRepository repository;
    @Autowired
    EntityManager em;

    @Test
    public void findById() {
       Course course = repository.findById(1001L);
      assertEquals("JPA in 50 steps",course.getName());
        System.out.println("hello3");
    }
    @Test
    @Transactional
    public void findByIdFirstLevelCache() {
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

    @Test
    @DirtiesContext
    public void playWithEntityManager() {
        repository.playWithEntityManager();
    }

    @Test
    @Transactional
    public void retrieveReviewsForCourse() {
        Course course = repository.findById(1001L);
        logger.info("{}",course.getReviews());
    }

    @Test
    @Transactional
    public void retrieveCourseForReview() {
        Review review = em.find(Review.class,5001L);
        logger.info("{}",review.getCourse());
    }
}