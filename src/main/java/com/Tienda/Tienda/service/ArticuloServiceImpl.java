package com.Tienda.Tienda.service;

import com.Tienda.Tienda.dao.ArticuloDao;
import com.Tienda.Tienda.domain.Articulo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArticuloServiceImpl implements ArticuloService {

      @Autowired
    private ArticuloDao ArticuloDao;
    //@Autowired
    //private CreditoDao creditoDao;

    @Transactional(readOnly = true)
    public List<Articulo> getArticulos() {
        return (List<Articulo>) ArticuloDao.findAll();
    }

    @Transactional(readOnly = true)
    public Articulo getArticulo(Articulo articulo) {
        return ArticuloDao.findById(articulo.getIdArticulo()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Articulo articulo) {

        ArticuloDao.save(articulo);

    }

    @Override
    @Transactional
    public void delete(Articulo articulo) {
        ArticuloDao.delete(articulo);
    }
    // Otros metodos

    @Override
    public List<Articulo> getArticulos(boolean activo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Articulo getArticulos(Articulo articulo) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
