package org.csu.mypetstore.controller;

import java.util.List;

import org.csu.mypetstore.domain.Student;
import org.csu.mypetstore.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@ExposesResourceFor(Student.class)
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentDAO studentDAO;

    @Autowired
    private EntityLinks entityLinks;

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable("id") int id) {
        Student s = studentDAO.getOne(id);
        s.add(entityLinks.linkForSingleResource(Student.class,id).withSelfRel());
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
