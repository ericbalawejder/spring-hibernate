package com.mappings.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "course")
public class Course {

    // define our fields
    // define constructors
    // define getter setters
    // define tostring
    // annotate fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name ="instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name ="course_id")
    private List<Review> reviews;

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Instructor getInstructor() throws CloneNotSupportedException {
        return (Instructor) this.instructor.clone();
    }

    public void setInstructor(Instructor instructor) throws CloneNotSupportedException {
        this.instructor = (Instructor) instructor.clone();
    }

    public List<Review> getReviews() {
        return Collections.unmodifiableList(reviews);
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = Collections.unmodifiableList(reviews);
    }

    public void addReview(Review review) {
        if (this.reviews == null) {
            this.reviews = new ArrayList<>();
        }
        this.reviews.add(new Review(review));
    }

    @Override
    public String toString() {
        return "Course [id=" + id + ", title=" + title + "]";
    }

}
