package com.gfive.pacientes.workflow.reportes;

import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Medico;

/**
 * Flujo de trabajos del reporte que lista los pacientes por médico.
 * @author nicolas
 *
 */
public class WorkflowPacientesPorMedico implements Runnable {

    @Override
    public void run() {
        final Medico medico = Almacen.instancia.obtenerMedico();
        System.out.println("::: El medico " + medico.nombre + " atiende a los siguientes pacientes: ");
        
        Almacen.instancia.obtenerSituaciones(situacion -> situacion.medico.equals(medico))
                         .forEach(situacion -> System.out.println(situacion.paciente));
    }

}
