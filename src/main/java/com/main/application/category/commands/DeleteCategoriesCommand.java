package com.main.application.category.commands;

import com.main.application.category.dtos.DeleteCategoriesResponseDto;
import com.main.application.utilities.Constants;
import com.main.domain.contracts.IUnityOfWork;
import com.main.domain.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class DeleteCategoriesCommand {
    private final IUnityOfWork _unityOfWork;

    @Autowired
    public DeleteCategoriesCommand(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    @Transactional
    public DeleteCategoriesResponseDto handle() {
        try {
            List<Category> categories = this._unityOfWork.categoryRepository()
                .findCategoriesWithoutProducts();
            DeleteCategoriesResponseDto response = new DeleteCategoriesResponseDto();

            if (!categories.isEmpty()) {
                this._unityOfWork.categoryRepository().deleteAll(categories);
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_DELETE_CATEGORIES_NO_CONTENT;
                response.httpStatus = HttpStatus.NO_CONTENT;
            } else {
                response.state = Constants.VALUE_TRUE;
                response.message = Constants.MESSAGE_DELETE_CATEGORIES_NOT_FOUND;
                response.httpStatus = HttpStatus.NOT_FOUND;
            }

            return response;
        } catch (Exception e) {
            DeleteCategoriesResponseDto response = new DeleteCategoriesResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_DELETE_CATEGORIES_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}