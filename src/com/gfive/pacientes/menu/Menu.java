package com.gfive.pacientes.menu;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

import com.gfive.pacientes.IOUtil;

/**
 * Clase base para los men�s de la aplicaci�n.
 * @author nicolas
 *
 */
public class Menu {

    /**
     * Ancho total del men� en caracteres.
     */
    private static final int ANCHO_MENU = 50;

    /**
     * Cantidad de caracteres de margen derecho de opciones. 
     */
    private static final int MARGEN_DERECHO_OPCIONES = 13;

    /**
     * Cantidad de caracteres de margen izquierdo de opciones.
     */
    private static final int MARGEN_IZQUIERDO_OPCIONES = 3;

    /**
     * Texto que aparece arriba de todo en el men�.
     */
    private String cabecera;

    /**
     * Listado de opciones que se pueden elegir.
     */
    private Opcion[] opciones;
    
    /**
     * Construye un men� con una cabecera y opciones dadas.
     * @param cabecera
     * @param opcionPacientes
     */
    protected Menu(String cabecera, Opcion[] opcionPacientes) {
        Objects.requireNonNull(opcionPacientes);
        this.cabecera = cabecera;
        this.opciones = opcionPacientes;
    }

    public Opcion mostrarMenu() {
        System.out.println(cabecera);
        Arrays.stream(opciones).forEach(this::imprimirOpcion);
        System.out.println("   ..............................................");
        System.out.println("   ....Elija la opcion deseada: ");

        Optional<Opcion> respuesta = get(IOUtil.leerEntero());
        
        while (!respuesta.isPresent()) {
            System.out.println("La opci�n ingresada no es v�lida. Intente nuevamente.");
            respuesta = get(IOUtil.leerEntero());
        }

        return respuesta.get();
    }

    /**
     * Imprime una opci�n en la pantalla con el formato del men�.
     * 
     * @param opcion
     *            - la opci�n que se desa imprimir. No puede ser null.
     */
    private void imprimirOpcion(Opcion opcion) {
        StringBuilder paddingDerecho = new StringBuilder();
        for (int i = MARGEN_DERECHO_OPCIONES + opcion.descripcion().length() + MARGEN_IZQUIERDO_OPCIONES;
             i < ANCHO_MENU; i++) {
            paddingDerecho.append(' ');
        }
        paddingDerecho.append(":-:");
        String paddingIzquierdo = "   :-:  ";
        System.out.println(
                paddingIzquierdo + opcion.codigo() + " - " + opcion.descripcion() + paddingDerecho);
    }
    
    /**
     * Devuelve una opci�n seg�n su c�digo.
     * @param codigo
     * @return la opci�n que corresponde con el c�digo, si existe, o un opcional vac�o en caso
     * contrario.
     */
    private Optional<Opcion> get(int codigo) {
        return Arrays.stream(opciones).filter(opcion -> opcion.codigo() == codigo).findAny();
    }
}
