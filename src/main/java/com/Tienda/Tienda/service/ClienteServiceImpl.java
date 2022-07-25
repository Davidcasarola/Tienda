package com.Tienda.Tienda.service;

import com.Tienda.Tienda.dao.ClienteDao;
import com.Tienda.Tienda.dao.CreditoDao;
import com.Tienda.Tienda.domain.Cliente;
import com.Tienda.Tienda.domain.Credito;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteDao ClienteDao;
    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) ClienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente getCliente(Cliente cliente) {
        return ClienteDao.findById(cliente.getIdCliente()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Cliente cliente) {
        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);
        cliente.setCredito(credito);
        ClienteDao.save(cliente);

    }

    @Override
    @Transactional
    public void delete(Cliente cliente) {
        ClienteDao.delete(cliente);
    }
    // Otros metodos
}
