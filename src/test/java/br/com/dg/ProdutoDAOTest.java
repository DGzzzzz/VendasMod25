package test.java.br.com.dg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.IProdutoDAO;
import main.java.br.com.dg.dao.ProdutoDAO;

public class ProdutoDAOTest {
    private IProdutoDAO produtoDao;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDAO();
    }

    @Before
    public void init() {
        produto = new Produto();
        produto.setCodigo("1");
        produto.setNome("Produto");
        produto.setDescricao("Descrição");
        produto.setPreco(123.45);
        produtoDao.salvar(String.valueOf(produto.getCodigo()), produto);
    }

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = produtoDao.buscar(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }
}
