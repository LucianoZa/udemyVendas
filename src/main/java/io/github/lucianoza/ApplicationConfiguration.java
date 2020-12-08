package io.github.lucianoza;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

//@Configuration //Marca para Spring scanear esta classe
//   @Profile("development") //Indica que só vai funcionar para o contexto especificado
@Development
public class ApplicationConfiguration {
     @Bean
    public CommandLineRunner executar(){
        return args -> {
            System.out.println("Rodando DEV");
        };
    }


//    @Bean(name = "applicationName") //Se não passar o name ele pega o nome do método por default
//    public String applicationName(){
//        return "Sistema de Vendas 1";
//    }
//
//    @Bean(name = "outroName")
//    public String outroName(){
//        return "Sistema de Vendas 2";
//    }
}
