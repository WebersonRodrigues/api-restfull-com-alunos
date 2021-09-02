package com.the4me.pizzariadosmelhores.controller;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Cliente;
import com.the4me.pizzariadosmelhores.service.ClienteServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    
    @Autowired
    ClienteServiceImpl servicoCliente;

    @GetMapping
    public List<Cliente> obterTodos(){
       return servicoCliente.obterTodos();
    }

    @GetMapping("/{id}")
    public Cliente obterPorId(@PathVariable String id){
        /**
         * O @PathVariable pega o id que vem na url e transforma em uma variável ID do tipo String
         */
        return servicoCliente.obterPorId(id);
    }

    @PostMapping
    public Cliente adicionar(@RequestBody Cliente cliente){
        return servicoCliente.adicionar(cliente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        servicoCliente.deletar(id);
    }

    @PutMapping("/{id}")
    public Cliente atualizar(
        @PathVariable String id, 
        @RequestBody Cliente cliente){
            
        return servicoCliente.atualizar(id, cliente);
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
