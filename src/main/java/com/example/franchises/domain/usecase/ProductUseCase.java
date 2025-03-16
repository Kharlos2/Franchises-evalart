package com.example.franchises.domain.usecase;

import com.example.franchises.domain.api.IProductServicePort;
import com.example.franchises.domain.models.Product;
import com.example.franchises.domain.spi.IProductPersistencePort;
import com.example.franchises.domain.usecase.validations.ProductValidator;
import reactor.core.publisher.Mono;

public class ProductUseCase implements IProductServicePort {

    private final IProductPersistencePort productPersistencePort;
    private final ProductValidator productValidator;


    public ProductUseCase(IProductPersistencePort productPersistencePort, ProductValidator productValidator) {
        this.productPersistencePort = productPersistencePort;
        this.productValidator = productValidator;
    }

    @Override
    public Mono<Product> save(Product product) {
        return Mono.when(
                productValidator.validateBranchId(product.getBranchId()),
                productValidator.validateBranch(product.getBranchId()),
                productValidator.validateEmptyName(product.getName()),
                productValidator.validateProductNameInBranch(product.getName(), product.getBranchId()),
                productValidator.validateStock(product.getStock())
        ).then(productPersistencePort.save(product));
    }
}
