package DAO.ClienteDAO.model;

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

    //este constructor nos permite leer los datos de la base de datos
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

    //Este contructor nos permite crear una Persona en la base de datos.
    //el, id lo genera automático Mysql
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

    // Getters y setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFnac() {
        return fnac;
    }

    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getfAlta() {
        return fAlta;
    }

    public void setfAlta(String fAlta) {
        this.fAlta = fAlta;
    }

    public int getContAcceso() {
        return contAcceso;
    }

    public void setContAcceso(int contAcceso) {
        this.contAcceso = contAcceso;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

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

