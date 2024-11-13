package com.main.application.utilities;

public class Constants {
    
    private Constants() {        
    }

    //[KA] Constantes de uso generales dentro de un entorno.
    public static final boolean VALUE_TRUE = true;
    public static final boolean VALUE_FALSE = false;

    //[KA] Constantes de uso para los Commands y Queries de categorías.
    public static final String MESSAGE_CREATE_CATEGORY_CREATED
        = "Se ha creado la categoría con éxito.";
    public static final String MESSAGE_CREATE_CATEGORY_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al registrar la categoría.";
    public static final String MESSAGE_READ_CATEGORY_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al consultar la categoría.";
    public static final String MESSAGE_READ_CATEGORIES_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al consultar las categorías.";
    public static final String MESSAGE_DELETE_CATEGORIES_NO_CONTENT
        = "Se han eliminado las categorías.";
    public static final String MESSAGE_DELETE_CATEGORIES_NOT_FOUND
        = "No se encontró categorías disponibles qué eliminar.";
    public static final String MESSAGE_DELETE_CATEGORIES_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al eliminar las categorías.";
    public static final String MESSAGE_DELETE_CATEGORY_NO_CONTENT
        = "Se ha eliminado la categoría con éxito.";
    public static final String MESSAGE_DELETE_CATEGORY_NOT_FOUND
        = "No se encontró la categoría a eliminar.";
    public static final String MESSAGE_DELETE_CATEGORY_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al eliminar la categoría.";
    public static final String MESSAGE_UPDATE_CATEGORY_OK
        = "Se ha modificado la categoría con éxito.";
    public static final String MESSAGE_UPDATE_CATEGORY_NOT_FOUND
        = "No se encontró la categoría a modificar.";
    public static final String MESSAGE_UPDATE_CATEGORY_NOT_MODIFIED
        = "No se encontró cambio en la información de la categoría a modificar.";
    public static final String MESSAGE_UPDATE_CATEGORY_INTERNAL_SERVER_ERROR
        = "Ha ocurrido un error al modificar la categoría.";
}