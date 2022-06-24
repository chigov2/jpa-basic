package com.chigov.jpabasic.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQuery(name = "query_get_all_courses", query = "Select c From Course c")
@NamedQuery(name = "query_get_90_courses",query = "Select c From Course c where name like '%90 steps'")
//@Table(name = "CourseDetails")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    private List<Review> reviews = new ArrayList<>();

    @ManyToMany(mappedBy = "courses")
    @JsonIgnore
    private List<Student> students = new ArrayList<>();

    @CreationTimestamp
    private LocalDateTime createdDate;

    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;

    protected Course() { }

    public Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public List<Review> getReviews() {return reviews;}

    //не нужно, чтобы кто-то мог добавить через сеттер сет - надо по одному
    //public void setReviews(List<Review> reviews) {
    //this.reviews = reviews;
    //}
    public void addReviews(Review review) {
        this.reviews.add(review);
    }
    //также добавить удаление
    public void removeReview(Review review) {
        this.reviews.remove(review);
    }

    public List<Student> getStudents() {return students;}

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Course{" +
                 name + '\'' +
                '}';
    }
}
