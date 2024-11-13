package com.main.application.product.dtos;

import com.main.application.category.dtos.CategoryDto;
import com.main.domain.entities.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ProductDto {
    public UUID id;
    public CategoryDto categoria;
    //private UUID Imagen;
    public String precio;
    public String cantidad;
    public String idBussines;
    public String disponible;
    public String descripcion;
    public int comision;
    public Boolean estaActivo;

    public ProductDto() {
    }

    private ProductDto(UUID id, CategoryDto categoria, String precio, String cantidad,
            String idBussines, String disponible, String descripcion, int comision,
            Boolean estaActivo) {
        this.id = id;
        this.categoria = categoria;
        //this.Imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idBussines = idBussines;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.comision = comision;
        this.estaActivo = estaActivo;
    }

    public void setDataInDto(UUID id, CategoryDto categoria, String precio, String cantidad,
            String idBussines, String disponible, String descripcion, int comision,
            Boolean estaActivo){
        this.id = id;
        this.categoria = categoria;
        //this.Imagen = imagen;
        this.precio = precio;
        this.cantidad = cantidad;
        this.idBussines = idBussines;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.comision = comision;
        this.estaActivo = estaActivo;
    }

    public ArrayList<ProductDto> mapProductsInProductsDto (List<Product> products) {
        CategoryDto category = new CategoryDto();
        return products.stream()
            .map(product -> new ProductDto(
                product.getId(),
                category.getDataInDto(product.getCategoria().getId(),
                    product.getCategoria().getNombre(), product.getCategoria().getDescripcion()),
                //product.getImagen(),
                product.getPrecio(),
                product.getCantidad(),
                product.getIdBussines(),
                product.getDisponible(),
                product.getDescripcion(),
                product.getComision(),
                product.getEstaActivo()
            ))
            .collect(Collectors.toCollection(ArrayList::new));
    }
}