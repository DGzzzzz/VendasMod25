package main.java.br.com.dg.dao.generics;

import java.util.HashMap;
import java.util.Map;

public class GenericDAO<T, ID> implements IGenericDAO<T, ID> {

    private Map<ID, T> repository = new HashMap<>();

    @Override
    public Boolean salvar(ID id, T entity) {
        repository.put(id, entity);
        return true;
    }

    @Override
    public void alterar(ID id, T entity) {
        if (repository.containsKey(id)) {
            repository.put(id, entity);
        } else {
            throw new RuntimeException("Registro não encontrado");
        }
    }

    @Override
    public T buscar(ID id) {
        return repository.get(id);
    }

    @Override
    public void excluir(Object codigo) {
        repository.remove(codigo);
    }

}
