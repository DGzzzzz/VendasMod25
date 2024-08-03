package main.java.br.com.dg.service.generics;

public interface IGenericService<T, ID> {
    
    void salvar(ID id, T entity);
    
    T buscar(ID id);
    
    void alterar(ID id, T entity);

    void excluir(ID id);

}
