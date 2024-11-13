package com.main.application.category.queries;

import com.main.application.utilities.Constants;
import com.main.application.category.dtos.ReadCategoryResponseDto;
import com.main.domain.entities.Category;
import com.main.domain.contracts.IUnityOfWork;
import java.util.Optional;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class ReadCategoryQuery {
    private final IUnityOfWork _unityOfWork;

    public ReadCategoryQuery(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }
    
    public ReadCategoryResponseDto handle(UUID id) {
        try {
            Optional<Category> categoryQuerie = this._unityOfWork.categoryRepository().findById(id);
            ReadCategoryResponseDto response = new ReadCategoryResponseDto();
            response.state = Constants.VALUE_TRUE;
            response.httpStatus = HttpStatus.OK;
            categoryQuerie.ifPresent(category -> response.category.setDataInDto(category.getId(),
                category.getNombre(), category.getDescripcion()));
            return response;
        } catch (Exception e) {
            ReadCategoryResponseDto response = new ReadCategoryResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_READ_CATEGORY_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}