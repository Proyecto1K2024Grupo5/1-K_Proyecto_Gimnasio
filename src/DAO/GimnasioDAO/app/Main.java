package DAO.GimnasioDAO.app;

import controller.ControllerGimnasio;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControllerGimnasio controlador = new ControllerGimnasio();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n--- MENÚ gimnasio ---");
            System.out.println("1. Mostrar todos los gimnasios");
            System.out.println("2. Crear nuevo gimnasio");
            System.out.println("3. Actualizar gimnasio");
            System.out.println("4. Eliminar gimnasio");
            System.out.println("5. Buscar gimnasio por código");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        controlador.mostrarTodosLosgimnasios();
                        break;
                    case 2:
                        controlador.creargimnasio();
                        break;
                    case 3:
                        controlador.actualizargimnasio();
                        break;
                    case 4:
                        controlador.eliminargimnasio();
                        break;
                    case 5:
                        controlador.mostrargimnasioPorCodigo();
                        break;
                    case 6:
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
                opcion = 0;
            }

        } while (opcion != 6);
    }
}