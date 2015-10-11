package com.gfive.pacientes.menu;

import com.gfive.pacientes.workflow.ingresodatos.WorkflowIngresoDatosMedico;
import com.gfive.pacientes.workflow.ingresodatos.WorkflowIngresoDatosPaciente;
import com.gfive.pacientes.workflow.ingresodatos.WorkflowIngresoSituacion;


/**
 * Menú para el ingreso de pacientes.
 * @author nicolas
 *
 */
public class MenuIngresoDatos extends Menu {
    private final static String CABECERA = 
            "   ...............................................\n" +
            "   :-: -I N G R E S O  D E  P A C I E N T E S- :-:\n" +
            "   :-:.........................................:-:";
    
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Datos del paciente", false, new WorkflowIngresoDatosPaciente()),
        new Opcion(2, "Situación del paciente", false, new WorkflowIngresoSituacion()),
        new Opcion(3, "Datos del médico", false, new WorkflowIngresoDatosMedico()),
        new Opcion(4, "Anterior", true, null)
    };
    
    public MenuIngresoDatos() {
        super(CABECERA, OPCIONES);
    }
}