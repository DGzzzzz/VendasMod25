package main.java.br.com.dg.mock;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.IProdutoDAO;

public class ProdutoDaoMock implements IProdutoDAO {

    @Override
    public Boolean salvar(String id, Produto entity) {
        return true;
    }

    @Override
    public Produto buscar(String id) {
        Produto produto = new Produto();
        produto.setCodigo(id);
        return produto;
    }

    @Override
    public void alterar(String id, Produto entity) {
        entity.getCodigo();
        entity.getNome();
        entity.getDescricao();
        entity.getPreco();
    }

    @Override
    public void excluir(Object codigo) {
        Produto produto = new Produto();
        produto.setCodigo(null);
        produto.setNome(null);
        produto.setDescricao(null);
        produto.setPreco(null);
    }   
}
