package DAO.SalaDAO.db;

import model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDAO {
    private static SalaDAO instance;
    private Connection connection;

    // Sentencia SQL para crear la tabla si no existe
    public static final String CREATE_TABLE_SALA = """
    CREATE TABLE IF NOT EXISTS Sala(
        id int not null auto_increment,
        nombre VARCHAR(50) NOT NULL,
        hechia VARCHAR(50) NOT NULL,
        turno VARCHAR(50) NOT NULL,
        sulfa VARCHAR(50) NOT NULL,
        primary key(id),
        unique key(nombre)    
    );
    """;

    // Consultas SQL predefinidas
    private static final String INSERT_QUERY = "INSERT INTO Sala (nombre, hechia, turno, sulfa) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM Sala";
    private static final String SELECT_BY_NOMBRE_QUERY = "SELECT * FROM Sala WHERE nombre = ?";
    private static final String UPDATE_QUERY = "UPDATE Sala SET hechia = ?, turno = ?, sulfa = ? WHERE nombre = ?";
    private static final String DELETE_QUERY = "DELETE FROM Sala WHERE nombre = ?";
    private static final String TOTAL_SALAS_QUERY = "SELECT COUNT(*) FROM Sala";

    private SalaDAO() {
        this.connection = DBConnection.getConnection();
    }

    public static synchronized SalaDAO getInstance() {
        if (instance == null) {
            instance = new SalaDAO();
        }
        return instance;
    }

    public void insertSala(Sala sala) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, sala.getNombre());
            statement.setString(2, sala.getHechia());
            statement.setString(3, sala.getTurno());
            statement.setString(4, sala.getSulfa());
            statement.executeUpdate();
        }
    }

    public List<Sala> getAllSalas() throws SQLException {
        List<Sala> salas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                salas.add(resultSetToSala(resultSet));
            }
        }
        return salas;
    }

    public Sala getSalaByNombre(String nombre) throws SQLException {
        Sala sala = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NOMBRE_QUERY)) {
            statement.setString(1, nombre);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                sala = resultSetToSala(resultSet);
            }
        }
        return sala;
    }

    public void updateSala(Sala sala) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, sala.getHechia());
            statement.setString(2, sala.getTurno());
            statement.setString(3, sala.getSulfa());
            statement.setString(4, sala.getNombre());
            statement.executeUpdate();
        }
    }

    public void deleteSalaByNombre(String nombre) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, nombre);
            statement.executeUpdate();
        }
    }

    private Sala resultSetToSala(ResultSet resultSet) throws SQLException {
        return new Sala(
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getString("hechia"),
                resultSet.getString("turno"),
                resultSet.getString("sulfa"));
    }

    public int totalSalas() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_SALAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}