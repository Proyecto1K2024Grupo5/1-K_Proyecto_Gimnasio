package DAO.GimnasioDAO.db;

import model.gimnasio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
                        crearTabla(connection);
                        crearDatosEjemplo();
                    } catch (SQLException e) {
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

    // Crea la tabla si no existe
    private static void crearTabla(Connection conexion) throws SQLException {
        try (Statement statement = conexion.createStatement()) {
            statement.executeUpdate(
                    GimnasioDAO.CREATE_TABLE_gimnasio
            );
            System.out.println("Tabla gimnasio creada correctamente.");
        }
    }

    // Crea datos de ejemplo iniciales
    public static void crearDatosEjemplo() throws SQLException {
        GimnasioDAO gimnasioDAO = GimnasioDAO.getInstance();
        try {
            if(gimnasioDAO.totalgimnasios() == 0) {
                gimnasioDAO.insertgimnasio(new gimnasio(1, "gimnasio Central"));
                gimnasioDAO.insertgimnasio(new gimnasio(2, "gimnasio Norte"));
                gimnasioDAO.insertgimnasio(new gimnasio(3, "gimnasio Sur"));
                gimnasioDAO.insertgimnasio(new gimnasio(4, "gimnasio Este"));
                gimnasioDAO.insertgimnasio(new gimnasio(5, "gimnasio Oeste"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}