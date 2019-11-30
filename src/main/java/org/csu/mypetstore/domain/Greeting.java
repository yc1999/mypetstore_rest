package org.csu.mypetstore.domain;

import org.springframework.hateoas.ResourceSupport;

public class Greeting extends ResourceSupport {
    //资源类Greeting中不可以有id成员变量，因为其集成的父类
    // ResourceSupport中有一个getId()方法。
    private String content;

    public Greeting(String content){
        this.content = content;
    }

    public String getContent(){
        return content;
    }
}
