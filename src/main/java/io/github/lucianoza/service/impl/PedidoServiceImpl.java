package io.github.lucianoza.service.impl;

import io.github.lucianoza.domain.repository.Pedidos;
import io.github.lucianoza.service.PedidoService;
import org.springframework.stereotype.Service;

@Service
public class PedidoServiceImpl implements PedidoService {

    private Pedidos repositoryPedidos;

    public PedidoServiceImpl(Pedidos repositoryPedidos) {
        this.repositoryPedidos = repositoryPedidos;
    }
}
