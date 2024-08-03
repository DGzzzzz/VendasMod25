package main.java.br.com.dg.mock;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.IClienteDAO;

public class ClienteDaoMock implements IClienteDAO {

    @Override
	public Boolean salvar(Cliente entity) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public void alterar(Cliente entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente buscarCPF(String id) {
		Cliente cliente = new Cliente();
		cliente.setCpf(id);
		return cliente;
	}

    @Override
    public Boolean salvar(String id, Cliente entity) {
        return true;
    }

    @Override
    public void alterar(String id, Cliente entity) {
    }

    @Override
    public Cliente buscar(String id) {
        Cliente cliente = new Cliente();
		cliente.setCpf(id);
		return cliente;
    }

    @Override
    public void excluir(Object codigo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }

    @Override
    public void excluir(Cliente cliente) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'excluir'");
    }
}
