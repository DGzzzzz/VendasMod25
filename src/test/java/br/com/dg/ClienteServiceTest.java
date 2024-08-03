package test.java.br.com.dg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.IClienteDAO;
import main.java.br.com.dg.exceptions.TipoChaveNaoEncontradaException;
import main.java.br.com.dg.mock.ClienteDaoMock;
import main.java.br.com.dg.service.ClienteService;
import main.java.br.com.dg.service.IClienteService;

public class ClienteServiceTest {

    private IClienteService clienteService;
	
	private Cliente cliente;
	
	public ClienteServiceTest() {
		IClienteDAO dao = new ClienteDaoMock();
		clienteService = new ClienteService(dao);
	}

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf("123456789012");
        cliente.setNome("Douglas");
        cliente.setEnd("Endereço");
        cliente.setNumero(123);
        cliente.setCidade("Cidade");
        cliente.setEstado("Estado");
    } 

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteService.buscarCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() throws TipoChaveNaoEncontradaException {
        Boolean retorno = clienteService.salvar(cliente);
        Assert.assertTrue(retorno);
    }

    @Test
    public void excluirCliente() {
        clienteService.excluir(cliente.getCpf());
    }

    @Test
	public void alterarCliente() throws TipoChaveNaoEncontradaException {
		cliente.setNome("Douglas");
		clienteService.alterar(cliente);
		
		Assert.assertEquals("Douglas", cliente.getNome());
	}
}
