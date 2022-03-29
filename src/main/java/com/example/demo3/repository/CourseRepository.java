package com.example.demo3.repository;

import com.example.demo3.entity.Course;
import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course,Integer> {
}
