package com.gfive.pacientes.workflow.ingresodatos;

import com.gfive.pacientes.IOUtil;
import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Situacion;

/**
 * Flujo de trabajo para el ingreso de datos de situación de pacientes en el archivo
 * correspondiente.
 * 
 * @author nicolas
 *
 */
public class WorkflowIngresoSituacion implements Runnable {

    @Override
    public void run() {
        Almacen.instancia.situaciones.clear();
        String opcion;
        do {
            System.out.println("   .....................................................");
            System.out.println("   :-: - S I T U A C I O N  D E L  P A C I E N T E - :-:");
            System.out.println("   :-:...............................................:-:");
            
            Almacen.instancia.situaciones.add(Situacion.leerDelTeclado());

            System.out.println("Desea ingresar otra situación? S/N");
            opcion = IOUtil.leerCadena();

        } while (opcion.equalsIgnoreCase("S"));
    }
}
