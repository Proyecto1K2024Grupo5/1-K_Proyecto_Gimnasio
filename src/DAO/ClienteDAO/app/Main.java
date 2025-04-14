package DAO.ClienteDAO.app;

import DAO.ClienteDAO.controller.ControllerPersona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //VistaPersona vista = new VistaPersona();
        ControllerPersona controlador = new ControllerPersona();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar todos los clientes");
            System.out.println("2. Crear cliente");
            System.out.println("3. Actualizar cliente");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Mostrar cliente por DNI");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controlador.mostrarTodasLasPersonas();
                    break;
                case 2:
                    controlador.crearPersona();
                    System.out.println("Cliente creado correctamente.");
                    break;
                case 3:
                    controlador.actualizarPersona();
                    System.out.println("Cliente actualizado correctamente.");
                    break;
                case 4:
                    controlador.eliminarPersona();
                    System.out.println("Cliente eliminado correctamente.");
                    break;
                case 5:
                    controlador.mostraPersonaDNI();
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
