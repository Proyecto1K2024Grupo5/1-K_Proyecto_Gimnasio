package DAO.ClienteDAO.db;

import DAO.ClienteDAO.model.Cliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    // URL de conexión a la base de datos MySQL
    private static final String URL = "jdbc:mysql://gimnasio.cztheoxa51ts.us-east-1.rds.amazonaws.com/gimnasio";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "FrancoJuan10";

    private static Connection connection;

    // Constructor privado para evitar instancias directas
    private DBConnection() {}

    // Método estático para obtener la instancia única de la conexión
    public static Connection getConnection() {
        if (connection == null) {
            // Bloqueo sincronizado para evitar concurrencia
            synchronized (DBConnection.class) {
                if (connection == null) {
                    try {
                       // Establecer la conexión
                        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                        crearDatosEjemplo();
                    } catch ( SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return connection;
    }
    // Método para cerrar la conexión
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //Crea unos datos de ejemplo
    public static void crearDatosEjemplo() throws SQLException{
        ClienteDAO personaDAO = ClienteDAO.getInstance();
        try {
            if(personaDAO.totalPersonas()==0) {
                personaDAO.insertPersona(new Cliente("74374738Y", "Fernando", "Rodriguez", "1990-02-15", "Fernan1590@gmail.com", "2021-06-03", 0, "Gold"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

