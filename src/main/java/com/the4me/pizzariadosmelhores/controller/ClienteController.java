package com.the4me.pizzariadosmelhores.controller;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Cliente;
import com.the4me.pizzariadosmelhores.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    ClienteService servicoCliente;

    @GetMapping
    public List<Cliente> obterTodos(){
       return servicoCliente.obterTodos();
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return servicoCliente.adicionar(cliente);
    }

    /**
     * Tipos de escrita
     * 
     * PascalCase: AnaClaraDaSilva
     * camelCase:  anaClaraDaSilva
     * kibab-case: ana-clara
     * snake_case: ana_clara
     */
}
