package com.example.demo3.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {
    @Id
    @Column(name = "Student_ID")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Surname")
    private String surname;

    @ManyToMany
            @JoinTable(name = "Students_Courses",
                    joinColumns = @JoinColumn(name="Student_ID"),
                    inverseJoinColumns = @JoinColumn(name = "Course_ID"))
    List<Course> courses;
    public Student() {
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Student(Integer id, String name, String surname, List<Course> courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.courses = courses;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
