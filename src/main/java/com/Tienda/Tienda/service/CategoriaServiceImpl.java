package com.Tienda.Tienda.service;

import com.Tienda.Tienda.dao.CategoriaDao;
import com.Tienda.Tienda.domain.Categoria;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {

    @Autowired
    private CategoriaDao CategoriaDao;
    //@Autowired
    //private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias() {
        return (List<Categoria>) CategoriaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Categoria getCategoria(Categoria categoria) {
        return CategoriaDao.findById(categoria.getIdCategoria()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Categoria categoria) {

        CategoriaDao.save(categoria);

    }

    @Override
    @Transactional
    public void delete(Categoria categoria) {
        CategoriaDao.delete(categoria);
    }
    // Otros metodos
}
