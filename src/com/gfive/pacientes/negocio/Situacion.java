package com.gfive.pacientes.negocio;

import com.gfive.pacientes.IOUtil;

/**
 * Representa la situación de un paciente.
 * @author nicolas
 *
 */
public class Situacion {

    /**
     * Paciente al que la situación está relacionada.
     */
    public final Paciente paciente;
    
    /**
     * Médico al que la situación está relacionada.
     */
    public final Medico medico;
    
    /**
     * Diagnóstico dado por el médico, en forma de nombre de la enfermedad.
     */
    public final String diagnostico;
    
    /**
     * Construye una situación por parámetros.
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
     * Lee la situación del teclado.
     * @return la situación leída.
     */
    public static Situacion leerDelTeclado() {
        return new Situacion(Almacen.instancia.obtenerPaciente(),
                             Almacen.instancia.obtenerMedico(),
                             IOUtil.leerCadena("Ingrese el diagnóstico del médico"));
    }
}
