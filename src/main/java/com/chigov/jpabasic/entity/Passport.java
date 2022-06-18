package com.chigov.jpabasic.entity;

import javax.persistence.*;

@Entity
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String number;

    @OneToOne(fetch = FetchType.LAZY,mappedBy = "passport")
    private Student student;

    protected Passport() { }

    public Passport(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Long getId() {
        return id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    public Student getStudent() {
        return student;
    }

    @Override
    public String toString() {
        return "Passport{" +
                number + '\'' +
                '}';
    }
}
