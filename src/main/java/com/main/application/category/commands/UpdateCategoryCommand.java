package com.main.application.category.commands;

import com.main.application.category.dtos.UpdateCategoryRequestDto;
import com.main.application.category.dtos.UpdateCategoryResponseDto;
import com.main.application.utilities.Constants;
import com.main.domain.contracts.IUnityOfWork;
import com.main.domain.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class UpdateCategoryCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public UpdateCategoryCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public UpdateCategoryResponseDto handle(UpdateCategoryRequestDto request) {
        try {
            Optional<Category> categoryQuerie = this._unityOfWork.categoryRepository().findById(
                request.id);
            UpdateCategoryResponseDto response = new UpdateCategoryResponseDto();
            AtomicReference<Category> categoryModified = new AtomicReference<>(new Category());
            AtomicBoolean wasFound = new AtomicBoolean(false);
            AtomicBoolean wasModified = new AtomicBoolean(false);
            AtomicBoolean changeInformation = new AtomicBoolean(false);

            categoryQuerie.ifPresent(category -> {
                wasFound.set(true);
                boolean hasChangeTheInformation = category.hasChangeTheInformation(request.nombre,
                        request.descripcion
                    );
                if (hasChangeTheInformation) {
                    category.setNewDataForUpdate(request.nombre, request.descripcion);
                    categoryModified.set(this._unityOfWork.categoryRepository().update(category));
                    wasModified.set(true);
                    changeInformation.set(true);
                }
            });

            if (!wasFound.get()){
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_UPDATE_CATEGORY_NOT_FOUND;
                response.httpStatus = HttpStatus.NOT_FOUND;
            } else if (!changeInformation.get()) {
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_UPDATE_CATEGORY_NOT_MODIFIED;
                response.httpStatus = HttpStatus.NOT_MODIFIED;
            } else if (wasModified.get()) {
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_UPDATE_CATEGORY_OK;
                response.httpStatus = HttpStatus.OK;
                response.category.setDataInDto(categoryModified.get().getId(),
                    categoryModified.get().getNombre(), categoryModified.get().getDescripcion());
            }

            return response;
        } catch (Exception e) {
            UpdateCategoryResponseDto response = new UpdateCategoryResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_UPDATE_CATEGORY_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}