package DAO.SalaDAO.controller;

import DAO.SalaDAO.db.SalaDAO;
import DAO.SalaDAO.model.Sala;
import DAO.SalaDAO.view.VistaSala;

import java.sql.SQLException;
import java.util.List;

public class ControllerSala {
    private SalaDAO salaDAO;
    private VistaSala vistaSala;

    public ControllerSala() {
        salaDAO = SalaDAO.getInstance();
        vistaSala = new VistaSala();
    }

    public void mostrarTodasLasSalas() {
        try {
            List<Sala> salas = salaDAO.getAllSalas();
            vistaSala.mostrarSalas(salas);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void mostrarSalaPorNombre() {
        try {
            String nombre = vistaSala.obtenerNombre();
            Sala sala = salaDAO.getSalaByNombre(nombre);
            vistaSala.mostrarSala(sala);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void crearSala() {
        try {
            Sala sala = vistaSala.crearSala();
            salaDAO.insertSala(sala);
            vistaSala.mostrarMensaje("Sala creada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarSala() {
        try {
            Sala sala = vistaSala.obtenerDatosActualizados();
            salaDAO.updateSala(sala);
            vistaSala.mostrarMensaje("Sala actualizada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSala() {
        try {
            String nombre = vistaSala.obtenerNombreAEliminar();
            salaDAO.deleteSalaByNombre(nombre);
            vistaSala.mostrarMensaje("Sala eliminada correctamente.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}