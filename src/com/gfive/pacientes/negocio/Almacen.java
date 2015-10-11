package com.gfive.pacientes.negocio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.gfive.pacientes.IOUtil;

/**
 * Singleton que sirve de almacén de datos para la aplicación.
 * 
 * @author nicolas
 *
 */
public class Almacen {
    
    /**
     * Pacientes guardados en el almacén.
     */
    public final List<Paciente> pacientes;
    
    /**
     * Médicos guardados en el almacén.
     */
    public final List<Medico> medicos;

    /**
     * Situaciones guardadas en el almacén.
     */
    public final List<Situacion> situaciones;
    
    /**
     * Nombre del archivo en el que se almacenan los datos.
     */
    private static final String NOMBRE_ARCHIVO = "datosPacientes.dat";
    
    /**
     * Instancia del almacén.
     */
    public static final Almacen instancia = new Almacen();
    
    /**
     * Crea y lee el almacén de archivos.
     * @param nombreArchivo
     */
    private Almacen() {
        pacientes = new ArrayList<>();
        medicos = new ArrayList<>();
        situaciones = new ArrayList<>();

        try (ObjectInputStream stream =
                new ObjectInputStream(new FileInputStream(NOMBRE_ARCHIVO))) {
            Object objeto;
            while (true) {
                objeto = stream.readObject();
                if (objeto instanceof Paciente)
                    pacientes.add((Paciente)objeto);
                else if (objeto instanceof Medico)
                    medicos.add((Medico)objeto);
                else if (objeto instanceof Situacion)
                    situaciones.add((Situacion)objeto);
            }
        } catch (FileNotFoundException | EOFException e) {
           // No pasa naranja, acá terminamos exitosamente.
        } catch (IOException | ClassCastException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Actualiza el archivo con los datos actuales.
     */
    public void escribir() {
        try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(NOMBRE_ARCHIVO))) {
            escribirListado(pacientes, stream);
            escribirListado(medicos, stream);
            escribirListado(situaciones, stream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Lee un médico existente del teclado.
     * @return el médico que coincide con el código leído.
     */
    public Medico obtenerMedico() {
        String codigoMedico = IOUtil.leerCadena("Ingrese el código del médico: ");
        Optional<Medico> medico = buscarMedico(codigoMedico);
        while (!medico.isPresent()) {
            medico = buscarMedico(
                    IOUtil.leerCadena("El médico no existe. Intente nuevamente: "));
        }
        
        return medico.get();
    }

    /**
     * Busca y devuelve el médico que coincide con el código dado.
     * @param codigo
     * @return
     */
    private Optional<Medico> buscarMedico(String codigo) {
        return medicos.stream()
                      .filter(p -> p.codigo.equals(codigo))
                      .findAny();
    }

    /**
     * Lee un paciente existente del teclado.
     * @return el paciente que coincide con el código leído.
     */
    public Paciente obtenerPaciente() {
        String codigoPaciente = IOUtil.leerCadena("Ingrese el código del paciente: ");
        Optional<Paciente> paciente = buscarPaciente(codigoPaciente);
        while (!paciente.isPresent()) {
            paciente = buscarPaciente(
                    IOUtil.leerCadena("El paciente no existe. Intente nuevamente: "));
        }
        
        return paciente.get();
    }
    
    /**
     * Busca y devuelve el paciente que coincide con el código dado.
     * @param codigo
     * @return
     */
    private Optional<Paciente> buscarPaciente(String codigo) {
        return pacientes.stream()
                        .filter(p -> p.codigo.equals(codigo))
                        .findAny();
    }
    
    /**
     * Obtiene un listado de las situaciones que verifican el predicado dado.
     * @param condicion
     * @return
     */
    public Stream<Situacion> obtenerSituaciones(Predicate<Situacion> condicion) {
        return situaciones.stream()
                          .filter(condicion);
    }
    
    /**
     * Escribe el listado en el stream.
     * @param objetos
     * @param stream
     * @throws IOException 
     */
    private void escribirListado(List<? extends Object> objetos, ObjectOutputStream stream) throws IOException {
        for (Object objeto : objetos)
            stream.writeObject(objeto);
    }
}
