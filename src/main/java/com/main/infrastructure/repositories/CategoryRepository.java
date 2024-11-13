package com.main.infrastructure.repositories;

import com.main.domain.entities.Category;
import com.main.domain.repositories.ICategoryRepository;
import com.main.infrastructure.base.GenericRepository;
import com.main.infrastructure.utilities.Constants;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepository extends GenericRepository<Category> implements ICategoryRepository {

    public CategoryRepository(EntityManager entityManager) {
        super(Category.class, entityManager);
    }

    public List<Category> findCategoriesWithoutProducts() {
        String queryCategoriesWhitoutProducts
            = "SELECT c FROM Category c WHERE c.products IS EMPTY";
        return entityManager.createQuery(queryCategoriesWhitoutProducts, Category.class)
            .getResultList();
    }
}