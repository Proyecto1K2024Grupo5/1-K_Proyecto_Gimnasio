package DAO.GimnasioDAO.view;

import DAO.GimnasioDAO.model.gimnasio;

import java.util.List;
import java.util.Scanner;

public class VistaGimnasio {
    public Scanner scanner;

    public VistaGimnasio() {
        scanner = new Scanner(System.in);
    }

    public void mostrargimnasios(List<gimnasio> gimnasios) {
        System.out.println("Lista de gimnasios:");
        for (gimnasio gimnasio : gimnasios) {
            System.out.println(gimnasio);
        }
    }

    public gimnasio creargimnasio() {
        System.out.println("Introduce el código (número entero):");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nombre:");
        String nombre = scanner.nextLine();

        return new gimnasio(codigo, nombre);
    }

    public int obtenerCodigoAEliminar() {
        System.out.println("Introduce el código del gimnasio a eliminar:");
        return Integer.parseInt(scanner.nextLine());
    }

    public gimnasio obtenerDatosActualizados() {
        System.out.println("Introduce el código del gimnasio a actualizar:");
        int codigo = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el nuevo nombre:");
        String nombre = scanner.nextLine();

        return new gimnasio(codigo, nombre);
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public int obtenerCodigo() {
        System.out.println("Introduce el código del gimnasio:");
        return Integer.parseInt(scanner.nextLine());
    }

    public void mostrargimnasio(gimnasio gimnasio) {
        if(gimnasio != null) {
            System.out.println("Datos del gimnasio:");
            System.out.println("Código: " + gimnasio.getCodigo());
            System.out.println("Nombre: " + gimnasio.getNombre());
        } else {
            System.out.println("El gimnasio no existe");
        }
    }
}