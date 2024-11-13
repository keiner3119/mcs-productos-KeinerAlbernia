package com.main.domain.repositories;

import com.main.domain.contracts.IGenericRepository;
import com.main.domain.entities.Category;
import java.util.List;

public interface ICategoryRepository extends IGenericRepository<Category> {
    List<Category> findCategoriesWithoutProducts();
}