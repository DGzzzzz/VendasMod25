package main.java.br.com.dg.service;

import main.java.br.com.dg.Cliente;
import main.java.br.com.dg.exceptions.TipoChaveNaoEncontradaException;

public interface IClienteService {

    Boolean salvar(Cliente cliente) throws TipoChaveNaoEncontradaException;

    Cliente buscarCPF(String cpf);

    void excluir(String cpf);

    void alterar(Cliente cliente) throws TipoChaveNaoEncontradaException;

}
