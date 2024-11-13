package com.main.api.controllers;

import com.main.api.utilities.Constants;
import com.main.application.product.commands.CreateProductCommand;
import com.main.application.product.commands.DeleteProductsCommand;
import com.main.application.product.commands.DeleteProductCommand;
import com.main.application.product.commands.UpdateProductCommand;
import com.main.application.product.dtos.*;
import com.main.application.product.queries.ReadProductsQuery;
import com.main.application.product.queries.ReadProductQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_PRODUCT)
public class ProductController {
    /*private final CreateProductCommand _createProductCommand;
    private final ReadProductQuery _readProductQuery;
    private final ReadProductsQuery _readProductsQuery;
    private final UpdateProductCommand _updateProductCommand;
    private final DeleteProductCommand _deleteProductCommand;
    private final DeleteProductsCommand _deleteProductsCommand;

    @Autowired
    public ProductController(CreateProductCommand createProductCommand,
            ReadProductQuery readProductQuery, ReadProductsQuery readProductsQuery,
            UpdateProductCommand updateProductCommand, DeleteProductCommand deleteProductCommand,
            DeleteProductsCommand deleteProductsCommand) {
        this._createProductCommand = createProductCommand;
        this._readProductQuery = readProductQuery;
        this._readProductsQuery = readProductsQuery;
        this._updateProductCommand = updateProductCommand;
        this._deleteProductCommand = deleteProductCommand;
        this._deleteProductsCommand = deleteProductsCommand;
    }

    @PostMapping(Constants.POST_MAPPING_CREATE_PRODUCT)
    public CreateProductResponseDto createProduct(@RequestBody CreateProductRequestDto product) {
        return _createProductCommand.handle(product);
    }

    @GetMapping(Constants.GET_MAPPING_READ_PRODUCT)
    public ReadProductResponseDto readProduct(@RequestParam(Constants.REQUEST_PARAM_ID_PRODUCT)
            UUID id) {
        return _readProductQuery.handle(id);
    }

    @GetMapping(Constants.GET_MAPPING_READ_PRODUCTS)
    public ReadProductsResponseDto readProducts() {
        return _readProductsQuery.handle();
    }

    @PutMapping(Constants.PUT_MAPPING_UPDATE_PRODUCT)
    public UpdateProductResponseDto updateProduct(@RequestBody UpdateProductRequestDto product) {
        return _updateProductCommand.handle(product);
    }

    @DeleteMapping (Constants.DELETE_MAPPING_DELETE_PRODUCT)
    public DeleteProductResponseDto deleteProduct(@RequestParam(Constants.REQUEST_PARAM_ID_PRODUCT)
            UUID id) {
        return _deleteProductCommand.handle(id);
    }

    @DeleteMapping (Constants.DELETE_MAPPING_DELETE_PRODUCTS)
    public DeleteProductsResponseDto deleteProducts() {
        return _deleteProductsCommand.handle();
    }*/
}