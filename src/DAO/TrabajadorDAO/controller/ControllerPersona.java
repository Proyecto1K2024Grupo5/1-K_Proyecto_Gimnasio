package DAO.TrabajadorDAO.controller;

import DAO.TrabajadorDAO.db.TrabajadorDAO;
import DAO.TrabajadorDAO.model.Trabajador;
import DAO.TrabajadorDAO.view.VistaTrabajador;

import java.sql.SQLException;
import java.util.List;

public class ControllerPersona {
    private TrabajadorDAO trabajadorDAO;
    private VistaTrabajador vistaTrabajador;

    public ControllerPersona() {
        // Crear conexión a la base de datos

            trabajadorDAO = TrabajadorDAO.getInstance();
            vistaTrabajador = new VistaTrabajador();
    }

    public void mostrarTodasLasPersonas() {
        try {
            List<Trabajador> trabajadors = trabajadorDAO.getAllPersonas();
            vistaTrabajador.mostrarPersonas(trabajadors);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostraPersonaNif() {
        try {
            String nif = vistaTrabajador.obtenerNif();
            Trabajador trabajador = trabajadorDAO.getPersonaByNif(nif);
            vistaTrabajador.mostrarPersona(trabajador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearPersona() {
        try {
            Trabajador trabajador = vistaTrabajador.crearPersona();
            trabajadorDAO.insertPersona(trabajador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarPersona() {
        try {
            Trabajador trabajador = vistaTrabajador.obtenerDatosActualizados();
            trabajadorDAO.updatePersona(trabajador);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarPersona() {
        try {
            String nif= vistaTrabajador.obtenerNifAEliminar();
            trabajadorDAO.deletePersonaByNif(nif);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Otros métodos del controlador...
}

