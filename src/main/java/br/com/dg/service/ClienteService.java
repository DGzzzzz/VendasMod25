package main.java.br.com.dg.service;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.ClienteDAO;
import main.java.br.com.dg.dao.IClienteDAO;
import main.java.br.com.dg.service.generics.GenericService;

public class ClienteService extends GenericService<Cliente, String> implements IClienteService {

    private IClienteDAO clienteDAO;

    public ClienteService(IClienteDAO clienteDAO) {
        this.clienteDAO = new ClienteDAO();
    }

    public Boolean salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
        return true;
    }

    public void alterar(Cliente cliente) {
        clienteDAO.alterar(cliente);
    }

    public void excluir(Cliente cliente) {
        clienteDAO.excluir(cliente);
    }

    public Cliente buscarCPF(String id) {
        return clienteDAO.buscarCPF(id);
    }

    @Override
    public void excluir(String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        clienteDAO.excluir(cliente);
    }
}
