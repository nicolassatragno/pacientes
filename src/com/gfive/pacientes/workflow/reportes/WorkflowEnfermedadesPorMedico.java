package com.gfive.pacientes.workflow.reportes;

import java.util.Optional;

import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Medico;

/**
 * Flujo de trabajos del reporte que lista las enfermedades por médico.
 * @author nicolas
 *
 */
public class WorkflowEnfermedadesPorMedico implements Runnable {

    @Override
    public void run() {
        final Optional<Medico> medico = Almacen.instancia.obtenerMedico();
        if (!medico.isPresent())
            return;
        System.out.println("::: El medico " + medico.get().nombre + " atiende a las siguientes enfermedades: ");
        
        Almacen.instancia.obtenerSituaciones(situacion -> situacion.medico.equals(medico.get()))
                         .map(situacion -> situacion.diagnostico)
                         .forEach(System.out::println);
    }

}
