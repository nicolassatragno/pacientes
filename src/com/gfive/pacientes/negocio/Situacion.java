package com.gfive.pacientes.negocio;

import java.util.Optional;

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
        String codigoPaciente = IOUtil.leerCadena("Ingrese el c�digo del paciente: ");
        Optional<Paciente> paciente = buscarPaciente(codigoPaciente);
        while (!paciente.isPresent()) {
            paciente = buscarPaciente(
                    IOUtil.leerCadena("El paciente no existe. Intente nuevamente: "));
        }

        String codigoMedico = IOUtil.leerCadena("Ingrese el c�digo del m�dico: ");
        Optional<Medico> medico = buscarMedico(codigoMedico);
        while (!medico.isPresent()) {
            medico = buscarMedico(
                    IOUtil.leerCadena("El m�dico no existe. Intente nuevamente: "));
        }
        
        return new Situacion(paciente.get(),
                             medico.get(),
                             IOUtil.leerCadena("Ingrese el diagn�stico del m�dico"));
    }
    
    /**
     * Busca y devuelve el paciente que coincide con el c�digo dado.
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
     * Busca y devuelve el m�dico que coincide con el c�digo dado.
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
