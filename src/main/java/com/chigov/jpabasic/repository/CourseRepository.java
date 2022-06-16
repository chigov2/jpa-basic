package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
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
            //insert
            em.persist(course);
        }else{
            //update
            em.merge(course);
        }
        return course;
    }

}
