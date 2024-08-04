package main.java.br.com.dg.mock;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.IClienteDAO;
import main.java.br.com.dg.dao.generics.GenericDAO;

public class ClienteDaoMock extends GenericDAO<Cliente, String> implements IClienteDAO {

    @Override
    public Cliente buscarCPF(String cpf) {
        return buscar(cpf);
    }

    @Override
    public void alterar(Cliente cliente) {
        super.alterar(cliente.getCpf(), cliente);
    }

    @Override
    public void excluir(Cliente cliente) {
        super.excluir(cliente.getCpf());
    }

    @Override
    public Boolean salvar(Cliente cliente) {
        return super.salvar(cliente.getCpf(), cliente);
    }
}
