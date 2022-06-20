package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Passport;
import com.chigov.jpabasic.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;


//StudentRepository' that could not be found - > missed @Repository
@Repository
@Transactional
public class StudentRepository {
    @Autowired
    EntityManager em;

   private Logger logger = LoggerFactory.getLogger(this.getClass());

   public Student findById(Long id){
        return em.find(Student.class,id);
    }

   public void deleteById(Long id){
        //before deleting must find student
        Student student = findById(id);
        em.remove(student);
    }

    public Student save(Student student){//insert and update
        if (student.getId()==null){
            //insert - create
            em.persist(student);
        }else{
            //update
            em.merge(student);
        }
        return student;
    }

    public void saveStudentWithPassword(){
        Passport passport = new Passport("CX 263698");
        em.persist(passport);//объект должен быть записан в базу
        Student student = new Student("Max Stoba");
        student.setPassport(passport);
        em.persist(student);
    }

    public void someMethodToUnderstandPersistenceContext() {
        Student student = em.find(Student.class, 2001L);
        //persistence context - student
        Passport passport = student.getPassport();
        //persistence context - student + passport
        passport.setNumber("AI 635899");
        //persistence context - student + passport++
        student.setName("Peter->Update");
        //persistence context - student++ and passport++
    }

    public void insertHardcodedStudentAndCourse(){
       Student student = new Student("Jack");
       Course course = new Course("Microservices in 100 steps");
       em.persist(student);
       em.persist(course);

       student.addCourse(course);
       course.addStudent(student);

       em.persist(student);
    }

    public void insertStudentAndCourse(Student student, Course course){
        //student = new Student("Jack");
        //Course course = new Course("Microservices in 100 steps");
        student.addCourse(course);
        course.addStudent(student);
        em.persist(student);
        em.persist(course);

    }
}
