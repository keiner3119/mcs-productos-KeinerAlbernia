package com.main.domain.entities;

import com.main.domain.utilities.Constants;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = Constants.TABLE_NAME_PRODUCT)
public class Product {

    public Product() {
    }

    public Product(Category categoria, String precio, String cantidad, String idBussines,
            String disponible, String descripcion, int comision, Boolean estaActivo) {
        this.precio = precio;
        this.cantidad = cantidad;
        this.idBussines = idBussines;
        this.categoria = categoria;
        this.disponible = disponible;
        this.descripcion = descripcion;
        this.comision = comision;
        this.estaActivo = estaActivo;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.COLUMN_NAME_ID_PRODUCT)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = Constants.COLUMN_NAME_CATEGORY_IN_PRODUCT)
    private Category categoria;

    /*
    @OneToOne
    @JoinColumn(name = Constants.COLUMN_NAME_IMAGEN_IN_PRODUCT)
    private UUID Imagen;
    */

    @Column(name = Constants.COLUMN_NAME_PRECIO_PRODUCT)
    private String precio;

    @Column(name = Constants.COLUMN_NAME_CANTIDAD_PRODUCT)
    private String cantidad;

    @Column(name = Constants.COLUMN_NAME_BUSSINES_IN_PRODUCT)
    private String idBussines;

    @Column(name = Constants.COLUMN_NAME_DISPONIBLE_PRODUCT)
    private String disponible;

    @Column(name = Constants.COLUMN_NAME_DESCRIPCION_PRODUCT)
    private String descripcion;

    @Column(name = Constants.COLUMN_NAME_COMISION_PRODUCT)
    private int comision;

    @Column(name = Constants.COLUMN_NAME_ESTA_ACTIVO_PRODUCT)
    private Boolean estaActivo;
}