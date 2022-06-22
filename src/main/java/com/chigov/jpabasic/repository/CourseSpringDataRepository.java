package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
}
