package test.java.br.com.dg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.IProdutoDAO;
import main.java.br.com.dg.mock.ProdutoDaoMock;

public class ProdutoDAOTest {
    private IProdutoDAO produtoDao;

    private Produto produto;

    public ProdutoDAOTest() {
        produtoDao = new ProdutoDaoMock();
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
        Produto produtoConsultado = produtoDao.buscarCodigo(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() {
        Produto produto = new Produto();
        produto.setCodigo("2");
        produto.setNome("Produto 2");
        produto.setDescricao("Descrição 2");
        produto.setPreco(123.45);
        produtoDao.salvar(produto);

        Produto produtoConsultado = produtoDao.buscarCodigo(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
        Assert.assertEquals("Produto 2", produtoConsultado.getNome());
    }

    @Test
    public void alterarProduto() {
        produto.setNome("Produto 2 atualizado");
        produto.setPreco(150.00);
        produto.setDescricao("Descrição 34");
        produtoDao.alterar(produto);

        Produto produtoConsultado = produtoDao.buscarCodigo(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
        Assert.assertEquals("Produto 2 atualizado", produtoConsultado.getNome());
        Assert.assertEquals(Double.valueOf(150.00), produtoConsultado.getPreco());
        Assert.assertEquals("Descrição 34", produtoConsultado.getDescricao());
    }

    @Test
    public void excluirProduto() {
        produtoDao.excluir(produto);

        Produto produtoConsultado = produtoDao.buscarCodigo(produto.getCodigo());
        Assert.assertNull(produtoConsultado);
    }

    @Test
    public void pesquisarProdutoInexistente() {
        Produto produtoConsultado = produtoDao.buscarCodigo("2");
        Assert.assertNull(produtoConsultado);
    }
}
