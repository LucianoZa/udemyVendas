package io.github.lucianoza.service;

import io.github.lucianoza.domain.entity.Pedido;
import io.github.lucianoza.rest.dto.PedidoDTO;

public interface PedidoService {

    Pedido salvar(PedidoDTO dto);

}
