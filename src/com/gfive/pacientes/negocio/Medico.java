package com.gfive.pacientes.negocio;

import java.io.Serializable;

import com.gfive.pacientes.IOUtil;

/**
 * M�dico registrado en la aplicaci�n.
 * @author nicolas
 *
 */
public class Medico implements Serializable {

    /**
     * ID de serie de serializaci�n.
     */
    private static final long serialVersionUID = 2228623750829747002L;
    
    /**
     * C�digo del m�dico en el sistema.
     */
    public final String codigo;

    /**
     * Nombre completo.
     */
    public final String nombre;

    /**
     * Detalle completo de la especializaci�n.
     */
    public final String especializacion;

    /**
     * Construye un m�dico por par�metros.
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
     * Lee un m�dico del teclado.
     * @return el m�dico le�do.
     */
    public static Medico leerDelTeclado() {
        return new Medico(IOUtil.leerCadena("Digite el c�digo del m�dico: "),
                          IOUtil.leerCadena("Digite el nombre del m�dico: "),
                          IOUtil.leerCadena("Digite la especializaci�n del m�dico: "));
    }

}
