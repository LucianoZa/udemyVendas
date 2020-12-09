package io.github.lucianoza.rest.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // ou @Controller
@RequestMapping("/api/clientes")
public class ClienteController {
    @RequestMapping("/hello")
    public String helloCliente(String nomeCliente) {
        return String.format("Hello %s ", nomeCliente);
    }
}
