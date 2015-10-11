package com.gfive.pacientes.menu;


/**
 * Menú principal de la aplicación, mostrado al arrancar.
 * @author nicolas
 *
 */
public class MenuPrincipal extends Menu {
    private final static String CABECERA = 
            "   ...............................................\n" +
            "   :-: -I N G R E S O  D E  P A C I E N T E S- :-:\n" +
            "   :-:.........................................:-:";
    
    private final static Opcion[] OPCIONES = {
        new Opcion(1, "Ingreso de datos", false),
        new Opcion(2, "Informes", false),
        new Opcion(3, "Salir", true)
    };
    
    public MenuPrincipal() {
        super(CABECERA, OPCIONES);
    }

}
