package com.chigov.jpabasic.entity;

import javax.persistence.*;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String rating;

    protected Review() { }

    public Review(String rating,String description) {
        this.rating = rating;
        this.description = description;
    }

    public String getRating() {return rating; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Review{" + rating + description +'\'' + '}';
    }
}
