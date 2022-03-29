package com.example.demo3.repository;


import com.example.demo3.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends CrudRepository<Student,Integer> {
List<Student> findByName(String name);

@Query(value = "select * from student where Surname =?1",nativeQuery = true)
List<Student> getStudentBySurname(String surname);
}
