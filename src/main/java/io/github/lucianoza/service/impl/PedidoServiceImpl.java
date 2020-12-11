package io.github.lucianoza.service.impl;

import io.github.lucianoza.domain.entity.Cliente;
import io.github.lucianoza.domain.entity.ItemPedido;
import io.github.lucianoza.domain.entity.Pedido;
import io.github.lucianoza.domain.entity.Produto;
import io.github.lucianoza.domain.repository.Clientes;
import io.github.lucianoza.domain.repository.ItensPedido;
import io.github.lucianoza.domain.repository.Pedidos;
import io.github.lucianoza.domain.repository.Produtos;
import io.github.lucianoza.exception.RegraNegocioException;
import io.github.lucianoza.rest.dto.ItemPedidoDTO;
import io.github.lucianoza.rest.dto.PedidoDTO;
import io.github.lucianoza.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoServiceImpl implements PedidoService {

    //final torna os argumentos obrigatórios!
    private final Pedidos pedidosRepository;
    private final Clientes clientesRepository;
    private final Produtos produtosRepository;
    private final ItensPedido itensPedidoRepository;

// Substituido por @RequiredArgsConstructor + final nas declarações dos repositórios, pois torna argumentos obrigatórios!
//    public PedidoServiceImpl(Pedidos pedidosRepository, Clientes clientesRepository, Produtos produtosRepository) {
//        this.pedidosRepository = pedidosRepository;
//        this.clientesRepository = clientesRepository;
//        this.produtosRepository = produtosRepository;
//    }

    @Override
    @Transactional
    public Pedido salvar(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clientesRepository
                .findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException("Código de Cliente Inválido!"));
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedidos = converterItens(pedido, dto.getItens());
        pedidosRepository.save(pedido);
        itensPedidoRepository.saveAll(itensPedidos);
        pedido.setItens(itensPedidos);
        return pedido;
    }

    private List<ItemPedido> converterItens(Pedido pedido, List<ItemPedidoDTO> itens) {
        if(itens.isEmpty()) {
            throw new RegraNegocioException("Informe Itens para salvar o pedido!");
        }
        return itens
                .stream()
                .map( dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtosRepository
                            .findById(idProduto)
                            .orElseThrow(
                                    () -> new RegraNegocioException(
                                            "Código de Produto Inválido! - "+ idProduto
                            ));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidde());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}
