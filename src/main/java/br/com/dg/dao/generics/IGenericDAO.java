package main.java.br.com.dg.dao.generics;

public interface IGenericDAO<T, ID> {
    Boolean salvar(ID id, T entity);
    void alterar(ID id, T entity);
    T buscar(ID id);
    void excluir(Object codigo);    
}
