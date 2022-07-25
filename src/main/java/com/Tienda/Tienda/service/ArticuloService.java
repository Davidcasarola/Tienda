package com.Tienda.Tienda.service;

import com.Tienda.Tienda.domain.Articulo;
import java.util.List;

public interface ArticuloService {

    public List<Articulo> getArticulos(boolean activo);

    public Articulo getArticulos(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);

}