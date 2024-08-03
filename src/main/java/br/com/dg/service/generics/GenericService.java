package main.java.br.com.dg.service.generics;

import java.util.HashMap;
import java.util.Map;

public class GenericService<ID, T> implements IGenericService<T, ID> {

    private Map<ID, T> repository = new HashMap<>();

    @Override
    public void salvar(ID id, T entity) {
        repository.put(id, entity);
    }
    
    @Override
    public void alterar(ID id, T entity) {
        if (repository.containsKey(id)) {
            repository.put(id, entity);
        } else {
            throw new IllegalArgumentException("Entity not found");
        }
    }
    
    @Override
    public T buscar(ID id) {
        return repository.get(id);
    }

    @Override
    public void excluir(ID id) {
        repository.remove(id);
    }
}
