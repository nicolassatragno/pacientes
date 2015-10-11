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
        Almacen.instancia.pacientes.clear();
        String opcion;
        do {
            System.out.println("   ...............................................");
            System.out.println("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:");
            System.out.println("   :-:.........................................:-:");
            
            Almacen.instancia.pacientes.add(Paciente.leerDelTeclado());

            System.out.println("Desea ingresar otro paciente? S/N");
            opcion = IOUtil.leerCadena();

        } while (opcion.equalsIgnoreCase("S"));
    }
}
