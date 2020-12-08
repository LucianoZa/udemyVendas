package io.github.lucianoza;

import io.github.lucianoza.domain.entity.Cliente;
import io.github.lucianoza.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class vendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {

            Cliente cliente = new Cliente();
            cliente.setNome("Luciano");
            clientes.salvar(cliente);
            // ou
            clientes.salvar(new Cliente("Outro Cliente"));
            clientes.salvar(new Cliente("Mais um Cliente"));

            List<Cliente> todosClientes = clientes. obterTodos();
            todosClientes.forEach(System.out::println);

        };
    }

    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
    }
}
