package com.main.application.category.commands;

import com.main.application.category.dtos.DeleteCategoryResponseDto;
import com.main.application.utilities.Constants;
import com.main.domain.contracts.IUnityOfWork;
import com.main.domain.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

@Service
public class DeleteCategoryCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public DeleteCategoryCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public DeleteCategoryResponseDto handle(UUID id) {
        try {
            Optional<Category> categoryQuerie = this._unityOfWork.categoryRepository().findById(id);
            DeleteCategoryResponseDto response = new DeleteCategoryResponseDto();
            AtomicBoolean wasEliminated = new AtomicBoolean(false);

            categoryQuerie.ifPresent(category -> {
                    this._unityOfWork.categoryRepository().delete(category);
                    wasEliminated.set(true);
                });

            if (wasEliminated.get()) {
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_DELETE_CATEGORY_NO_CONTENT;
                response.httpStatus = HttpStatus.NO_CONTENT;
            } else {
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_DELETE_CATEGORY_NOT_FOUND;
                response.httpStatus = HttpStatus.NOT_FOUND;
            }

            return response;
        } catch (Exception e) {
            DeleteCategoryResponseDto response = new DeleteCategoryResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_DELETE_CATEGORY_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}