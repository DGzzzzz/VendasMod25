package main.java.br.com.dg.dao;


import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.generics.GenericDAO;

public class ProdutoDAO extends GenericDAO<Produto, String> implements IProdutoDAO {
    @Override
    public Produto buscarCodigo(String codigo) {
        return buscar(codigo);
    }

    @Override
    public void alterar(Produto produto) {
        super.alterar(produto.getCodigo(), produto);
    }

    @Override
    public void excluir(Produto produto) {
        super.excluir(produto.getCodigo());
    }

    @Override
    public Boolean salvar(Produto produto) {
        return super.salvar(produto.getCodigo(), produto);
    }    
}
