package org.csu.mypetstore.controller;

import org.csu.mypetstore.DAO.CourseDAO;
import org.csu.mypetstore.domain.Course;
import org.csu.mypetstore.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

//@RestController规定返回的是对象
@RestController
@ExposesResourceFor(Course.class)
@RequestMapping("/course")
public class CourseController {
    @Autowired
    CourseDAO courseDAO;

    @Autowired
    private EntityLinks entityLinks;

    //得到一个课程的信息
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable("courseId") int courseId){
        Course course = courseDAO.getOne(courseId);
        course.add(entityLinks.linkForSingleResource(Course.class,courseId).withSelfRel());
        addStudenstLinks(course);
        addBasicLinks(course);
        return course;
    }

    //得到所有的课程
    @GetMapping("/all")
    public List<Course> listCourses(){
        List<Course> list = courseDAO.findAll();
        for(Course c : list){
            c.add(entityLinks.linkForSingleResource(Course.class,c.getCourseid()).withSelfRel());
            addStudenstLinks(c);
            addBasicLinks(c);
        }
        return list;
    }

    //增加一门课程
    @PostMapping("/{courseId}")
    public Course addCourse(Course course,@PathVariable(value = "courseId") int courseId){
        courseDAO.save(course);
        course.add(entityLinks.linkForSingleResource(Course.class,courseId).withSelfRel());
        addStudenstLinks(course);
        addBasicLinks(course);
        return course;
    }

    //删除一个课程
    @DeleteMapping("/{courseId}")
    public List<Course> deleteCourse(Course course,@PathVariable(value = "courseId") int courseId){
        course = courseDAO.getOne(courseId);
        courseDAO.delete(course);
        List<Course> list = courseDAO.findAll();
        for(Course c : list){
            c.add(entityLinks.linkForSingleResource(Course.class,c.getCourseid()).withSelfRel());
            addStudenstLinks(c);
            addBasicLinks(c);
        }
        return list;
    }

    //修改一门课程
    @PutMapping("/{courseId}")
    public Course updateCourse(Course course,@PathVariable(value = "courseId") int courseId){
        course.setCourseid(courseId);
        courseDAO.save(course);
        course.add(entityLinks.linkForSingleResource(Course.class,courseId).withSelfRel());
        addStudenstLinks(course);
        addBasicLinks(course);
        return course;
    }

    private void addStudenstLinks(Course course){
        course.add(entityLinks.linkForSingleResource(Student.class,2).withRel("students"));
        course.add(entityLinks.linkForSingleResource(Student.class,3).withRel("students"));
        course.add(entityLinks.linkForSingleResource(Student.class,4).withRel("students"));
    }

    private void addBasicLinks(Course course){
        course.add(linkTo(methodOn(CourseController.class).addCourse(course,course.getCourseid()+1)).withRel("add"));
        course.add(linkTo(methodOn(CourseController.class).deleteCourse(course,course.getCourseid())).withRel("delete"));
        course.add(linkTo(methodOn(CourseController.class).updateCourse(course,course.getCourseid())).withRel("edit"));
        course.add(linkTo(methodOn(CourseController.class).getCourse(course.getCourseid())).withRel("search"));
    }

    private void addCoursesLinks(Course course){
        course.add(entityLinks.linkForSingleResource(Course.class,1).withRel("courses"));
        course.add(entityLinks.linkForSingleResource(Course.class,2).withRel("courses"));
        course.add(entityLinks.linkForSingleResource(Course.class,3).withRel("courses"));
        course.add(entityLinks.linkForSingleResource(Course.class,4).withRel("courses"));
        course.add(entityLinks.linkForSingleResource(Course.class,5).withRel("courses"));
    }
}
