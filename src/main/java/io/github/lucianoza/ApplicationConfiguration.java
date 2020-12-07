package io.github.lucianoza;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //Marca para Spring scanear esta classe
public class ApplicationConfiguration {

    @Bean(name = "applicationName") //Se não passar o name ele pega o nome do método por default
    public String applicationName(){
        return "Sistema de Vendas 1";
    }

    @Bean(name = "outroName")
    public String outroName(){
        return "Sistema de Vendas 2";
    }
}
