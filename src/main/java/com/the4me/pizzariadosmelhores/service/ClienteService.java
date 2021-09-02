package com.the4me.pizzariadosmelhores.service;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Cliente;

public interface ClienteService {

    List<Cliente> obterTodos();

    Cliente obterPorId(String idCliente);

    Cliente adicionar(Cliente cliente);
    
    Cliente atualizar(String idCliente, Cliente cliente);

    void deletar(String idCliente);

}
