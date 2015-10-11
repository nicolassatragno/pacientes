package com.gfive.pacientes.negocio;

import java.util.Optional;

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
        String codigoPaciente = IOUtil.leerCadena("Ingrese el código del paciente: ");
        Optional<Paciente> paciente = buscarPaciente(codigoPaciente);
        while (!paciente.isPresent()) {
            paciente = buscarPaciente(
                    IOUtil.leerCadena("El paciente no existe. Intente nuevamente: "));
        }

        String codigoMedico = IOUtil.leerCadena("Ingrese el código del médico: ");
        Optional<Medico> medico = buscarMedico(codigoMedico);
        while (!medico.isPresent()) {
            medico = buscarMedico(
                    IOUtil.leerCadena("El médico no existe. Intente nuevamente: "));
        }
        
        return new Situacion(paciente.get(),
                             medico.get(),
                             IOUtil.leerCadena("Ingrese el diagnóstico del médico"));
    }
    
    /**
     * Busca y devuelve el paciente que coincide con el código dado.
     * @param codigo
     * @return
     */
    private static Optional<Paciente> buscarPaciente(String codigo) {
        return Almacen.instancia
                      .pacientes
                      .stream()
                      .filter(p -> p.codigo.equals(codigo))
                      .findAny();
    }
    
    /**
     * Busca y devuelve el médico que coincide con el código dado.
     * @param codigo
     * @return
     */
    private static Optional<Medico> buscarMedico(String codigo) {
        return Almacen.instancia
                      .medicos
                      .stream()
                      .filter(p -> p.codigo.equals(codigo))
                      .findAny();
    }
}
