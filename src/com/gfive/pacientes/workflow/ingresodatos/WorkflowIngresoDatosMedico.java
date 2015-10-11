package com.gfive.pacientes.workflow.ingresodatos;

import com.gfive.pacientes.IOUtil;
import com.gfive.pacientes.negocio.Almacen;
import com.gfive.pacientes.negocio.Medico;

/**
 * Flujo de trabajo para el ingreso de datos de m�dicos en el archivo correspondiente.
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
            
            Almacen.instancia.medicos.add(Medico.leerDelTeclado());

            System.out.println("Desea ingresar otro m�dico? S/N");
            opcion = IOUtil.leerCadena();

        } while (opcion.equalsIgnoreCase("S"));
    }
}
