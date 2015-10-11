package com.gfive.pacientes.workflow.menu;

import com.gfive.pacientes.menu.Menu;
import com.gfive.pacientes.menu.Opcion;

/**
 * Un flujo de trabajo que muestra un men� y dispara sus acciones.
 * @author nicolas
 *
 */
public class WorkflowMenu implements Runnable {
    
    /**
     * Men� del workflow.
     */
    private Menu menu;

    /**
     * Construye el workflow de men�.
     * @param menu
     */
    protected WorkflowMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void run() {
        while (true) {
            Opcion opcion = menu.mostrarMenu();
            if (opcion.indicaSalir())
                return;
            opcion.ejecutar();
        }
    }

}
