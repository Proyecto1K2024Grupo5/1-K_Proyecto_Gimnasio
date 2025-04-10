package DAO.SalaDAO.app;

import controller.ControllerSala;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControllerSala controladorSala = new ControllerSala();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\nSistema de Gestión de Salas");
            System.out.println("1. Mostrar todas las salas");
            System.out.println("2. Crear sala ");
            System.out.println("3. Actualizar sala");
            System.out.println("4. Eliminar sala");
            System.out.println("5. Mostrar sala por nombre");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    controladorSala.mostrarTodasLasSalas();
                    break;
                case 2:
                    controladorSala.crearSala();
                    break;
                case 3:
                    controladorSala.actualizarSala();
                    break;
                case 4:
                    controladorSala.eliminarSala();
                    break;
                case 5:
                    controladorSala.mostrarSalaPorNombre();
                    break;
                case 6:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 6.");
            }
        } while (opcion != 6);
    }
}








