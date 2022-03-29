package com.example.demo3.controller;
import com.example.demo3.entity.Course;
import com.example.demo3.entity.Student;
import com.example.demo3.repository.CourseRepository;
import com.example.demo3.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@RequestMapping("/student")
public class HelloWorldController {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    CourseRepository courseRepository;
    @GetMapping("/")
    public String index(){
        return "index";
    }
    @GetMapping("/list")
    public String getAllStudent(Model model){
        Iterable<Student> students=studentRepository.findAll();
        model.addAttribute("students",students);
        return "list";
    }
    @GetMapping("/new")
    public String newPage(Model model){
        model.addAttribute("student",new Student());
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("allCourses",courses);
        return "add";

    }
    @PostMapping("/save")
    public String addAStudent(Student student,Model model){
        studentRepository.save(student);
        Iterable<Student> students=studentRepository.findAll();
        model.addAttribute("students",students);
        return "list";
    }
    @GetMapping("/update")
    public String goToUpdate(Model model, @RequestParam Integer id){
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            model.addAttribute("student",student);
        }
        Iterable<Course> courses=courseRepository.findAll();
        model.addAttribute("allCourses",courses);
        return "update";
    }
    @GetMapping("/delete")
    public String goToDeleteStudent(Model model,@RequestParam Integer id){
        Optional<Student> optionalStudent=studentRepository.findById(id);
        if (optionalStudent.isPresent()){
            Student student=optionalStudent.get();
            model.addAttribute("student",student);
        }
        return "delete";
    }
    @PostMapping("/delete")
    public String delete(Model model,Student student){
        studentRepository.delete(student);
        Iterable<Student> students=studentRepository.findAll();
        model.addAttribute("students",students);
        return "list";
    }
}
