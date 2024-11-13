package com.main.domain.entities;

import com.main.domain.utilities.Constants;
import jakarta.persistence.*;
/*import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;*/
import java.util.List;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;

@Getter
@Entity
@Data
@Table(name = Constants.TABLE_NAME_CATEGORY)
public class Category {

    public Category() {
    }

    public Category(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = Constants.COLUMN_NAME_ID_CATEGORY)
    private UUID id;

    /*
    @OneToOne
    @JoinColumn(name = Constants.COLUMN_NAME_IMAGEN_IN_CATEGORY)
    private UUID Imagen;
    */

    @Column(name = Constants.COLUMN_NAME_NOMBRE_CATEGORY)
    private String nombre;

    @Column(name = Constants.COLUMN_NAME_DESCRIPCION_CATEGORY)
    private String descripcion;

    @OneToMany(mappedBy = Constants.PROPERTY_NAME_OF_CATEGORY, cascade = CascadeType.ALL,
        orphanRemoval = Constants.VALUE_TRUE)
    private List<Product> products;

    public boolean hasChangeTheInformation(String nombre, String descripcion) {
        return !(getNombre().equals(nombre)) || !(getDescripcion().equals(descripcion));
    }

    public void setNewDataForUpdate(String nombre, String descripcion) {
        setNombre(nombre);
        setDescripcion(descripcion);
    }
}