package DAO.GimnasioDAO.db;

import DAO.GimnasioDAO.model.gimnasio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase gimnasioDAO que gestiona el acceso a la base de datos para la entidad gimnasio.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class GimnasioDAO {

    // Instancia única de gimnasioDAO
    private static GimnasioDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Sentencia SQL para crear la tabla si no existe
    public static final String CREATE_TABLE_gimnasio = """
    CREATE TABLE IF NOT EXISTS gimnasio (
        codigo INT NOT NULL,
        nombre VARCHAR(32) NOT NULL,
        PRIMARY KEY(codigo)
    );
    """;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO gimnasio (codigo, nombre) VALUES (?, ?)";

    private static final String SELECT_ALL_QUERY = "SELECT * FROM gimnasio";
    private static final String SELECT_BY_CODIGO_QUERY = "SELECT * FROM gimnasio WHERE codigo = ?";
    private static final String UPDATE_QUERY = "UPDATE gimnasio SET nombre = ? WHERE codigo = ?";
    private static final String DELETE_QUERY = "DELETE FROM gimnasio WHERE codigo = ?";
    private static final String TOTAL_gimnasioS_QUERY = "SELECT COUNT(*) FROM gimnasio";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private GimnasioDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de gimnasioDAO.
     * @return instancia única de gimnasioDAO.
     */
    public static synchronized GimnasioDAO getInstance() {
        if (instance == null) {
            instance = new GimnasioDAO();
        }
        return instance;
    }

    /**
     * Inserta un nuevo gimnasio en la base de datos.
     * @param gimnasio Objeto gimnasio a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertgimnasio(gimnasio gimnasio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setInt(1, gimnasio.getCodigo());
            statement.setString(2, gimnasio.getNombre());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todos los gimnasios almacenados en la base de datos.
     * @return Lista de objetos gimnasio.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<gimnasio> getAllgimnasios() throws SQLException {
        List<gimnasio> gimnasios = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                gimnasios.add(resultSetTogimnasio(resultSet));
            }
        }
        return gimnasios;
    }

    /**
     * Obtiene un gimnasio a partir de su código.
     * @param codigo Identificador único del gimnasio.
     * @return Objeto gimnasio si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public gimnasio getgimnasioByCodigo(int codigo) throws SQLException {
        gimnasio gimnasio = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_CODIGO_QUERY)) {
            statement.setInt(1, codigo);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                gimnasio = resultSetTogimnasio(resultSet);
            }
        }
        return gimnasio;
    }

    /**
     * Actualiza los datos de un gimnasio en la base de datos.
     * @param gimnasio Objeto gimnasio con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updategimnasio(gimnasio gimnasio) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, gimnasio.getNombre());
            statement.setInt(2, gimnasio.getCodigo());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina un gimnasio de la base de datos por su código.
     * @param codigo Identificador único del gimnasio a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deletegimnasioByCodigo(int codigo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, codigo);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto gimnasio.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto gimnasio con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private gimnasio resultSetTogimnasio(ResultSet resultSet) throws SQLException {
        return new gimnasio(
                resultSet.getInt("codigo"),
                resultSet.getString("nombre"));
    }

    /**
     * Obtiene el total de gimnasios almacenados en la base de datos.
     * @return Número total de gimnasios.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalgimnasios() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_gimnasioS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
