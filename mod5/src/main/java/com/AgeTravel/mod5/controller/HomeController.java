package com.AgeTravel.mod5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping({"/", "index"})
    public String home () {
        return "index";
    }
    
    @GetMapping({"/destino"}) // nome que aparece na URL
    public String destino() {
        return "destino"; // nome da pagina destino.html
    }
    
    @GetMapping({"/promocoes"})
    public String promocoes() {
        return "promocao";
    }
    
    @GetMapping({"/contato"})
    public String contato() {
        return "contato";
    }
}
