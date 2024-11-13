package com.main.infrastructure.base;

import com.main.domain.repositories.ICategoryRepository;
import com.main.domain.repositories.IProductRepository;
import com.main.domain.contracts.IUnityOfWork;
import com.main.infrastructure.repositories.CategoryRepository;
import com.main.infrastructure.repositories.ProductRepository;
import jakarta.persistence.EntityManager;
import java.util.function.Supplier;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UnityOfWork implements IUnityOfWork {
    @PersistenceContext
    private EntityManager _entityManager;
    private ICategoryRepository _categoryRepository;
    private IProductRepository _productRepository;

    @Autowired
    public UnityOfWork(EntityManager entityManager) {
        this._entityManager = entityManager;
    }

    public ICategoryRepository categoryRepository() {
        return categoryRepositorySupplier.get();
    }
    private final Supplier<ICategoryRepository> categoryRepositorySupplier =
        () -> _categoryRepository == null
            ? (_categoryRepository = new CategoryRepository(_entityManager))
            : _categoryRepository;

    public IProductRepository productRepository() {
        return productRepositorySupplier.get();
    }
    private final Supplier<IProductRepository> productRepositorySupplier =
        () -> _productRepository == null
            ? (_productRepository = new ProductRepository(_entityManager))
            : _productRepository;

    @Override
    public void close() throws Exception {
    }
}