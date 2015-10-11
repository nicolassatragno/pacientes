package com.gfive.pacientes.menu;


/**
 * Men� para el ingreso de pacientes.
 * @author nicolas
 *
 */
public class MenuInformes extends Menu {
    private final static String CABECERA = 
            "   ...............................................\n" +
            "   :-:  C O N T R O L  D E  P A C I E N T E S  :-:\n" +
            "   ...............................................\n" +
            "   :-:           - I N F O R M E S -           :-:\n" +
            "   :-:.........................................:-:\n";
    
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Listado de pacientes por m�dico", false, null),
        new Opcion(2, "Enfermedades que atiende cada m�dico", false, null),
        new Opcion(3, "Anterior", true, null)
    };
    
    public MenuInformes() {
        super(CABECERA, OPCIONES);
    }

}
