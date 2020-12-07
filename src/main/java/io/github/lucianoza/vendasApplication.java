package io.github.lucianoza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController //veio com spring-boot-starter-web
public class vendasApplication {

    @Autowired
    @Qualifier("applicationName")
    private String applicationName;

    @GetMapping("/hello") // acessar em http://localhost:8080/hello
    public String HelloWorld(){
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
        //System.out.println("Hello World!");
    }
}
