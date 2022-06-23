package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
@Repos
public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
    int countByName(String name);
}
