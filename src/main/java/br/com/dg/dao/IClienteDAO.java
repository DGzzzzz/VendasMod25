package main.java.br.com.dg.dao;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.dao.generics.IGenericDAO;

public interface IClienteDAO extends IGenericDAO<Cliente, String> {

    Boolean salvar(Cliente cliente);

    Cliente buscarCPF(String cpf);

    void alterar(Cliente cliente);

    void excluir(Cliente cliente);
}
