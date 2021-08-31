package com.the4me.pizzariadosmelhores.service;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Cliente;
import com.the4me.pizzariadosmelhores.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    
    @Autowired
    ClienteRepository repositorioCliente;


    public List<Cliente> obterTodos(){
        // Pega todos os clientes do banco.
        return repositorioCliente.findAll();
    }

    public Cliente adicionar(Cliente cliente){

        // Remover o id para garantir que vou adicionar.
        cliente.setId(null);

        // Metodo save serve para adicionar
        return repositorioCliente.save(cliente);
    }
}
