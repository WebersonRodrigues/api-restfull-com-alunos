package com.the4me.pizzariadosmelhores.service;

import java.util.List;

import com.the4me.pizzariadosmelhores.model.Produto;

public interface ProdutoService {

    List<Produto> obterTodos();

    Produto obterPorId(String idProduto);

    Produto adicionar(Produto produto);
    
    Produto atualizar(String idProduto, Produto produto);

    void deletar(String idProduto);

}
