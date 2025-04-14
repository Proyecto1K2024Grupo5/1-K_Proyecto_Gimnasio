package Clases;

/**
* Clase Trabajador
* @version 01-2025
* @author Fernando del Alamo
* @since 07-04-2025
*/
public class Trabajador {

    protected String nif;       
    protected String nombre;     
    protected String apellidos;  
    protected String fnac; 
    protected String email;   

    /**
    * Constructor de la clase Trabajador con todos los atributos
    * @param nif NIF del trabajador
    * @param nombre Nombre del trabajador
    * @param apellidos Apellidos del trabajador
    * @param fnac Fecha de nacimiento del trabajador
    * @param email Correo electrónico del trabajador
    */
    public Trabajador(String nif, String nombre, String apellidos, String fnac, String email) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.email = email;
    }

    /** Metodo vacío que es de dirigir */
    public void dirigir() {}

    /** @return NIF del trabajador */
    public String getNif() {
        return nif;
    }

    /** @param nif Nuevo NIF del trabajador */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /** @return Nombre del trabajador */
    public String getNombre() {
        return nombre;
    }

    /** @param nombre Nuevo nombre del trabajador */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** @return Apellidos del trabajador */
    public String getApellidos() {
        return apellidos;
    }

    /** @param apellidos Nuevos apellidos del trabajador */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /** @return Fecha de nacimiento del trabajador */
    public String getFnac() {
        return fnac;
    }

    /** @param fnac Nueva fecha de nacimiento */
    public void setFnac(String fnac) {
        this.fnac = fnac;
    }

    /** @return Email del trabajador */
    public String getEmail() {
        return email;
    }

    /** @param email Nuevo email del trabajador */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
    * Devuelve un XML del trabajador
    * @return Cadena en formato XML con los datos del trabajador
    */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<trabajador>\n")
                .append("\t<nif>").append(nif).append("</nif>\n")
                .append("\t<nombre>").append(nombre).append("</nombre>\n")
                .append("\t<apellidos>").append(apellidos).append("</apellidos>\n")
                .append("\t<fecha-de-nacimiento>").append(fnac).append("</fecha-de-nacimiento>\n")
                .append("\t<email>").append(email).append("</email>\n")
                .append("</trabajador>");

        return xmlBuilder.toString();
    }

    /**
    * Devuelve un JSON del trabajador
    * @return Cadena en formato JSON con los datos del trabajador
    */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Trabajador\": {\n")
                .append("\t\t\"Nif\": ").append("\"").append(nif).append("\",\n")
                .append("\t\t\"Nombre\": ").append("\"").append(nombre).append("\",\n")
                .append("\t\t\"Apellidos\": ").append("\"").append(apellidos).append("\",\n")
                .append("\t\t\"Fecha de nacimiento\": ").append("\"").append(fnac).append("\",\n")
                .append("\t\t\"Email\": ").append("\"").append(email).append("\"\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }
}
