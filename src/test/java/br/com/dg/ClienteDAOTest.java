package test.java.br.com.dg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.IClienteDAO;
import main.java.br.com.dg.mock.ClienteDaoMock;

public class ClienteDAOTest {

    private IClienteDAO clienteDao;

    private Cliente cliente;

    public ClienteDAOTest() {
        clienteDao = new ClienteDaoMock();
    }

    @Before
    public void init() {
        cliente = new Cliente();
        cliente.setCpf("123456789012");
        cliente.setNome("Fulano");
        cliente.setEnd("Endereço");
        cliente.setNumero(123);
        cliente.setCidade("Cidade");
        cliente.setEstado("Estado");
        clienteDao.salvar(cliente);
    }

    @Test
    public void pesquisarCliente() {
        Cliente clienteConsultado = clienteDao.buscarCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
    }

    @Test
    public void salvarCliente() {
        Cliente cliente = new Cliente();
        cliente.setCpf("987654321098");
        cliente.setNome("Ciclano");
        cliente.setEnd("Endereço");
        cliente.setNumero(123);
        cliente.setCidade("Cidade");
        cliente.setEstado("Estado");
        clienteDao.salvar(cliente);

        Cliente clienteConsultado = clienteDao.buscarCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
        Assert.assertEquals("Ciclano", clienteConsultado.getNome());
    }

    @Test
    public void alterarCliente() {
        cliente.setNome("Ciclano atualizado");
        cliente.setNumero(12344);
        clienteDao.alterar(cliente);

        Cliente clienteConsultado = clienteDao.buscarCPF(cliente.getCpf());
        Assert.assertNotNull(clienteConsultado);
        Assert.assertEquals("Ciclano atualizado", clienteConsultado.getNome());
        Assert.assertEquals(Integer.valueOf(12344), clienteConsultado.getNumero());
    }

    @Test
    public void excluirCliente() {
        Cliente clienteConsultado = clienteDao.buscarCPF(cliente.getCpf());
        clienteDao.excluir(clienteConsultado);

        Cliente clienteExcluido = clienteDao.buscarCPF(cliente.getCpf());
        Assert.assertNull(clienteExcluido);
    }

    @Test
    public void pesquisarClienteInexistente() {
        Cliente clienteConsultado = clienteDao.buscarCPF("987654321098");
        Assert.assertNull(clienteConsultado);
    }
}
