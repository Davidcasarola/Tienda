package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.domain.Cliente;
import com.Tienda.Tienda.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller

public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping("/cliente/nuevo")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/modificar";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        cliente = clienteService.getCliente(cliente);
        model.addAttribute("cliente", cliente);
        return "/cliente/modificar";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente, Model model) {
        clienteService.delete(cliente);
        return "redirect:/cliente/modificar";
    }

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();

        var limiteTotal = 0;
        for (var c : clientes) {
            limiteTotal += c.credito.limite;
        }
        model.addAttribute("limiteTotal", limiteTotal);
        model.addAttribute("totalClientes", clientes.size());

        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }
}
