package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.*;
import com.chigov.jpabasic.repository.CourseRepository;
import com.chigov.jpabasic.repository.EmployeeRepository;
import com.chigov.jpabasic.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaBasicApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;
	@Autowired
	private EmployeeRepository employeeRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//List<Review> reviews = new ArrayList<>();
		//reviews.add(new Review("5"," Normal"));
		//reviews.add(new Review("5"," OK 2"));
		//courseRepository.addReviewForCourse(1003L,reviews);

		//studentRepository.insertHardcodedStudentAndCourse();
		//studentRepository.insertStudentAndCourse(new Student("Mikee"),
		//		new Course("Microservices in 100 steps"));
		//		employeeRepository.insertEmployee(new FullTimeEmployee("Jack", new BigDecimal("1000")));
		//		employeeRepository.insertEmployee(new PartTimeEmployee("Jim", new BigDecimal("50")));
		//		logger.info("Full Time employees ->{}",employeeRepository.retrieveFullTimeEmployees());
		//		logger.info("Part Time employees ->{}",employeeRepository.retrievePartTimeEmployees());
	}
}
