package com.gfive.pacientes.menu;

import java.util.Objects;

/**
 * Una opci�n de un men� de la aplicaci�n.
 * @author nicolas
 *
 */
public class Opcion {

    /**
     * N�mero que el usuario debe introducir para seleccionar la opcion. Cada opci�n debe tener un
     * c�digo distinto.
     */
    private final int codigo;

    /**
     * Descripci�n de la opci�n amigable para el usuario, mostrada en pantalla.
     */
    private final String descripcion;
    
    /**
     * True si la opci�n significa salir del men� actual, false de lo contrario.
     */
    private final boolean indicaSalir;

    /**
     * Construye la opci�n con c�digo y descripci�n.
     * @param codigo - n�mero usado para seleccionarla.
     * @param descripcion - texto que se muestra al usuario. No puede ser null.
     * @param indicaSalir - true si la opci�n significa ir al men� anterior, false de lo contrario.
     */
    public Opcion(int codigo, String descripcion, boolean indicaSalir) {
        Objects.requireNonNull(descripcion);
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.indicaSalir = indicaSalir;
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
}
