package org.csu.mypetstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name="course")//对应的表
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Course extends ResourceSupport {

    public int getCourseid() {
        return courseid;
    }

    public void setCourseid(int courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String toString() {
        return getCoursename();
    }

    @Id
    @Column(name = "courseid")
    private int courseid;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "number")
    private int number;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "description")
    private String description;

}
