package com.gfive.pacientes.negocio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

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
            while ((objeto = stream.readObject()) != null) {
                if (objeto instanceof Paciente)
                    pacientes.add((Paciente)objeto);
                else if (objeto instanceof Medico)
                    medicos.add((Medico)objeto);
                else if (objeto instanceof Situacion)
                    situaciones.add((Situacion)objeto);
            }
        } catch (FileNotFoundException e) {
           // No pasa naranja, dejamos el listado vacío.
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
