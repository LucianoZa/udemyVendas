package io.github.lucianoza.rest.controller;

import io.github.lucianoza.domain.entity.Cliente;
import io.github.lucianoza.domain.repository.Clientes;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController //<= vem com ResponseBody! ou @Controller diz para scaner e fazer parte do container!
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) { //@autowired esta implicito por que é no construtor!
        this.clientes = clientes;
    }


    @GetMapping("/{id}")
    public Cliente getClienteById(@PathVariable Integer id ) {
        return clientes
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente não encontrado!"));
    }
//    @GetMapping("/{id}") //Substitui RequestMapping
//    public ResponseEntity getClienteById(@PathVariable Integer id ) {
//        Optional<Cliente> cliente = clientes.findById(id); //Optional = trata se não existir!
//
//        if(cliente.isPresent()) {
////            HttpHeaders headers = new HttpHeaders();
////            headers.put("Authorization", "token"); //Exemplo de uso de headers passando token
////            ResponseEntity<Cliente> responseEntity = new ResponseEntity<>(cliente.get(), headers, HttpStatus.OK);
//            return ResponseEntity.ok(cliente.get());
//        }
//        return ResponseEntity.notFound().build();
//    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)  //Informa que deve retornar 201 se Sucesso!
    public Cliente save(@RequestBody Cliente cliente) {
        return clientes.save(cliente);
    }
//    @PostMapping
//    public ResponseEntity save(@RequestBody Cliente cliente) {
//        Cliente clienteSalvo = clientes.save(cliente);
//        return ResponseEntity.ok(clienteSalvo);
//    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //204
    public void delete(@PathVariable Integer id) { //Delete não tem RequestBody
        clientes.findById(id)
                .map(clienteExistente -> {
                    clientes.delete(clienteExistente);
                    return clienteExistente;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Cliente não encontrado!"));
    }

//    @DeleteMapping("/{id}")
//    public ResponseEntity delete(@PathVariable Integer id) { //Delete não tem RequestBody
//        Optional<Cliente> clienteDeletado = clientes.findById(id);
//        if(clienteDeletado.isPresent()) {
//            clientes.delete(clienteDeletado.get());
//            return ResponseEntity.noContent().build(); //noContent por que não precisa retornar nada
//        }
//        return ResponseEntity.notFound().build();
//    }


    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Integer id,
                                 @RequestBody Cliente cliente) {
         clientes
                .findById(id)
                .map((clienteExistente) ->{
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return clienteExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Cliente Não Encontrado!"));
    }
//    @PutMapping("/{id}")
//    public ResponseEntity update(@PathVariable Integer id,
//                                 @RequestBody Cliente cliente) {
//        return clientes.findById(id)
//                .map((clienteExistente) ->{
//                    cliente.setId(clienteExistente.getId());
//                    clientes.save(cliente);
//                    return ResponseEntity.noContent().build();
//                })
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }

    @GetMapping
    public List<Cliente> find( Cliente filtro) {
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filtro, matcher);
        return clientes.findAll(example);
    }

//    @GetMapping
//    public ResponseEntity find( Cliente filtro) {
//        ExampleMatcher matcher = ExampleMatcher
//                .matching()
//                .withIgnoreCase()
//                .withStringMatcher( ExampleMatcher.StringMatcher.CONTAINING);
//
//        Example example = Example.of(filtro, matcher);
//        List<Cliente> lista = clientes.findAll(example);
//        return ResponseEntity.ok(lista);
//    }
}
