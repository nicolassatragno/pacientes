package com.gfive.pacientes.menu;


/**
 * Menú para el ingreso de pacientes.
 * @author nicolas
 *
 */
public class MenuControlPacientes extends Menu {
    private final static String CABECERA = 
            "   ..............................................\n" +
            "   :-:        C E N T R O  M E D I C O        :-:\n" +
            "   :-:   >>>> L O S  L A U R E L E S <<<<     :-:\n" +
            "   :-:  C O N T R O L  D E  P A C I E N T E S :-:\n" +
            "   :-:........................................:-:";
    
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Datos del paciente", false),
        new Opcion(2, "Situación del paciente", false),
        new Opcion(3, "Datos del médico", false),
        new Opcion(4, "Anterior", true)
    };
    
    public MenuControlPacientes() {
        super(CABECERA, OPCIONES);
    }

}
