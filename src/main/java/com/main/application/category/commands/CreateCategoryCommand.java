package com.main.application.category.commands;

import com.main.application.category.dtos.CreateCategoryRequestDto;
import com.main.application.category.dtos.CreateCategoryResponseDto;
import com.main.application.utilities.Constants;
import com.main.domain.entities.Category;
import com.main.domain.contracts.IUnityOfWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreateCategoryCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public CreateCategoryCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public CreateCategoryResponseDto handle(CreateCategoryRequestDto request) {
        try {
            Category category = new Category(request.nombre, request.descripcion);
            Category categorySaved = this._unityOfWork.categoryRepository().save(category);
            CreateCategoryResponseDto response = new CreateCategoryResponseDto();
            response.state = Constants.VALUE_TRUE;
            response.message = Constants.MESSAGE_CREATE_CATEGORY_CREATED;
            response.httpStatus = HttpStatus.CREATED;
            response.category.setDataInDto(categorySaved.getId(), categorySaved.getNombre(), 
                categorySaved.getDescripcion());
            return response;
        } catch (Exception e) {
            CreateCategoryResponseDto response = new CreateCategoryResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_CREATE_CATEGORY_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}