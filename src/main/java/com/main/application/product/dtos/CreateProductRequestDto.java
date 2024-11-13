package com.main.application.product.dtos;

import com.main.domain.entities.Category;

public class CreateProductRequestDto {
    public Category categoria;
    //public UUID Imagen;
    public String precio;
    public String cantidad;
    public String idBussines;
    public String disponible;
    public String descripcion;
    public int comision;
    public Boolean estaActivo;
}