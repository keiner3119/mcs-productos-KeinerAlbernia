package com.main.domain.utilities;

public class Constants {
    
    private Constants() {
    }

    //[KA] Constantes de uso generales dentro de un entorno.
    public static final boolean VALUE_TRUE = true;
    public static final boolean VALUE_FALSE = false;

    //[KA] Anotaciones para los nombres de las tablas.
    public static final String TABLE_NAME_CATEGORY = "TBL_TEST_CATEGORY";
    public static final String TABLE_NAME_PRODUCT = "TBL_TEST_PRODUCT";

    //[KA] Anotaciones para el nombre de columnas de la tabla CATEGORY
    public static final String COLUMN_NAME_ID_CATEGORY = "TBL_TEST_CATEGORY_ID";
    public static final String COLUMN_NAME_IMAGEN_IN_CATEGORY = "TBL_TEST_CATEGORY_ID_IMAGEN_IN_CATEGORY";
    public static final String COLUMN_NAME_NOMBRE_CATEGORY = "TBL_TEST_CATEGORY_NOMBRE";
    public static final String COLUMN_NAME_DESCRIPCION_CATEGORY = "TBL_TEST_CATEGORY_DESCRIPCION";

    //[KA] Anotación de nombre de propiedad de la tabla Category en otra entidad como llave
    public static final String PROPERTY_NAME_OF_CATEGORY = "categoria";

    //[KA] Anotaciones para el nombre de columnas de la tabla PRODUCT
    public static final String COLUMN_NAME_ID_PRODUCT = "TBL_TEST_PRODUCT_ID";
    public static final String COLUMN_NAME_CATEGORY_IN_PRODUCT
        = "TBL_TEST_PRODUCT_ID_CATEGORY_IN_PRODUCT";
    public static final String COLUMN_NAME_PRECIO_PRODUCT = "TBL_TEST_PRODUCT_PRECIO";
    public static final String COLUMN_NAME_CANTIDAD_PRODUCT = "TBL_TEST_PRODUCT_CANTIDAD";
    public static final String COLUMN_NAME_BUSSINES_IN_PRODUCT 
        = "TBL_TEST_PRODUCT_ID_BUSSINES_IN_PRODUCT";
    public static final String COLUMN_NAME_IMAGEN_IN_PRODUCT = "TBL_TEST_PRODUCT_ID_IMAGEN_IN_PRODUCT";
    public static final String COLUMN_NAME_DISPONIBLE_PRODUCT = "TBL_TEST_PRODUCT_DISPONIBLE";
    public static final String COLUMN_NAME_DESCRIPCION_PRODUCT = "TBL_TEST_PRODUCT_DESCRIPCION";
    public static final String COLUMN_NAME_COMISION_PRODUCT = "TBL_TEST_PRODUCT_COMISION";
    public static final String COLUMN_NAME_ESTA_ACTIVO_PRODUCT = "TBL_TEST_PRODUCT_ESTA_ACTIVO";
}