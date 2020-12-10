package io.github.lucianoza.rest.controller;

import io.github.lucianoza.domain.entity.Produto;
import io.github.lucianoza.domain.repository.Produtos;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {
    private Produtos repositoryProdutos;

    public ProdutoController(Produtos repositoryProdutos) {
        this.repositoryProdutos = repositoryProdutos;
    }

    @GetMapping("/{id}")
    public Produto getProdutoById(@PathVariable Integer id ) {
        return repositoryProdutos
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto Não Encontrado!"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //Informa que deve retornar 201 se Sucesso!
    public Produto save(@RequestBody Produto produto) {
        return repositoryProdutos.save(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void delete(@PathVariable Integer id) { //Delete não tem RequestBody
        repositoryProdutos.findById(id)
                .map(produtoExistente -> {
                    repositoryProdutos.delete(produtoExistente);
                    return produtoExistente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Produto não encontrado!"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                       @RequestBody Produto produto) {
        repositoryProdutos
                .findById(id)
                .map((produtoExistente) ->{
                    produto.setId(produtoExistente.getId());
                    repositoryProdutos.save(produto);
                    return produtoExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Produto Não Encontrado!"));
    }

    @GetMapping
    public List<Produto> find(Produto filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return repositoryProdutos.findAll(example);
    }    
}
