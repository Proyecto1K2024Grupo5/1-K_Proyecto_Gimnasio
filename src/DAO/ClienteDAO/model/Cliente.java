
package DAO.ClienteDAO.model;

/**
 * Clase que representa a la tabla cliente de la base de datos, la cual contiene todas
 * las propiedades que necesita la tabla para su mantenimiento
 */
public class Cliente {

    private int id;
    private String nif;
    private String nombre;
    private String apellidos;
    private String fnac;
    private String email;
    private String fAlta;
    private int contAcceso;
    private String tipoMembresia;

    /**
     * Metodo para la creacion de un cliente con todas sus propiedades
     * pasadas como parametros ademas de un id que se guardara en la base de datos
     * @param id
     * @param nif
     * @param nombre
     * @param apellidos
     * @param fnac
     * @param email
     * @param fAlta
     * @param contAcceso
     * @param tipoMembresia
     */
    public Cliente(int id, String nif, String nombre, String apellidos, String fnac, String email, String fAlta, int contAcceso, String tipoMembresia) {

        this.id = id;
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.email = email;
        this.fAlta = fAlta;
        this.contAcceso = contAcceso;
        this.tipoMembresia = tipoMembresia;
    }

    /**
     * Metodo para la creacion de un cliente dentro de la base de datos, en la que ademas de
     * sus propiedades
     * @param nif
     * @param nombre
     * @param apellidos
     * @param fnac
     * @param email
     * @param fAlta
     * @param contAcceso
     * @param tipoMembresia
     */
    public Cliente(String nif, String nombre, String apellidos, String fnac, String email, String fAlta, int contAcceso, String tipoMembresia) {

        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.email = email;
        this.fAlta = fAlta;
        this.contAcceso = contAcceso;
        this.tipoMembresia = tipoMembresia;
    }

    /**
     * Metodo para la obtencion del id del cliente
     * @return Devuelve el id en formato int
     */
    public int getId() {
        return id;
    }

    /**
     * Metodo para guardar el id del cliente
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Metodo para obtener el Nif del cliente
     * @return Devuelve el Nif del cliente en formato String
     */
    public String getNif() {
        return nif;
    }

    /**
     * Metodo para guardar el Nif de un cliente que nos pasara como parametro
     * @param nif
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Metodo para obtener el nombre del cliente.
     * @return Nos devuelve el nombre del cliente en formato String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para guardar el nombre de un cliente que se le pasara como String
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener los apellidos de un cliente
     * @return Devuelve los apellidos del cliente en formato String
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * Metodo para guardar los apellidos de un cliente
     * @param apellidos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * Metodo para obtener la fecha de nacimiento
     * @return Devuelve la fecha de nacimiento en formato String
     */
    public String getFnac() {
        return fnac;
    }

    /**
     * Metodo para guardar la fecha de nacimiento de un Cliente
     * @param fnac
     */
    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    /**
     * Metodo para obtener el Email de un cliente
     * @return Devuelve el email de un cliente en formato String
     */
    public String getEmail() {
        return email;
    }

    /**
     * Metodo para guardar el Email de un cliente
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Metodo para obtener la fecha de alta de un cliente
     * @return Devuelve la fecha de alta de un cliente en formato String
     */
    public String getfAlta() {
        return fAlta;
    }

    /**
     * Metodo para guardar la fecha de alta de un cliente
     * @param fAlta
     */
    public void setfAlta(String fAlta) {
        this.fAlta = fAlta;
    }

    /**
     * Metodo para obtener los accesos de un Cliente
     * @return Devuelve los accesos en formato int
     */
    public int getContAcceso() {
        return contAcceso;
    }

    /**
     * Metodo para guardar el acceso de un cliente
     * @param contAcceso
     */
    public void setContAcceso(int contAcceso) {
        this.contAcceso = contAcceso;
    }

    /**
     * Metodo para obtener el tipo de membresia de un cliente
     * @return Devuelve el tipo de membresia de un cliente en formato String
     */
    public String getTipoMembresia() {
        return tipoMembresia;
    }

    /**
     * Guarda el tipo de membresia de un cliente
     * @param tipoMembresia
     */
    public void setTipoMembresia(String tipoMembresia) {
        this.tipoMembresia = tipoMembresia;
    }


    // Método toString para representación de cadena del objeto


    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nif='" + nif + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", fnac=" + fnac +
                ", email='" + email + '\'' +
                ", fAlta=" + fAlta +
                ", contAcceso=" + contAcceso +
                ", tipoMembresia='" + tipoMembresia + '\'' +
                '}';
    }
}

