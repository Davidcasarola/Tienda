package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.domain.Cliente;
import com.Tienda.Tienda.service.ArticuloService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Tienda.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j

public class IndexController {

    @Autowired
    private ArticuloService articuloService;

    @GetMapping("/")

    public String inicio(Model model) {

        log.info("Ahora utilizamos MVC");


        
        //var articulos = articuloService.getArticulos(;
        //model.addAttribute("articulos", articulos);


        
        return "index";

    }
    
}
