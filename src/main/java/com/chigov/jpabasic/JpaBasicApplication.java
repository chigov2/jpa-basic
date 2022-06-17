package com.chigov.jpabasic;

import com.chigov.jpabasic.entity.Course;
import com.chigov.jpabasic.repository.CourseRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaBasicApplication implements CommandLineRunner {
	@Autowired
	private CourseRepository repository;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args) {
		SpringApplication.run(JpaBasicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		//Course course = repository.findById(1001L); // refactor -> introduce variable ctrl + alt + v
		//logger.info("Course 1001 -> {}",course);
		repository.playWithEntityManager();

		//delete
		//repository.deleteById(1001l);

		//		repository.save(new Course("Microservices in 100 steps"));
		//		repository.save(new Course("Angular in 100 steps"));
		//		repository.save(new Course("CSS in 100 steps"));

	}
}
