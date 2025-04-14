package DAO.TrabajadorDAO.app;

import DAO.TrabajadorDAO.controller.ControllerPersona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //VistaPersona vista = new VistaPersona();
        ControllerPersona controlador = new ControllerPersona();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Mostrar todos los trabajadores");
            System.out.println("2. Nuevo Trabajador");
            System.out.println("3. Actualizar trabajador");
            System.out.println("4. Eliminar trabajador");
            System.out.println("5. Mostrar trabajador por DNI");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodasLasPersonas();
                    break;
                case 2:
                    controlador.crearPersona();
                    System.out.println("Trabajador creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarPersona();
                    System.out.println("Trabajador actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarPersona();
                    System.out.println("Trabajador eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostraPersonaNif();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }
}
