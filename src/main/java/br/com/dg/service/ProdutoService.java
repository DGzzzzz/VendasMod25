package main.java.br.com.dg.service;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.IProdutoDAO;
import main.java.br.com.dg.dao.ProdutoDAO;
import main.java.br.com.dg.service.generics.GenericService;

public class ProdutoService extends GenericService<Produto, String> implements IProdutoService {

    private IProdutoDAO produtoDAO;

    public ProdutoService(IProdutoDAO produtoDao) {
        this.produtoDAO = new ProdutoDAO();
    }

    @Override
    public Produto buscarProduto(Object codigo) {
        return produtoDAO.buscar(String.valueOf(codigo));
    }

    @Override
    public Boolean salvarProduto(Produto produto) {
        produtoDAO.salvar(String.valueOf(produto.getCodigo()), produto);
        return true;
    }

    @Override
    public void excluirProduto(Object codigo) {
        produtoDAO.excluir(codigo);
    }

    @Override
    public void alterarProduto(Produto produto) {
        produtoDAO.alterar(String.valueOf(produto.getCodigo()), produto);
        produtoDAO.alterar(String.valueOf(produto.getNome()), produto);
        produtoDAO.alterar(String.valueOf(produto.getDescricao()), produto);
        produtoDAO.alterar(String.valueOf(produto.getPreco()), produto);
    }
}
