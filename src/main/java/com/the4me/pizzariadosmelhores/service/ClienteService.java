package com.the4me.pizzariadosmelhores.service;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Cliente;
import com.the4me.pizzariadosmelhores.shared.ClienteDTO;

public interface ClienteService {

    List<ClienteDTO> obterTodos();

    ClienteDTO obterPorId(String idCliente);

    ClienteDTO adicionar(ClienteDTO cliente);
    
    Cliente atualizar(String idCliente, Cliente cliente);

    void deletar(String idCliente);

}
