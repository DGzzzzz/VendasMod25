package main.java.br.com.dg.service;

import main.java.br.com.dg.Produto;

public interface IProdutoService {

    Produto buscarProduto(Object codigo);

    Boolean salvarProduto(Produto produto);

    void excluirProduto(Object codigo);

    void alterarProduto(Produto produto);

}
