package org.csu.mypetstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student")//对应的表
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
//感觉这些就是使用那个jpa所需要的东西
public class Student extends ResourceSupport {
    @Id
    @Column(name = "id")
    private int stuId;

    @Column(name="name")
    private String name;


    @Column(name="age")
    private int age;

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "Student [id="+stuId+", name="+", age="+age+"]";
    }

}
