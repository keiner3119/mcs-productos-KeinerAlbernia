package com.main.api.controllers;

import com.main.api.utilities.Constants;
import com.main.application.category.commands.CreateCategoryCommand;
import com.main.application.category.commands.DeleteCategoriesCommand;
import com.main.application.category.commands.DeleteCategoryCommand;
import com.main.application.category.commands.UpdateCategoryCommand;
import com.main.application.category.dtos.*;
import com.main.application.category.queries.ReadCategoriesQuery;
import com.main.application.category.queries.ReadCategoryQuery;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.REQUEST_MAPPING_CATEGORY)
public class CategoryController {
    private final CreateCategoryCommand _createCategoryCommand;
    private final ReadCategoryQuery _readCategoryQuery;
    private final ReadCategoriesQuery _readCategoriesQuery;
    private final UpdateCategoryCommand _updateCategoryCommand;
    private final DeleteCategoryCommand _deleteCategoryCommand;
    private final DeleteCategoriesCommand _deleteCategoriesCommand;

    @Autowired
    public CategoryController(CreateCategoryCommand createCategoryCommand,
            ReadCategoryQuery readCategoryQuery, ReadCategoriesQuery readCategoriesQuery,
            UpdateCategoryCommand updateCategoryCommand, DeleteCategoryCommand deleteCategoryCommand,
            DeleteCategoriesCommand deleteCategoriesCommand) {
        this._createCategoryCommand = createCategoryCommand;
        this._readCategoryQuery = readCategoryQuery;
        this._readCategoriesQuery = readCategoriesQuery;
        this._updateCategoryCommand = updateCategoryCommand;
        this._deleteCategoryCommand = deleteCategoryCommand;
        this._deleteCategoriesCommand = deleteCategoriesCommand;
    }
    
    @PostMapping(Constants.POST_MAPPING_CREATE_CATEGORY)
    public CreateCategoryResponseDto createCategory(@RequestBody CreateCategoryRequestDto category) {
        return _createCategoryCommand.handle(category);
    }
    
    @GetMapping(Constants.GET_MAPPING_READ_CATEGORY)
    public ReadCategoryResponseDto readCategory(@RequestParam(Constants.REQUEST_PARAM_ID_CATEGORY)
            UUID id) {
        return _readCategoryQuery.handle(id);
    }

    @GetMapping(Constants.GET_MAPPING_READ_CATEGORIES)
    public ReadCategoriesResponseDto readCategories() {
        return _readCategoriesQuery.handle();
    }

    @PutMapping(Constants.PUT_MAPPING_UPDATE_CATEGORY)
    public UpdateCategoryResponseDto updateCategory(@RequestBody UpdateCategoryRequestDto category) {
        return _updateCategoryCommand.handle(category);
    }

    @DeleteMapping (Constants.DELETE_MAPPING_DELETE_CATEGORY)
    public DeleteCategoryResponseDto deleteCategory(@RequestParam(Constants.REQUEST_PARAM_ID_CATEGORY)
            UUID id) {
        return _deleteCategoryCommand.handle(id);
    }

    @DeleteMapping (Constants.DELETE_MAPPING_DELETE_CATEGORIES)
    public DeleteCategoriesResponseDto deleteCategories() {
        return _deleteCategoriesCommand.handle();
    }
}