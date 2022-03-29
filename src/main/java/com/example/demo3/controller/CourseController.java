package com.example.demo3.controller;

import com.example.demo3.entity.Course;
import com.example.demo3.entity.Student;
import com.example.demo3.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.Id;

@Controller
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/courseList")
    public String getAllStudent(Model model){
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("courses",courses);
        return "courseList";
    }
    @GetMapping("/newCourse")
    public String newCourse(Model model){
        model.addAttribute("course",new Course());
        return "addCourse";

    }
    @PostMapping("/saveCourse")
    public String addCourse(Course course,Model model){
        courseRepository.save(course);
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("courses",courses);
        return "courseList";
    }
}
