package com.the4me.pizzariadosmelhores.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.the4me.pizzariadosmelhores.model.Cliente;
import com.the4me.pizzariadosmelhores.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {
    
    @Autowired
    ClienteRepository repositorioCliente;

    @Override
    public List<Cliente> obterTodos() {
        // Pega todos os clientes do banco.
        return repositorioCliente.findAll();
    }

    @Override
    public Cliente obterPorId(String idCliente) {
        Optional<Cliente> cliente = repositorioCliente.findById(idCliente);
       
        if(cliente.isEmpty()){
            throw new InputMismatchException("Cliente não encontrado com o ID: " + idCliente);
        }

        return cliente.get();
    }

    @Override
    public Cliente adicionar(Cliente cliente) {
       // Remover o id para garantir que vou adicionar.
       cliente.setId(null);

       // Metodo save serve para adicionar
       return repositorioCliente.save(cliente);
    }

    @Override
    public void deletar(String idCliente) {
        Optional<Cliente> cliente = repositorioCliente.findById(idCliente);

        if(cliente.isEmpty()){
            throw new InputMismatchException("Não é possível deletar o cliente com o ID: " + idCliente + " - Cliente não encontrado");
        }

        repositorioCliente.deleteById(idCliente);
    }

    @Override
    public Cliente atualizar(String idCliente, Cliente cliente) {
        // Passando o id do cliente para o proprio cliente.
        // Eles vem separado na requisição  do tipo PUT 
        cliente.setId(idCliente);
        
        // Metodo save serve para atualizar
        return repositorioCliente.save(cliente);

        /**
         * O metodo save adiciona caso o id seja null, caso tenha id, ele atualiza.
        */
    }


}
