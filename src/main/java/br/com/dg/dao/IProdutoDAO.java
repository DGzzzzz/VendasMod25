package main.java.br.com.dg.dao;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.generics.IGenericDAO;

public interface IProdutoDAO extends IGenericDAO<Produto, String> {
    Produto buscarCodigo(String codigo);
    void alterar(Produto produto);
    void excluir(Produto produto);
    Boolean salvar(Produto produto);
}
