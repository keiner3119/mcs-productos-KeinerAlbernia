package com.main.domain.contracts;

import com.main.domain.repositories.ICategoryRepository;
import com.main.domain.repositories.IProductRepository;

public interface IUnityOfWork extends AutoCloseable {
    ICategoryRepository categoryRepository();
    IProductRepository productRepository();
}