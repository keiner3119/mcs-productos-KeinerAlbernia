package com.main.domain.contracts;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IGenericRepository<T> {
    T save(T entity);
    Optional<T> findById(UUID id);
    Iterable<T> findAll();
    T update(T entity);
    void delete(T entity);
    void deleteAll(List<T> entities);
}