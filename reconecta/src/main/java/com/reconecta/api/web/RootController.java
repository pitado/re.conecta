package com.reconecta.api.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    // envia /, /index e /home para a página estática
    @GetMapping({"/", "/index", "/home"})
    public String home() {
        return "forward:/index.html";
    }

    @GetMapping("/clientes")
    public String clientes() {
        return "forward:/clientes.html";
    }

    @GetMapping("/doadores")
    public String doadores() {
        return "forward:/doadores.html";
    }

    @GetMapping("/beneficiarios")
    public String beneficiarios() {
        return "forward:/beneficiarios.html";
    }

    @GetMapping("/doacoes")
    public String doacoes() {
        return "forward:/doacoes.html";
    }
}
