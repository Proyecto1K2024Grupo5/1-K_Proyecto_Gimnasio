package DAO.TrabajadorDAO.db;

import model.Trabajador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase PersonaDAO que gestiona el acceso a la base de datos para la entidad Persona.
 * Implementa el patrón Singleton para asegurar una única instancia.
 */
public class TrabajadorDAO {

    // Instancia única de PersonaDAO
    private static TrabajadorDAO instance;
    // Conexión a la base de datos
    private Connection connection;

    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO trabajador (nif, nombre, apellidos, fnac, email) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM trabajador";
    private static final String SELECT_BY_NIF_QUERY = "SELECT * FROM trabajador WHERE nif = ?";
    private static final String UPDATE_QUERY = "UPDATE trabajador SET nombre = ?, apellidos = ?, fnac = ?, email = ? WHERE nif = ?";
    private static final String DELETE_QUERY = "DELETE FROM trabajador WHERE nif = ?";
    private static final String TOTAL_PERSONAS_QUERY = "SELECT COUNT(*) FROM trabajador";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private TrabajadorDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de PersonaDAO.
     */
    public static synchronized TrabajadorDAO getInstance() {
        if (instance == null) {
            instance = new TrabajadorDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva trabajador en la base de datos.
     * @param trabajador Objeto Persona a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertPersona(Trabajador trabajador) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, trabajador.getNif());
            statement.setString(2, trabajador.getNombre());
            statement.setString(3, trabajador.getApellido());
            statement.setString(4, trabajador.getEdad());
            statement.setString(5, trabajador.getEmail());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las personas almacenadas en la base de datos.
     * @return Lista de objetos Persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Trabajador> getAllPersonas() throws SQLException {
        List<Trabajador> trabajadors = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trabajadors.add(resultSetToPersona(resultSet));
            }
        }
        return trabajadors;
    }

    /**
     * Obtiene una trabajador a partir de su DNI.
     * @param nif Identificador único de la trabajador.
     * @return Objeto Persona si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Trabajador getPersonaByNif(String nif) throws SQLException {
        Trabajador trabajador = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_NIF_QUERY)) {
            statement.setString(1, nif);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                trabajador = resultSetToPersona(resultSet);
            }
        }
        return trabajador;
    }

    /**
     * Actualiza los datos de una trabajador en la base de datos.
     * @param trabajador Objeto Persona con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updatePersona(Trabajador trabajador) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, trabajador.getNombre());
            statement.setString(2, trabajador.getApellido());
            statement.setString(3, trabajador.getEdad());
            statement.setString(4, trabajador.getEmail());
            statement.setString(5, trabajador.getNif());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una trabajador de la base de datos por su DNI.
     * @param nif Identificador único de la trabajador a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deletePersonaByNif(String nif) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, nif);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Persona.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Persona con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Trabajador resultSetToPersona(ResultSet resultSet) throws SQLException {
        return new Trabajador(
                resultSet.getString("nif"),
                resultSet.getString("nombre"),
                resultSet.getString("apellidos"),
                resultSet.getString("fnac"),
                resultSet.getString("email"));
    }

    /**
     * Obtiene el total de personas almacenadas en la base de datos.
     * @return Número total de personas.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public int totalPersonas() throws SQLException {
        int total = 0;
        try (PreparedStatement statement = connection.prepareStatement(TOTAL_PERSONAS_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                total = resultSet.getInt(1);
            }
        }
        return total;
    }
}
