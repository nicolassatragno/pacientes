package com.gfive.pacientes.workflow.ingresodatos;

import com.gfive.pacientes.IOUtil;
import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Medico;

/**
 * Flujo de trabajo para el ingreso de datos de médicos en el archivo correspondiente.
 * 
 * @author nicolas
 *
 */
public class WorkflowIngresoDatosMedico implements Runnable {

    @Override
    public void run() {
        Almacen.instancia.medicos.clear();
        String opcion;
        do {
            System.out.println("   .....................................................");
            System.out.println("   :-:      - D A T O S   D E L   M E D I C O -      :-:");
            System.out.println("   :-:...............................................:-:");
            
            Medico medicoNuevo = Medico.leerDelTeclado();
            while (Almacen.instancia.buscarMedico(medicoNuevo.codigo).isPresent()) {
                medicoNuevo.codigo =
                        IOUtil.leerCadena("El ID de médico ya existe. Ingrese un ID distinto:");
            }

            Almacen.instancia.medicos.add(medicoNuevo);

            System.out.println("Desea ingresar otro médico? S/N");
            opcion = IOUtil.leerCadena();

        } while (opcion.equalsIgnoreCase("S"));
    }
}
