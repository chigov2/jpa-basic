package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Review;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


//CourseRepository' that could not be found - > missed @Repository
@Repository
@Transactional
public class CourseRepository {
    @Autowired
    EntityManager em;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //findById(Long id)
    //Save(Course course) -> insert, update
    //Delete(Long id)

    public Course findById(Long id){
        return em.find(Course.class,id);
    }

    public void deleteById(Long id){
        //before deleting must find course
        Course course = findById(id);
        em.remove(course);
    }

    public Course save(Course course){//insert and update
        if (course.getId()==null){
            //insert - create
            em.persist(course);
        }else{
            //update
            em.merge(course);
        }
        return course;
    }

    public void playWithEntityManager(){
        //logger.info("playWithEntityManager - > Start");
//        Course course = new Course("Web Services in 100 Steps");
//        em.persist(course);
//        course.setName("Web Services in 100 Steps- Updated");

        Course course1 = new Course("Web Services in 100 Steps");
        em.persist(course1);

        Course course2 = findById(1001L);
        course2.setName("JPA in 50 steps - Updated");
//        Course course2 = new Course("Angular in 100 Steps");
//        em.persist(course2);
//        em.flush();

        //em.clear();
        //em.detach(course2);

//        course1.setName("Web Services");
//        em.persist(course1);
//        course2.setName("Angular in 100 Steps- Updated");

        //em.refresh(course1);

    }

    public void addReviewForCourse() {
        //1 получить курс для начала
        Course course = findById(1003L);
        List<Review> reviewsTest = course.getReviews();
        logger.info("1003 reviews -> {}",reviewsTest);

        //2 добавить 2 review 1003
        //создаем
        Review review1 = new Review("3","Course is OK");
        Review review2 = new Review("4","Best!!!");

        //setting the relationship
        course.addReviews(review1);
        //также надо ассоциировать ревью с курсом, т.к. ревью главный
        review1.setCourse(course);

        course.addReviews(review2);
        review2.setCourse(course);

        //3 save it to db
        em.persist(review1);
        em.persist(review2);

        logger.info("1003 reviews -> {}",course.getReviews());

    }
}
