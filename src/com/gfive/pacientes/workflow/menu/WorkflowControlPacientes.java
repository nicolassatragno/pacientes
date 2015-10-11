package com.gfive.pacientes.workflow.menu;

import com.gfive.pacientes.menu.MenuIngresoDatos;

/**
 * Flujo de trabajo que muestra el menú de control de pacientes.
 * @author nicolas
 *
 */
public class WorkflowControlPacientes extends WorkflowMenu {

    /**
     * Construye el workflow de pacientes.
     */
    public WorkflowControlPacientes() {
        super(new MenuIngresoDatos());
    }

}
