package io.github.lucianoza.rest.controller;

import io.github.lucianoza.domain.entity.Cliente;
import io.github.lucianoza.domain.repository.Clientes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController // ou @Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    private Clientes clientes;

    public ClienteController(Clientes clientes) { //@autowired esta implicito por que é no construtor!
        this.clientes = clientes;
    }

    @GetMapping("/{id}") //Substitui RequestMapping
    @ResponseBody
    public ResponseEntity getClienteById(@PathVariable Integer id ) {
        Optional<Cliente> cliente = clientes.findById(id); //Optional = trata se não existir!

        if(cliente.isPresent()) {
//            HttpHeaders headers = new HttpHeaders();
//            headers.put("Authorization", "token"); //Exemplo de uso de headers passando token
//            ResponseEntity<Cliente> responseEntity = new ResponseEntity<>(cliente.get(), headers, HttpStatus.OK);
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity save(@RequestBody Cliente cliente) {
        Cliente clienteSalvo = clientes.save(cliente);
        return ResponseEntity.ok(clienteSalvo);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public ResponseEntity delete(@PathVariable Integer id) { //Delete não tem RequestBody
        Optional<Cliente> clienteDeletado = clientes.findById(id);
        if(clienteDeletado.isPresent()) {
            clientes.delete(clienteDeletado.get());
            return ResponseEntity.noContent().build(); //noContent por que não precisa retornar nada
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public ResponseEntity update(@PathVariable Integer id,
                                 @RequestBody Cliente cliente) {
        return clientes.findById(id)
                .map((clienteExistente) ->{
                    cliente.setId(clienteExistente.getId());
                    clientes.save(cliente);
                    return ResponseEntity.noContent().build();
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
