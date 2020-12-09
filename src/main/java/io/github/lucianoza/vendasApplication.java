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
            clientes.save(cliente);
            // ou
            clientes.save(new Cliente("Outro Cliente"));
            clientes.save(new Cliente("Mais um Cliente"));

            List<Cliente> todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes---");
            todosClientes.forEach(System.out::println);

            System.out.println("---Altera Todos---");
            todosClientes.forEach(c -> {
                c.setNome(c.getNome() + " atualizado!");
                clientes.save(c);
            });

            System.out.println("---busca Cli e imprime---");
            clientes.findByNomeLike("Cli").forEach(System.out::println);

            todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes Alterados---");
            todosClientes.forEach(System.out::println);

            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
//            System.out.println("deletando cliente");
            //Deletar
//            clientes.obterTodos().forEach(c->{
//                clientes.delete(c);
//            });

            todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes após deleção---");
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum Cliente Encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
    }
}
