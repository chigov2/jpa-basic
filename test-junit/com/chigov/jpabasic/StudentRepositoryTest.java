package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Passport;
import com.chigov.jpabasic.entity.Student;
import com.chigov.jpabasic.repository.CourseRepository;
import com.chigov.jpabasic.repository.StudentRepository;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaBasicApplication.class)
public class StudentRepositoryTest {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //want to test Course repository
    @Autowired
    StudentRepository repository;
    @Autowired
    EntityManager em;

    @Test
    @Transactional
    public void retrieveStudentAndPassport(){
        Student student = em.find(Student.class, 2001L);
        //если LAZY - сессия завершиласть, как только выполнил find - >
        // add @Transactional !!!!!!!!!!!!!!!!!!!!!!!

        logger.info("student found -> {}",student);
        //нашёл студента, к нему привязан паспорт
        Passport passport = student.getPassport();
        logger.info("passport found -> {}",passport);
    }
    @Test
    //@Transactional
    public void test(){
        repository.someMethodToUnderstandPersistenceContext();
    }

    @Test
    //@Transactional
    public void retrievePassportAndAssociatedStudent(){
        Passport passport = em.find(Passport.class,4002L);
        logger.info("passport 4002 found -> {}",passport);
        Student student = passport.getStudent();
        logger.info("student found -> {}",student);

    }

    @Test
    @Transactional
    public void retrieveStudentAndCourses(){
    Student student = em.find(Student.class,2001L);
    logger.info("student found -> {}",student);
    logger.info("student courses -> {}",student.getCourses());
    }

    @Test
    @Transactional
    public void retrieveCoursesAndStudent(){
        Course course = em.find(Course.class,1001L);
        logger.info("course found -> {}",course);
        logger.info("student courses found -> {}",course.getStudents());

//        Student student = em.find(Student.class,2001L);
//        logger.info("student found -> {}",student);
//        logger.info("student courses -> {}",student.getCourses());
    }
}









