package santander.restaurantapi.service;

public interface CrudService<T, ID> {
    Iterable<T> findAll();
    T findById(ID id);
    T create(T object);
    T update(ID id, T object);
    void deleteById(ID id);

}
