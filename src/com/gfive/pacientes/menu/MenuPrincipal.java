package com.gfive.pacientes.menu;

import com.gfive.pacientes.workflow.menu.WorkflowControlPacientes;
import com.gfive.pacientes.workflow.menu.WorkflowInformes;


/**
 * Menú principal de la aplicación, mostrado al arrancar.
 * @author nicolas
 *
 */
public class MenuPrincipal extends Menu {
    private final static String CABECERA = 
            "   ..............................................\n" +
            "   :-:        C E N T R O  M E D I C O        :-:\n" +
            "   :-:   >>>> L O S  L A U R E L E S <<<<     :-:\n" +
            "   :-:  C O N T R O L  D E  P A C I E N T E S :-:\n" +
            "   :-:........................................:-:";
    
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Ingreso de datos", false, new WorkflowControlPacientes()),
        new Opcion(2, "Informes", false, new WorkflowInformes()),
        new Opcion(3, "Salir", true, null)
    };
    
    public MenuPrincipal() {
        super(CABECERA, OPCIONES);
    }

}
