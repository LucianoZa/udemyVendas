package io.github.lucianoza.rest.controller;

import io.github.lucianoza.domain.entity.Cliente;
import org.springframework.web.bind.annotation.*;

@RestController // ou @Controller
@RequestMapping("/api/clientes")
public class ClienteController {

    @RequestMapping(
            value = "/hello/{nome}", //Opcional: {"/hello/{nome}", "/api/hello", "/api/etc."}
            method = RequestMethod.GET//,
            //consumes = {"application/json", "application/xml"},  //minetype = o que eu aceito receber!
            //produces = {"application/json", "application/xml"}  // indica formato de saida/retorno do servico
    )
    @ResponseBody // Indicar que o retorno será no Corpo da pagina!
    //Se retornar Objeto Cliente formato indicado por produces!
//            method = RequestMethod.POST,
//    public Cliente helloCliente(@PathVariable("nome") String nomeCliente
//            , @RequestBody Cliente cliente //associado consumes acima, indica formato objeto parametro esperado
//    ) {
//        return cliente;
//    }
// Se retornar String
    public String helloCliente(@PathVariable("nome") String nomeCliente ) {
        return String.format("Hello %s ", nomeCliente);
    }
}
