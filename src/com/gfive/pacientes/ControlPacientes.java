package com.gfive.pacientes;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import com.gfive.pacientes.menu.MenuControlPacientes;
import com.gfive.pacientes.menu.MenuInformes;
import com.gfive.pacientes.menu.MenuPrincipal;

class ControlPacientes {

    public static void main(String args[]) throws Exception {
        String op = "";
        int sw = 0, sw1 = 0;
        int op1, op2; // variables de selección usadas en los diferentes menús
        String codpac, nompac, codmed, enfpac, nommed, espmed; // variables usadas en el
                                                                       // registro de datos
        String codp = "", codpa = "", nompa = "", codm = "", codme = "", enfp = "", nomm = "", espm = ""; // variables
                                                                                                                     // usadas
                                                                                                                     // en
                                                                                                                     // la
                                                                                                                     // lectura
                                                                                                                     // de
                                                                                                                     // datos
        String codtem; // variables auxiliares temporales

        do {
            op1 = 0;

            new MenuPrincipal().mostrarMenu();

            //op1 = leerEntero();
            if (op1 < 1 || op1 > 3) {
                System.out.println("Debe digitar una opcion del menu");
            }

            if (op1 == 1) // seleción ingreso de pacientes
            {

                do {

                    new MenuControlPacientes().mostrarMenu();

                    op2 = IOUtil.leerEntero();

                    if (op2 < 1 || op2 > 4) {
                        System.out.println("Debe digitar una opcion del menu");
                    }

                    switch (op2) {
                    // Ingreso de datos, datos del paciente.
                    case 1: 
                        DataOutputStream datopac = null;
                        datopac = new DataOutputStream(new FileOutputStream("C:\\datopac.txt"));
                        try {
                            do {
                                System.out.println("   ...............................................");
                                System.out.println("   :-:  - D A T O S  D E L  P A C I E N T E -  :-:");
                                System.out.println("   :-:.........................................:-:");

                                System.out.println("Digite el codigo del paciente: ");
                                codpac = IOUtil.leerCadena();
                                datopac.writeUTF(codpac);
                                System.out.println("Digite el nombre del paciente: ");
                                nompac = IOUtil.leerCadena();

                                datopac.writeUTF(nompac);

                                System.out.println("Desea ingresar otro paciente? S/N");

                                op = IOUtil.leerCadena();

                            } while (op.equals("S") || op.equals("s"));

                            datopac.close();

                        } catch (IOException ioe) {
                            throw new RuntimeException(ioe);
                        }

                        break;
                    // Ingreso de datos, situación del paciente.
                    case 2:
                        DataOutputStream situpac = null;
                        situpac = new DataOutputStream(new FileOutputStream("C:\\situpac.txt"));
                        try {
                            do {
                                System.out.println("   .....................................................");
                                System.out.println("   :-: - S I T U A C I O N  D E L  P A C I E N T E - :-:");
                                System.out.println("   :-:...............................................:-:");

                                System.out.println("Digite el codigo del paciente: ");
                                codp = IOUtil.leerCadena();
                                situpac.writeUTF(codp);

                                System.out.println("Digite el codigo del medico: ");
                                codm = IOUtil.leerCadena();
                                situpac.writeUTF(codm);

                                System.out.println("Digite el diagnostico del medico: ");
                                enfpac = IOUtil.leerCadena();
                                situpac.writeUTF(enfpac);

                                System.out.println("Desea ingresar otro registro al historial? S/N");
                                System.out.println("");
                                op = IOUtil.leerCadena();

                            } while (op.equals("S") || op.equals("s"));
                            situpac.close();
                        } catch (IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                        break;

                    case 3:
                        DataOutputStream datomed = null;
                        datomed = new DataOutputStream(new FileOutputStream("C:\\datomed.txt"));
                        try {
                            do {

                                System.out.println("   .....................................................");
                                System.out.println("   :-:      - D A T O S   D E L   M E D I C O -      :-:");
                                System.out.println("   :-:...............................................:-:");

                                System.out.println("Digite el codigo del medico: ");
                                codmed = IOUtil.leerCadena();
                                datomed.writeUTF(codmed);

                                System.out.println("Digite el nombre del medico: ");
                                nommed = IOUtil.leerCadena();
                                datomed.writeUTF(nommed);

                                System.out.println("Digite la especializacion del medico: ");
                                espmed = IOUtil.leerCadena();
                                datomed.writeUTF(espmed);

                                System.out.println("Desea ingresar otro medico? S/N");
                                System.out.println("");

                                op = IOUtil.leerCadena();

                            } while (op.equals("S") || op.equals("s"));
                        } catch (IOException ioe) {
                            throw new RuntimeException(ioe);
                        }
                        datomed.close();
                    }
                } while (op2 != 4);
            } else {
                if (op1 == 2) {
                    do {
                        new MenuInformes().mostrarMenu();
                        op2 = IOUtil.leerEntero();
                        if (op2 < 1 || op2 > 3) {
                            System.out.println("Seleccione una de las opciones del menu");
                        }

                        switch (op2) {
                        case 1:
                            try {

                                System.out.println("Digite el codigo del medico que desea consultar: ");
                                codtem = IOUtil.leerCadena();

                                DataInputStream datomed = null;
                                datomed = new DataInputStream(
                                        new FileInputStream("C:\\datomed.txt"));

                                sw = 1;
                                while (sw != 0) {
                                    try {
                                        codm = datomed.readUTF();
                                        nomm = datomed.readUTF();
                                        espm = datomed.readUTF();

                                    } catch (EOFException e) {
                                        sw = 0;
                                    }

                                    if (codm.equals(codtem)) // compara el codigo extraido de la
                                                             // tabla "datomed" con el codigo
                                                             // digitado
                                    {
                                        System.out.println("::: El medico " + nomm
                                                + " atiende a los siguientes pacientes: ");
                                        DataInputStream situpac = null;
                                        situpac = new DataInputStream(new FileInputStream(
                                                "C:\\situpac.txt"));

                                        sw = 1;
                                        while (sw != 0) {
                                            try {
                                                codp = situpac.readUTF();
                                                codme = situpac.readUTF();
                                                enfp = situpac.readUTF();

                                                if (codme.equals(codtem)) // compara el codigo
                                                                          // medico de la
                                                                          // tabla "datomed" con el
                                                                          // de la
                                                                          // tabla "situpac"
                                                {
                                                    DataInputStream datopac = null;
                                                    datopac = new DataInputStream(
                                                            new FileInputStream("C:\\datopac.txt"));

                                                    sw1 = 1;
                                                    while (sw1 != 0) {
                                                        try {
                                                            codpa = datopac.readUTF();
                                                            nompa = datopac.readUTF();

                                                            if (codpa.equals(codp)) // compara el
                                                                                    // codigo del
                                                                                    // paciente de
                                                                                    // la tabla
                                                                                    // "situpac"
                                                                                    // con el codigo
                                                                                    // del paciente
                                                                                    // de
                                                                                    // la tabla
                                                                                    // "datopac"
                                                            {
                                                                System.out.println("::: Paciente: " + nompa);
                                                            }
                                                        } catch (EOFException e) {
                                                            sw1 = 0;
                                                        }
                                                    }
                                                }
                                            } catch (EOFException e) {
                                                sw = 0;
                                            }
                                        }
                                    }
                                }

                            } catch (IOException ioe) {
                            }
                            ;
                            break;

                        case 2:

                            System.out.println("Digite el codigo del medico que desea consultar: ");
                            codtem = IOUtil.leerCadena();

                            DataInputStream datomed = null;
                            datomed = new DataInputStream(new FileInputStream("C:\\datomed.txt"));

                            sw1 = 1;
                            while (sw1 != 0) {
                                try {
                                    codm = datomed.readUTF();
                                    nomm = datomed.readUTF();
                                    espm = datomed.readUTF();

                                    if (codm.equals(codtem)) // compara el codigo digitado
                                                             // con el codigo del medico de la
                                                             // tabla "datomed"
                                    {
                                        System.out.println("El medico " + nomm
                                                + " trata las siguientes enfermedades:");

                                        DataInputStream situpac = null;
                                        situpac = new DataInputStream(new FileInputStream(
                                                "C:\\situpac.txt"));

                                        sw = 1;
                                        while (sw != 0) {
                                            try {
                                                codp = situpac.readUTF();
                                                codme = situpac.readUTF();
                                                enfp = situpac.readUTF();

                                                if (codtem.equals(codme)) // compara el codigo del
                                                                          // medico
                                                                          // de la tabla "datomed"
                                                                          // con el codigo del
                                                                          // medico en la
                                                                          // tabla "situpac"

                                                {
                                                    System.out.println(">>>> " + enfp);
                                                }
                                            } catch (EOFException e) {
                                                sw = 0;
                                            }
                                        }
                                    }
                                } catch (EOFException e) {
                                    sw1 = 0;
                                }
                            }
                            break;
                        }

                    } while (op2 != 3);

                }
            }
        } while (op1 != 3);
    }
}
