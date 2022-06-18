package com.chigov.jpabasic.repository;

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

    //findById(Long id)
    //Save(Student student) -> insert, update
    //Delete(Long id)

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
}
