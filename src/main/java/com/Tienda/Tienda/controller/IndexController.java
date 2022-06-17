package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.domain.Cliente;
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
    private ClienteService clienteService;

    @GetMapping("/")

    public String inicio(Model model) {

        log.info("Ahora utilizamos MVC");

        /* Cliente cliente = new Cliente("David", "Casarola", "david@gmail.com", "6969-4242");

        Cliente cliente02 = new Cliente("007", "Bond", "james@esta.com", "6969-4242");
        Cliente cliente03 = new Cliente("test", "test", "james@esta.com", "6969-4242");
        
        var clientes = Arrays.asList(cliente, cliente02, cliente03);
        
        model.addAttribute("cliente", cliente);
        model.addAttribute("clientes", clientes);
        
       var mensaje = "Semana 04";
        Primer parametro es el nombre del atributo
        , el segundo parámetro es el valor que se envia.model.addAttribute("mensaje", mensaje);  */
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);

        /* var temp = new Cliente();
        temp.setIdCliente(Long.parseLong("1"));
        var cliente = clienteService.getCliente(temp);
        model.addAttribute("cliente", cliente);*/
        return "index";

    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente";
    }

    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/";
    }

    @GetMapping("/modificarCliente/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "modificarCliente";
    }

    @GetMapping("/eliminarCliente/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model) {
        clienteService.delete(cliente);
        return "redirect:/";
    }
}
