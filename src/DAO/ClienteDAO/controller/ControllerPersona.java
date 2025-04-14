package DAO.ClienteDAO.controller;

import DAO.ClienteDAO.db.ClienteDAO;
import DAO.ClienteDAO.model.Cliente;
import DAO.ClienteDAO.view.VistaPersona;

import java.sql.SQLException;
import java.util.List;

public class ControllerPersona {
    private ClienteDAO clienteDAO;
    private VistaPersona vistaPersona;

    public ControllerPersona() {
        // Crear conexión a la base de datos

            clienteDAO = ClienteDAO.getInstance();
            vistaPersona = new VistaPersona();
    }

    public void mostrarTodasLasPersonas() {
        try {
            List<Cliente> personas = clienteDAO.getAllPersonas();
            vistaPersona.mostrarPersonas(personas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void mostraPersonaDNI() {
        try {
            String dni = vistaPersona.obtenerDni();
            Cliente persona = clienteDAO.getPersonaByDni(dni);
            vistaPersona.mostrarPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearPersona() {
        try {
            Cliente persona=vistaPersona.crearPersona();
            clienteDAO.insertPersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersona() {
        try {
            Cliente persona=vistaPersona.obtenerDatosActualizados();
            clienteDAO.updatePersona(persona);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona() {
        try {
            String dni=vistaPersona.obtenerDniAEliminar();
            clienteDAO.deletePersonaByDni(dni);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}

