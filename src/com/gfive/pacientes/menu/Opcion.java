package com.gfive.pacientes.menu;

import java.util.Objects;

/**
 * Una opción de un menú de la aplicación.
 * @author nicolas
 *
 */
public class Opcion {

    /**
     * Número que el usuario debe introducir para seleccionar la opcion. Cada opción debe tener un
     * código distinto.
     */
    private final int codigo;

    /**
     * Descripción de la opción amigable para el usuario, mostrada en pantalla.
     */
    private final String descripcion;
    
    /**
     * True si la opción significa salir del menú actual, false de lo contrario.
     */
    private final boolean indicaSalir;
    
    /**
     * Workflow que se ejecuta cuando selecciona la opción. Puede ser null para las opciones que
     * indican salir.
     */
    private final Runnable workflow;

    /**
     * Construye la opción con código y descripción.
     * @param codigo - número usado para seleccionarla.
     * @param descripcion - texto que se muestra al usuario. No puede ser null.
     * @param indicaSalir - true si la opción significa ir al menú anterior, false de lo contrario.
     * @param workflow - función que se ejecuta al seleccionar la opción.
     */
    public Opcion(int codigo, String descripcion, boolean indicaSalir, Runnable workflow) {
        Objects.requireNonNull(descripcion);
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.indicaSalir = indicaSalir;
        this.workflow = workflow;
    }

    public int codigo() {
        return codigo;
    }

    public String descripcion() {
        return descripcion;
    }
    
    public boolean indicaSalir() {
        return indicaSalir;
    }

    public void ejecutar() {
        workflow.run();
    }
}
