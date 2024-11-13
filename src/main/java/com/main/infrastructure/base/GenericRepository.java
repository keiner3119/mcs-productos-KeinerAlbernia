package com.main.infrastructure.base;

import com.main.domain.contracts.IGenericRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Repository;

@Repository
public abstract class GenericRepository<T> implements IGenericRepository<T> {

    protected EntityManager entityManager;
    private final Class<T> _entityType;

    protected GenericRepository(Class<T> entityType, EntityManager entityManager) {
        this._entityType = entityType;
        this.entityManager = entityManager;
    }

    public T save(T entity) {
        entityManager.persist(entity);
        return entity;
    }

    public Optional<T> findById(UUID id) {
        T entity = entityManager.find(_entityType, id);
        return Optional.ofNullable(entity);
    }

    public Iterable<T> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(_entityType);
        Root<T> root = criteriaQuery.from(_entityType);
        criteriaQuery.select(root);
        return entityManager.createQuery(criteriaQuery).getResultList();
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entityManager.contains(entity)
            ? entity
            : entityManager.merge(entity));
    }

    public void deleteAll(List<T> entities) {
        entities.forEach(entity -> {
                if (entityManager.contains(entity)) {
                    entityManager.remove(entity);
                } else {
                    entityManager.remove(entityManager.merge(entity));
                }
            });
    }
}