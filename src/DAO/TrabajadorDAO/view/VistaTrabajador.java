package DAO.TrabajadorDAO.view;

import model.Trabajador;

import java.util.List;
import java.util.Scanner;

public class VistaTrabajador {
    public Scanner scanner;

    public VistaTrabajador() {
        scanner = new Scanner(System.in);
    }

    public void mostrarPersonas(List<Trabajador> trabajador) {
        System.out.println("Lista de Trabajadores:");
        for (Trabajador tr : trabajador) {
            System.out.println(tr);
        }
    }

    public Trabajador crearPersona() {
        System.out.println("Introduce el NIF:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Introduce la FNAC:");
        String fnac = scanner.nextLine();
        System.out.println("Introduce el email:");
        String email = scanner.nextLine();

        return new Trabajador(dni, nombre, apellido, fnac, email);
    }

    public String obtenerNifAEliminar() {
        System.out.println("Introduce el NIF del trabajador a eliminar:");
        return scanner.nextLine();
    }

    public Trabajador obtenerDatosActualizados() {
        System.out.println("Introduce el NIF:");
        String dni = scanner.nextLine();
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce el nuevo apellido:");
        String apellido = scanner.nextLine();
        System.out.println("Introduce la fecha:");
        String fnac = scanner.nextLine();
        System.out.println("Introduce el email:");
        String email = scanner.nextLine();

        return new Trabajador(dni, nombre, apellido, fnac, email);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerNif() {
        System.out.println("Introduce el NIF del trabajador:");
        return scanner.nextLine();
    }
    //muestra los datos de la persona
    public void mostrarPersona(Trabajador trabajador) {
        if(trabajador !=null)
            System.out.println(trabajador);
        else
            System.out.println("El trabajador no existe");
    }

    // Otros métodos de la vista...
}

