package com.gfive.pacientes;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utilidades para entrada / salida.
 * @author nicolas
 *
 */
public class IOUtil {

    /**
     * Lee del teclado hasta que el usuario introduce un entero del teclado.
     * @return el entero leído.
     */
    public static int leerEntero() {
        try {
            return Integer.parseInt(leerCadena());
        } catch (NumberFormatException e) {
            System.out.println("El número introducido no es válido, por favor intente nuevamente");
            return leerEntero();
        }
    }

    /**
     * Lee una cadena arbitraria del teclado.
     * @return la cadena leída.
     */
    public static String leerCadena() {
        try {
            System.out.print("?: ");
            return new BufferedReader(new InputStreamReader(System.in)).readLine();
        } catch (IOException e) {
            throw new RuntimeException("Ocurrió un error al intentar leer la entrada estándar");
        }
    }
    

    /**
     * Lee una cadena arbitraria del teclado mostrando el mensaje dado.
     * @param mensaje - mensaje que se muestra al usuario antes de leer la cadena.
     * @return la cadena leída.
     */
    public static String leerCadena(String mensaje) {
        System.out.println(mensaje);
        return leerCadena();
    }
}
