package com.gfive.pacientes.workflow.ingresodatos;

import com.gfive.pacientes.IOUtil;
import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Paciente;

/**
 * Flujo de trabajo para el ingreso de datos de pacientes en el archivo correspondiente.
 * 
 * @author nicolas
 *
 */
public class WorkflowIngresoDatosPaciente implements Runnable {

    @Override
    public void run() {
        String opcion;
        do {
            System.out.println("   ...............................................");
            System.out.println("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:");
            System.out.println("   :-:.........................................:-:");
            
            Paciente paciente = Paciente.leerDelTeclado();
            while (Almacen.instancia.buscarPaciente(paciente.codigo).isPresent()) {
                paciente.codigo =
                        IOUtil.leerCadena("El ID de paciente ya está registrado. Intente con otro:");
            }
            Almacen.instancia.pacientes.add(paciente);

            System.out.println("Desea ingresar otro paciente? S/N");
            opcion = IOUtil.leerCadena();

        } while (opcion.equalsIgnoreCase("S"));
    }
}
