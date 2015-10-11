package com.gfive.pacientes.workflow.menu;

import com.gfive.pacientes.menu.MenuInformes;

/**
 * Flujo de trabajo que muestra el menú de informes.
 * @author nicolas
 *
 */
public class WorkflowInformes extends WorkflowMenu {

    /**
     * Construye el workflow de informes.
     */
    public WorkflowInformes() {
        super(new MenuInformes());
    }

}
