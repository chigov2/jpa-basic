package com.chigov.jpabasic.repository;

import com.chigov.jpabasic.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.aspectj.weaver.tools.cache.SimpleCacheFactory.path;

@RepositoryRe
public interface CourseSpringDataRepository extends JpaRepository<Course,Long> {
    List<Course> findByName(String name);
    int countByName(String name);
}
