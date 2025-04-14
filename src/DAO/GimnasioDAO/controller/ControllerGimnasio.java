package DAO.GimnasioDAO.controller;

import DAO.GimnasioDAO.db.GimnasioDAO;
import DAO.GimnasioDAO.view.VistaGimnasio;
import DAO.GimnasioDAO.model.gimnasio;

import java.sql.SQLException;
import java.util.List;

public class ControllerGimnasio {
    private GimnasioDAO gimnasioDAO;
    private VistaGimnasio vistagimnasio;

    public ControllerGimnasio() {
        this.gimnasioDAO = gimnasioDAO.getInstance();
        this.vistagimnasio = new VistaGimnasio();
    }

    public void mostrarTodosLosgimnasios() {
        try {
            List<gimnasio> gimnasios = gimnasioDAO.getAllgimnasios();
            vistagimnasio.mostrargimnasios(gimnasios);
        } catch (SQLException e) {
            vistagimnasio.mostrarMensaje("Error al obtener los gimnasios: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void mostrargimnasioPorCodigo() {
        try {
            int codigo = vistagimnasio.obtenerCodigo();
            gimnasio gimnasio = gimnasioDAO.getgimnasioByCodigo(codigo);
            vistagimnasio.mostrargimnasio(gimnasio);
        } catch (SQLException e) {
            vistagimnasio.mostrarMensaje("Error al buscar el gimnasio: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void creargimnasio() {
        try {
            gimnasio nuevogimnasio = vistagimnasio.creargimnasio();
            gimnasioDAO.insertgimnasio(nuevogimnasio);
            vistagimnasio.mostrarMensaje("gimnasio creado exitosamente");
        } catch (SQLException e) {
            vistagimnasio.mostrarMensaje("Error al crear el gimnasio: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void actualizargimnasio() {
        try {
            gimnasio gimnasioActualizado = vistagimnasio.obtenerDatosActualizados();
            gimnasioDAO.updategimnasio(gimnasioActualizado);
            vistagimnasio.mostrarMensaje("gimnasio actualizado exitosamente");
        } catch (SQLException e) {
            vistagimnasio.mostrarMensaje("Error al actualizar el gimnasio: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminargimnasio() {
        try {
            int codigo = vistagimnasio.obtenerCodigoAEliminar();
            gimnasioDAO.deletegimnasioByCodigo(codigo);
            vistagimnasio.mostrarMensaje("gimnasio eliminado exitosamente");
        } catch (SQLException e) {
            vistagimnasio.mostrarMensaje("Error al eliminar el gimnasio: " + e.getMessage());
            e.printStackTrace();
        }
    }
}