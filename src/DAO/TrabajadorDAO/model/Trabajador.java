package DAO.TrabajadorDAO.model;

public class Trabajador {
    private String nif;
    private String nombre;
    private String apellidos;
    private String fnac;
    private String email;

    //este constructor nos permite leer los datos de la base de datos
    public Trabajador(String nif, String nombre, String apellidos, String fnac, String email){
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.email = email;
    }

    // Getters y setters
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

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEdad() {
        return fnac;
    }

    public void setEdad(String fnac) {
        this.fnac = fnac;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    // Método toString para representación de cadena del objeto
    @Override
    public String toString() {
        return "Trabajador{" +
                "nif=" + nif +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellidos + '\'' +
                ", fnac=" + fnac + '\'' +
                ", email=" + email +
                '}';
    }
}

