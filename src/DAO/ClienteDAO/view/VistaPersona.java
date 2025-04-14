package DAO.ClienteDAO.view;

import DAO.ClienteDAO.model.Cliente;

import java.util.List;
import java.util.Scanner;

public class VistaPersona {
    public Scanner scanner;

    public VistaPersona() {
        scanner = new Scanner(System.in);
    }

    public void mostrarPersonas(List<Cliente> personas) {
        System.out.println("Lista de Clientes:");
        for (Cliente persona : personas) {
            System.out.println(persona);
        }
    }

    public Cliente crearPersona() {

        System.out.println("Introduce el DNI del nuevo cliente: ");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce los apellidos:");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce la fecha de nacimiento del cliente: ");
        String fnac = scanner.nextLine();
        System.out.println("Introduce el email del cliente: ");
        String email = scanner.nextLine();
        System.out.println("Introduce la fecha de hoy");
        String falta = scanner.nextLine();
        System.out.println("Introduce el tipo de membresia: ");
        String membresia = scanner.nextLine();

        return new Cliente(nif, nombre, apellidos, fnac, email, falta, 0, membresia);
    }

    public String obtenerDniAEliminar() {
        System.out.println("Introduce el DNI de la persona a eliminar:");
        return scanner.nextLine();
    }

    public Cliente obtenerDatosActualizados() {
        System.out.println("Introduce el DNI del nuevo cliente: ");
        String nif = scanner.nextLine();
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Introduce los apellidos:");
        String apellidos = scanner.nextLine();
        System.out.println("Introduce la fecha de nacimiento del cliente: ");
        String fnac = scanner.nextLine();
        System.out.println("Introduce el email del cliente: ");
        String email = scanner.nextLine();
        System.out.println("Introduce la fecha de hoy");
        String falta = scanner.nextLine();
        System.out.println("Introduce el tipo de membresia: ");
        String membresia = scanner.nextLine();

        return new Cliente(nif, nombre, apellidos, fnac, email, falta, 0, membresia);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public String obtenerDni() {
        System.out.println("Introduce el DNI de la persona:");
        return scanner.nextLine();
    }
    //muestra los datos de la persona
    public void mostrarPersona(Cliente persona) {
        if(persona!=null)
            System.out.println(persona);
        else
            System.out.println("La persona no existe");
    }

    // Otros métodos de la vista...
}

