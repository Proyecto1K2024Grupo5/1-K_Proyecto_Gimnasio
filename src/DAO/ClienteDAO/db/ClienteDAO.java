package DAO.ClienteDAO.db;

import DAO.ClienteDAO.model.Cliente;

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
public class ClienteDAO {

    // Instancia única de PersonaDAO
    private static ClienteDAO instance;
    // Conexión a la base de datos
    private Connection connection;


    // Consultas SQL predefinidas para operaciones CRUD
    private static final String INSERT_QUERY = "INSERT INTO cliente (nif, nombre, apellidos, fnac, email, falta, contAcceso, tipoMembresia) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT * FROM cliente";
    private static final String SELECT_BY_DNI_QUERY = "SELECT * FROM cliente WHERE dni = ?";
    private static final String UPDATE_QUERY = "UPDATE cliente SET nombre = ?, apellido = ?, tipoMembresia = ? WHERE dni = ?";
    private static final String DELETE_QUERY = "DELETE FROM cliente WHERE dni = ?";
    private static final String TOTAL_PERSONAS_QUERY = "SELECT COUNT(*) FROM cliente";

    /**
     * Constructor privado para evitar instanciación externa.
     * Obtiene la conexión a la base de datos desde DBConnection.
     */
    private ClienteDAO() {
        this.connection = DBConnection.getConnection();
    }

    /**
     * Método estático para obtener la única instancia de PersonaDAO.
     * @return instancia única de PersonaDAO.
     */
    public static synchronized ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    /**
     * Inserta una nueva persona en la base de datos.
     * @param persona Objeto Persona a insertar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void insertPersona(Cliente persona) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
            statement.setString(1, persona.getNif());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellidos());
            statement.setString(4, persona.getFnac());
            statement.setString(5, persona.getEmail());
            statement.setString(6, persona.getfAlta());
            statement.setInt(7, persona.getContAcceso());
            statement.setString(8, persona.getTipoMembresia());
            statement.executeUpdate();
        }
    }

    /**
     * Obtiene todas las personas almacenadas en la base de datos.
     * @return Lista de objetos Persona.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public List<Cliente> getAllPersonas() throws SQLException {
        List<Cliente> personas = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                personas.add(resultSetToPersona(resultSet));
            }
        }
        return personas;
    }

    /**
     * Obtiene una persona a partir de su DNI.
     * @param dni Identificador único de la persona.
     * @return Objeto Persona si se encuentra, null si no.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public Cliente getPersonaByDni(String dni) throws SQLException {
        Cliente persona = null;
        try (PreparedStatement statement = connection.prepareStatement(SELECT_BY_DNI_QUERY)) {
            statement.setString(1, dni);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                persona = resultSetToPersona(resultSet);
            }
        }
        return persona;
    }

    /**
     * Actualiza los datos de una persona en la base de datos.
     * @param persona Objeto Persona con los datos actualizados.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void updatePersona(Cliente persona) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, persona.getNif());
            statement.setString(2, persona.getNombre());
            statement.setString(3, persona.getApellidos());
            statement.setString(4, persona.getFnac());
            statement.setString(5, persona.getEmail());
            statement.setString(6, persona.getfAlta());
            statement.setInt(7, persona.getContAcceso());
            statement.setString(8, persona.getTipoMembresia());
            statement.executeUpdate();
        }
    }

    /**
     * Elimina una persona de la base de datos por su DNI.
     * @param dni Identificador único de la persona a eliminar.
     * @throws SQLException Si ocurre un error en la base de datos.
     */
    public void deletePersonaByDni(String dni) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, dni);
            statement.executeUpdate();
        }
    }

    /**
     * Convierte un ResultSet en un objeto Persona.
     * @param resultSet Resultado de la consulta SQL.
     * @return Objeto Persona con los datos del ResultSet.
     * @throws SQLException Si ocurre un error en la conversión.
     */
    private Cliente resultSetToPersona(ResultSet resultSet) throws SQLException {
        return new Cliente(
                resultSet.getString("nif"),
                resultSet.getString("nombre"),
                resultSet.getString("apellidos"),
                resultSet.getString("fnac"),
                resultSet.getString("email"),
                resultSet.getString("falta"),
                resultSet.getInt("contAcceso"),
                resultSet.getString("tipoMembresia"));
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
