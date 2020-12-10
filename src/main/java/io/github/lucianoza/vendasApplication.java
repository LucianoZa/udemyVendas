package io.github.lucianoza;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class vendasApplication {

    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
    }
}

/*

    @Bean
    //Criando massa para testar chamada da API
    public CommandLineRunner commandLineRunner(@Autowired Clientes clientes){
        return args -> {
            Cliente c = new Cliente(null, "Fulano");
            clientes.save(c);

            List<Cliente> todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes---");
            todosClientes.forEach(System.out::println);

            Optional<Cliente> cliente = clientes.findById(1);
            if(cliente.isPresent()){
                System.out.println(cliente);
            }

        };

    }

-----------------------------------------------------------------------------------


@SpringBootApplication
public class vendasApplication {

    @Bean
    public CommandLineRunner init(
            @Autowired Clientes clientes,
            @Autowired Pedidos pedidos
    ){
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
                c.setNome(c.getNome() + " atu");
                clientes.save(c);

                //Cria Pedido para o Cliente
                Pedido p = new Pedido();
                p.setCliente(c);
                p.setDataPedido(LocalDate.now());
                p.setTotal(BigDecimal.valueOf(100));

                pedidos.save(p);

                Cliente clientep = clientes.findClienteFetchPedidos(c.getId());
                System.out.println(clientep);
                //System.out.println(clientep.getPedidos());

//            Cliente cliente = clientes.findClienteFetchPedidos(fulano.getId());
//            System.out.println(cliente);
//            System.out.println(cliente.getPedidos());

//                pedidos.findByCliente(fulano).forEach(System.out::println);


            });
            todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes Alterados---");
            todosClientes.forEach(System.out::println);

            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            System.out.println("---busca Cli findByNomeLike e imprime---");
            clientes.findByNomeLike("%Cli%").forEach(System.out::println);
            System.out.println(".");
            System.out.println("---busca Cli encontrarPorNome HQL e imprime---");
            clientes.encontrarPorNomeHQL("Luc").forEach(System.out::println);
            System.out.println(".");
            System.out.println(".");
            System.out.println("---busca Cli encontrarPorNome SQL e imprime---");
            clientes.encontrarPorNomeSQL("Luc%").forEach(System.out::println);
            System.out.println(".");
            System.out.println(".");
            System.out.println(".");
            todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes Alterados---");
            todosClientes.forEach(System.out::println);

            System.out.println("deletando cliente");
            //Deletar
//            clientes.findAll().forEach(c->{
//                clientes.delete(c);
//            });
            //clientes.apagaPorNome("Outro Cliente atualizado!");
            //clientes.deleteByNome("Luciano atualizado!");

            todosClientes = clientes.findAll();
            System.out.println("---Lista Todos Clientes após deleção---");
            if(todosClientes.isEmpty()){
                System.out.println("Nenhum Cliente Encontrado");
            } else {
                todosClientes.forEach(System.out::println);
            }

            System.out.println("---Testa se Existe---");
            boolean existe = clientes.existsByNome("Luciano atualizado!");
            System.out.println("Existe? " + existe);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(vendasApplication.class, args);
    }
}
*/