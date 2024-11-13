package com.main.application.category.dtos;

import com.main.application.utilities.ResponseGenericDto;
import java.util.ArrayList;
import java.util.List;

public class ReadCategoriesResponseDto extends ResponseGenericDto {
    public List<CategoryDto> categories = new ArrayList<>();
}