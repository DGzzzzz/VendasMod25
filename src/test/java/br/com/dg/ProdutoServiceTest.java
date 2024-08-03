package test.java.br.com.dg;

import org.junit.Test;
import org.junit.Before;
import org.junit.Assert;

import main.java.br.com.dg.Produto;
import main.java.br.com.dg.dao.IProdutoDAO;
import main.java.br.com.dg.mock.ProdutoDaoMock;
import main.java.br.com.dg.service.IProdutoService;
import main.java.br.com.dg.service.ProdutoService;

public class ProdutoServiceTest {

    private IProdutoService produtoService;

    private Produto produto;

    public ProdutoServiceTest() {
        IProdutoDAO produtoDao = new ProdutoDaoMock();
        produtoService = new ProdutoService(produtoDao);
    }

    @Before
	public void init() {
		produto = new Produto();
		produto.setCodigo("A1");
		produto.setDescricao("Produto 1");
		produto.setNome("Produto 1");
		produto.setPreco(123.45);
	}

    @Test
    public void pesquisarProduto() {
        Produto produtoConsultado = produtoService.buscarProduto(produto.getCodigo());
        Assert.assertNotNull(produtoConsultado);
    }

    @Test
    public void salvarProduto() {
        Boolean produtoSalvo = produtoService.salvarProduto(produto);
        Assert.assertNotNull(produtoSalvo);
    }

    @Test
    public void excluirProduto() {
        produtoService.excluirProduto(produto.getCodigo());
    }

    @Test
    public void alterarProduto() {
        produto.setNome("Produto 2");
        produtoService.alterarProduto(produto);
        Assert.assertEquals("Produto 2", produto.getNome());
    }
}
