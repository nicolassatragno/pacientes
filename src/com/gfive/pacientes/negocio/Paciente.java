package com.gfive.pacientes.negocio;

import java.io.Serializable;

import com.gfive.pacientes.IOUtil;

/**
 * Representa un paciente en el sistema.
 * @author nicolas
 *
 */
public class Paciente implements Serializable {

    /**
     * ID de serie del paciente.
     */
    private static final long serialVersionUID = 1576058131761607034L;

    /**
     * Código que identifica al paciente en el sistema.
     */
    public final String codigo;
    
    /**
     * Nombre completo.
     */
    public final String nombre;
    
    /**
     * Construye un paciente a partir de código y nombre.
     * @param codigo
     * @param nombre
     */
    public Paciente(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }
    
    /**
     * Lee un paciente del teclado.
     * @return el paciente leído.
     */
    public static Paciente leerDelTeclado() {
        return new Paciente(IOUtil.leerCadena("Digite el codigo del paciente: "),
                            IOUtil.leerCadena("Digite el nombre del paciente: "));
    }
    
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }
}
