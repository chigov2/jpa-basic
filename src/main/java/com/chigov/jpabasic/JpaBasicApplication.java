package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.entity.Review;
import com.chigov.jpabasic.repository.CourseRepository;
import com.chigov.jpabasic.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class JpaBasicApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository courseRepository;
	@Autowired
	private StudentRepository studentRepository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<Review> reviews = new ArrayList<>();
		reviews.add(new Review("5"," Normal"));
		reviews.add(new Review("5"," OK 2"));
		courseRepository.addReviewForCourse(1003L,reviews);

	}
}
