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
}
