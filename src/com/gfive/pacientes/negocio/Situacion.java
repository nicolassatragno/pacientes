package com.gfive.pacientes.negocio;

import java.io.Serializable;
import java.util.Optional;

import com.gfive.pacientes.IOUtil;

/**
 * Representa la situación de un paciente.
 * @author nicolas
 *
 */
public class Situacion implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 303298398983L;

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
    public static Optional<Situacion> leerDelTeclado() {
        Optional<Paciente> paciente = Almacen.instancia.obtenerPaciente();
        if (!paciente.isPresent())
            return Optional.empty();
        Optional<Medico> medico = Almacen.instancia.obtenerMedico();
        if (!medico.isPresent())
            return Optional.empty();
        return Optional.of(new Situacion(paciente.get(),
                             medico.get(),
                             IOUtil.leerCadena("Ingrese el diagnóstico del médico")));
    }
}
