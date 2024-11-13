package com.main.api.utilities;

public class Constants {
    
    private Constants() {
    }

    //[KA] Constantes para la configuración de los controllers categorías y productos.
    public static final String REQUEST_MAPPING_CATEGORY = "/categorias";
    public static final String REQUEST_MAPPING_PRODUCT = "/productos";

    //Sólo categorías.
    public static final String POST_MAPPING_CREATE_CATEGORY = "/add";
    public static final String GET_MAPPING_READ_CATEGORY = "/any";
    public static final String GET_MAPPING_READ_CATEGORIES = "/all";

    public static final String PUT_MAPPING_UPDATE_CATEGORY = "/update";
    public static final String DELETE_MAPPING_DELETE_CATEGORY = "/delete";
    public static final String DELETE_MAPPING_DELETE_CATEGORIES = "/delete-all";

    public static final String REQUEST_PARAM_ID_CATEGORY = "id";

    //Sólo productos.
    public static final String POST_MAPPING_CREATE_PRODUCT = "/add";
    public static final String GET_MAPPING_READ_PRODUCT = "/any";
    public static final String GET_MAPPING_READ_PRODUCTS = "/all";

    public static final String PUT_MAPPING_UPDATE_PRODUCT = "/update";
    public static final String DELETE_MAPPING_DELETE_PRODUCT = "/delete";
    public static final String DELETE_MAPPING_DELETE_PRODUCTS = "/delete-all";

    public static final String REQUEST_PARAM_ID_PRODUCT = "id";
}