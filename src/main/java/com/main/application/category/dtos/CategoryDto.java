package com.main.application.category.dtos;

import com.main.domain.entities.Category;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CategoryDto {
    public UUID id;
    public String nombre;
    public String descripcion;

    public CategoryDto() {
    }

    private CategoryDto(UUID id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void setDataInDto(UUID id, String nombre, String descripcion){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public ArrayList<CategoryDto> mapCategoriesInCateriesDto (List<Category> categories) {
        return categories.stream()
            .map(category -> new CategoryDto(
                category.getId(),
                category.getNombre(),
                category.getDescripcion()
            ))
            .collect(Collectors.toCollection(ArrayList::new));
    }

    public CategoryDto getDataInDto(UUID id, String nombre, String descripcion){
        CategoryDto category = new CategoryDto();
        category.id = id;
        category.nombre = nombre;
        category.descripcion = descripcion;
        return category;
    }
}