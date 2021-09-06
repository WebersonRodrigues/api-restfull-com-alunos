package com.the4me.pizzariadosmelhores.controller;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Produto;
import com.the4me.pizzariadosmelhores.service.ProdutoServiceImpl;

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
@RequestMapping("/api/produtos")
public class ProdutoController {
    
    @Autowired
    ProdutoServiceImpl servicoProduto;

    @GetMapping
    public List<Produto> obterTodos(){
       return servicoProduto.obterTodos();
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable String id){
        /**
         * O @PathVariable pega o id que vem na url e transforma em uma variável ID do tipo String
         */
        return servicoProduto.obterPorId(id);
    }

    @PostMapping
    public Produto adicionar(@RequestBody Produto produto){
        return servicoProduto.adicionar(produto);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable String id){
        servicoProduto.deletar(id);
    }

    @PutMapping("/{id}")
    public Produto atualizar(
        @PathVariable String id, 
        @RequestBody Produto produto){
            
        return servicoProduto.atualizar(id, produto);
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
