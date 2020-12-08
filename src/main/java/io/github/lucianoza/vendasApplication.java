package io.github.lucianoza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication @RestController //veio com spring-boot-starter-web
public class vendasApplication {

//    @Autowired
//    @Qualifier("applicationName")

    @Value("${application.name}") //chave tem que estar em resources\application.properties !
    private String applicationName;

    //@Gato
    @Cachorro
    private Animal animal;

    @Bean(name = "executarAnimal")
    public CommandLineRunner executar() {
        return args -> {
          this.animal.fazerBarulho();
        };
    }

    @GetMapping("/hello") // acessar em http://localhost:8080/hello
    public String HelloWorld(){
        return applicationName;
    }
    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
        //System.out.println("Hello World!");
    }
}
