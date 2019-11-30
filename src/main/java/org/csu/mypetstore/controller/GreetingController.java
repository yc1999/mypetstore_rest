package org.csu.mypetstore.controller;

//import org.csu.mypetstore.domain.Greeting;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.EntityLinks;
//import org.springframework.hateoas.ExposesResourceFor;
//import org.springframework.hateoas.Link;
//import org.springframework.http.HttpEntity;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
import org.csu.mypetstore.domain.Greeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


@RestController
@ExposesResourceFor(Greeting.class)
@RequestMapping(path = "/lists")
public class GreetingController {
    private static final String TEMPLATE = "Hello, %s!";

    @Autowired
    private EntityLinks entityLinks;

    @RequestMapping("/greeting")
    public HttpEntity<Greeting> greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name){
        Greeting greeting = new Greeting(String.format(TEMPLATE,name));
        greeting.add(linkTo(methodOn(GreetingController.class).greeting(name)).withSelfRel());
        greeting.add(new Link("http://localhost:8080/lists/1"));
        greeting.add(new Link("http://localhost:8080/lists/1/items","items"));
        greeting.add(new Link("www.baidu.com"));
        return new ResponseEntity<>(greeting,HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    public HttpEntity<Greeting> lists(@RequestParam(value="name",required = false,defaultValue = "world") String name,@PathVariable(value = "id") String id){
        Greeting greeting = new Greeting(String.format(TEMPLATE,name));
        greeting.add(entityLinks.linkForSingleResource(Greeting.class,1).withSelfRel());
        return new ResponseEntity<>(greeting, HttpStatus.OK);
    }
}
