package com.main.infrastructure.repositories;

import com.main.domain.repositories.IProductRepository;
import com.main.domain.entities.Product;
import com.main.infrastructure.base.GenericRepository;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends GenericRepository<Product> implements IProductRepository {
    
    public ProductRepository(EntityManager entityManager) {
        super(Product.class, entityManager);
    }
}