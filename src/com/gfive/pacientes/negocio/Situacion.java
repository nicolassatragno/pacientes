package com.gfive.pacientes.negocio;

import com.gfive.pacientes.IOUtil;

/**
 * Representa la situaci�n de un paciente.
 * @author nicolas
 *
 */
public class Situacion {

    /**
     * Paciente al que la situaci�n est� relacionada.
     */
    public final Paciente paciente;
    
    /**
     * M�dico al que la situaci�n est� relacionada.
     */
    public final Medico medico;
    
    /**
     * Diagn�stico dado por el m�dico, en forma de nombre de la enfermedad.
     */
    public final String diagnostico;
    
    /**
     * Construye una situaci�n por par�metros.
     * @param paciente
     * @param medico
     * @param diagnostico
     */
    public Situacion(Paciente paciente, Medico medico, String diagnostico) {
        this.paciente = paciente;
        this.medico = medico;
        this.diagnostico = diagnostico;
    }
    
    /**
     * Lee la situaci�n del teclado.
     * @return la situaci�n le�da.
     */
    public static Situacion leerDelTeclado() {
        return new Situacion(Almacen.instancia.obtenerPaciente(),
                             Almacen.instancia.obtenerMedico(),
                             IOUtil.leerCadena("Ingrese el diagn�stico del m�dico"));
    }
}
