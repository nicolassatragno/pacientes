package com.gfive.pacientes.negocio;

import java.io.Serializable;

import com.gfive.pacientes.IOUtil;

/**
 * Médico registrado en la aplicación.
 * @author nicolas
 *
 */
public class Medico implements Serializable {

    /**
     * ID de serie de serialización.
     */
    private static final long serialVersionUID = 2228623750829747002L;
    
    /**
     * Código del médico en el sistema.
     */
    public final String codigo;

    /**
     * Nombre completo.
     */
    public final String nombre;

    /**
     * Detalle completo de la especialización.
     */
    public final String especializacion;

    /**
     * Construye un médico por parámetros.
     * @param codigo
     * @param nombre
     * @param especializacion
     */
    public Medico(String codigo, String nombre, String especializacion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.especializacion = especializacion;
    }

    /**
     * Lee un médico del teclado.
     * @return el médico leído.
     */
    public static Medico leerDelTeclado() {
        return new Medico(IOUtil.leerCadena("Digite el código del médico: "),
                          IOUtil.leerCadena("Digite el nombre del médico: "),
                          IOUtil.leerCadena("Digite la especialización del médico: "));
    }

}
