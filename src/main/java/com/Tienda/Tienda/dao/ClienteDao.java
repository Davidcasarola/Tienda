package com.Tienda.Tienda.dao;

import com.Tienda.Tienda.domain.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Long> {
    
}
