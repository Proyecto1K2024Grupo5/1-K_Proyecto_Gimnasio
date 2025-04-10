package DAO.SalaDAO.view;

import model.Sala;

import java.util.List;
import java.util.Scanner;

public class VistaSala {
    private Scanner scanner;

    public VistaSala() {
        scanner = new Scanner(System.in);
    }

    public void mostrarSalas(List<Sala> salas) {
        System.out.println("Lista de Salas:");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    public Sala crearSala() {
        System.out.println("Introduce el nombre de la sala:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce hechia:");
        String hechia = scanner.nextLine();
        System.out.println("Introduce el turno:");
        String turno = scanner.nextLine();
        System.out.println("Introduce sulfa:");
        String sulfa = scanner.nextLine();

        return new Sala(nombre, hechia, turno, sulfa);
    }

    public String obtenerNombreAEliminar() {
        System.out.println("Introduce el nombre de la sala a eliminar:");
        return scanner.nextLine();
    }

    public Sala obtenerDatosActualizados() {
        System.out.println("Introduce el nombre de la sala:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce la nueva hechia:");
        String hechia = scanner.nextLine();
        System.out.println("Introduce el nuevo turno:");
        String turno = scanner.nextLine();
        System.out.println("Introduce la nueva sulfa:");
        String sulfa = scanner.nextLine();

        return new Sala(nombre, hechia, turno, sulfa);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerNombre() {
        System.out.println("Introduce el nombre de la sala:");
        return scanner.nextLine();
    }

    public void mostrarSala(Sala sala) {
        if (sala != null) {
            System.out.println(sala);
        } else {
            System.out.println("La sala no existe");
        }
    }
}