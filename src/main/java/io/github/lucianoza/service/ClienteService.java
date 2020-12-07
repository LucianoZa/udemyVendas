package io.github.lucianoza.service;

import io.github.lucianoza.model.Cliente;
import io.github.lucianoza.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    private ClienteRepository repository;

    @Autowired
    //Injeção no próprio construtor = melhor opção e até para testes unitários
    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public void salvarCliente(Cliente cliente) {
        validarCliente(cliente);

        //Se criar uma instancia a cada vez, podera derrubar o sistema
        //vamos injetar a dependencia
        //ClienteRepository clienteRepository = new ClienteRepository();

        this.repository.persistir(cliente);
    }

    private void validarCliente(Cliente cliente) {
        //implementar validacao
    }
}
