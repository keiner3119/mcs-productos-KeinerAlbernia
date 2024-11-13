package com.main.application.category.queries;

import com.main.application.category.dtos.CategoryDto;
import com.main.application.category.dtos.ReadCategoriesResponseDto;
import com.main.application.utilities.Constants;
import com.main.domain.contracts.IUnityOfWork;
import com.main.domain.entities.Category;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReadCategoriesQuery {
    private final IUnityOfWork _unityOfWork;

    public ReadCategoriesQuery(IUnityOfWork unityOfWork) {
        this._unityOfWork = unityOfWork;
    }

    public ReadCategoriesResponseDto handle() {
        try {
            List<Category> categories = new ArrayList<>();
            Iterable<Category> categoriesQuerie = this._unityOfWork.categoryRepository().findAll();
            boolean hasData = categoriesQuerie.iterator().hasNext();
            ReadCategoriesResponseDto response = new ReadCategoriesResponseDto();

            if (hasData)
                categoriesQuerie.forEach(categories::add);

            if (!categories.isEmpty())
                response.categories = new CategoryDto().mapCategoriesInCateriesDto(categories);

            response.state = Constants.VALUE_TRUE;
            response.httpStatus = HttpStatus.OK;
            return response;
        } catch (Exception e) {
            ReadCategoriesResponseDto response = new ReadCategoriesResponseDto();
            response.state = Constants.VALUE_FALSE;
            response.message = Constants.MESSAGE_READ_CATEGORIES_INTERNAL_SERVER_ERROR;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}