package main.java.br.com.dg.dao;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.generics.GenericDAO;

public class ClienteDAO extends GenericDAO<Cliente, String> implements IClienteDAO {

    @Override
    public Boolean salvar(Cliente cliente) {
        return true;
    }

    @Override
    public Cliente buscarCPF(String cpf) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        return cliente;
    }

    @Override
    public void alterar(Cliente cliente) {
        cliente.getCpf();
        cliente.getNome();
        cliente.getEnd();
        cliente.getCidade();
        cliente.getEstado();
        cliente.getTel();
    }

    @Override
    public void excluir(Cliente cliente) {
        cliente.setCpf(null);
        cliente.setNome(null);
        cliente.setEnd(null);
        cliente.setCidade(null);
        cliente.setEstado(null);
        cliente.setTel(null);
    }

}
