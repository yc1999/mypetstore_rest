package org.csu.mypetstore.controller;

import java.util.List;

import org.csu.mypetstore.domain.Student;
import org.csu.mypetstore.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student s = studentDAO.getOne(id);
        return s;
    }
    @GetMapping("/students")
    public List<Student> listStudents(){
        return studentDAO.findAll();
    }
    @PostMapping("")
    public List<Student> addStudent(Student s){
        studentDAO.save(s);
        return studentDAO.findAll();
    }
    @PutMapping("/{id}")
    public List<Student> updateStudent(Student s){
        studentDAO.save(s);
        return studentDAO.findAll();
    }
    @DeleteMapping("/{id}")
    public List<Student> deleteStudent (Student s){
        studentDAO.delete(s);
        return studentDAO.findAll();
    }
    @GetMapping("/test")
    public String test() {
        return "nihao";
    }
}
