package com.the4me.pizzariadosmelhores.service;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import com.the4me.pizzariadosmelhores.model.Produto;
import com.the4me.pizzariadosmelhores.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    
    @Autowired
    ProdutoRepository repositorioProduto;

    @Override
    public List<Produto> obterTodos() {
        // Pega todos os Produtos do banco.
        return repositorioProduto.findAll();
    }

    @Override
    public Produto obterPorId(String idProduto) {
        Optional<Produto> Produto = repositorioProduto.findById(idProduto);
       
        if(Produto.isEmpty()){
            throw new InputMismatchException("Produto não encontrado com o ID: " + idProduto);
        }

        return Produto.get();
    }

    @Override
    public Produto adicionar(Produto produto) {
       // Remover o id para garantir que vou adicionar.
       produto.setId(null);

       // Metodo save serve para adicionar
       return repositorioProduto.save(produto);
    }

    @Override
    public void deletar(String idProduto) {
        Optional<Produto> Produto = repositorioProduto.findById(idProduto);

        if(Produto.isEmpty()){
            throw new InputMismatchException("Não é possível deletar o Produto com o ID: " + idProduto + " - Produto não encontrado");
        }

        repositorioProduto.deleteById(idProduto);
    }

    @Override
    public Produto atualizar(String idProduto, Produto produto) {
        // Passando o id do Produto para o proprio Produto.
        // Eles vem separado na requisição  do tipo PUT 
        produto.setId(idProduto);
        
        // Metodo save serve para atualizar
        return repositorioProduto.save(produto);

        /**
         * O metodo save adiciona caso o id seja null, caso tenha id, ele atualiza.
        */
    }


}
