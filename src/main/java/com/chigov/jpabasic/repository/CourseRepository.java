package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


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
        Course course2 = new Course("Angular in 100 Steps");
        em.persist(course2);
        em.flush();

        //em.clear();
        //em.detach(course2);

        course1.setName("Web Services in 10 Steps- Updated");
        course2.setName("Angular in 100 Steps- Updated");

        em.refresh(course1);
        em.flush();
    }
}
