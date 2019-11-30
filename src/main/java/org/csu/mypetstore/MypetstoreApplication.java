package org.csu.mypetstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.config.EnableEntityLinks;

@SpringBootApplication
@MapperScan("org.csu.mypetstore.persistence")
//@EnableEntityLinks
public class MypetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(MypetstoreApplication.class, args);
    }

}
