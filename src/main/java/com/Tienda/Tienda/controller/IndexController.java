package com.Tienda.Tienda.controller;

import com.Tienda.Tienda.dao.UsuarioDao;
import com.Tienda.Tienda.domain.Carrito;
import com.Tienda.Tienda.domain.CarritoDetalle;
import com.Tienda.Tienda.domain.Cliente;
import com.Tienda.Tienda.domain.Usuario;
import com.Tienda.Tienda.service.ArticuloService;
import com.Tienda.Tienda.service.CarritoDetalleService;
import com.Tienda.Tienda.service.CarritoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.Tienda.Tienda.service.ClienteService;
import static java.lang.Math.log;
import static java.lang.StrictMath.log;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    private ArticuloService articuloService;
    @Autowired
    private CarritoService carritoService;
    @Autowired
    private CarritoDetalleService carritoDetalleService;
    @Autowired
    private UsuarioDao usuarioDao;

    @GetMapping("/")
    public String inicio(Model model, HttpServletRequest request) {
        //Obtener el usuario llegado        
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails user = null;
        if (principal instanceof UserDetails) {
            user = (UserDetails) principal;
        }
        //Validar si es usuario de un cliente        
        boolean esCliente = false;
        if (user.getAuthorities().size() == 1) {
            for (var rol : user.getAuthorities()) {
                if (rol.getAuthority().equals("ROLE_USER")) {
                    esCliente = true;
                }
            }
        }
        if (esCliente) {
            Usuario usuario = usuarioDao.findByUsername(user.getUsername());
            Carrito carrito = carritoService.getCarritoCliente(usuario.getIdCliente());
            request.getSession().setAttribute("idCliente", usuario.getIdCliente());
            request.getSession().setAttribute("idCarrito", carrito.getIdCarrito());
            //Consultar los items            
            List<CarritoDetalle> carritoDetalles = carritoDetalleService.getCarritoDetalles(carrito.getIdCarrito());
            int cantidadArticulosCarrito = carritoDetalles.size();
            model.addAttribute("cantidadArticulosCarrito", cantidadArticulosCarrito);
        }
        log.info("Ahora se usa arquitectura MVC");
        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);
        model.addAttribute("esCliente", esCliente);
        return "index";
    }
}
