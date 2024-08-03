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
}
