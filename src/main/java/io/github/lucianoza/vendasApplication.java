package io.github.lucianoza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@ComponentScan(
        basePackages = {"io.github.lucianoza.repository",
                        "io.github.lucianoza.service",
                        "com.umaoutrabiblioteca.projeto"  } //Outro pacote externo envolvido!
        ) //@ComponentScan Aqui é opcional pois extende @SpringBootApplication, mas se houver outro pacote envolvido, será obrigatório

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
