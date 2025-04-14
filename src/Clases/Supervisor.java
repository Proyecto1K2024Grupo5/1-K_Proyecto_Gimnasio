package Clases;

/**
* Clase Supervisor
* @version 01-2025
* @author Fernando del Alamo
* @since 07-04-2025
*/
public class Supervisor extends Trabajador {

    /**
    * Constructor completo de la clase Supervisor
    * @param nif NIF del supervisor
    * @param nombre Nombre del supervisor
    * @param apellidos Apellidos del supervisor
    * @param fnac Fecha de nacimiento del supervisor
    * @param email Correo electrónico del supervisor
    */
    public Supervisor(String nif, String nombre, String apellidos, String fnac, String email) {
        super(nif, nombre, apellidos, fnac, email);
    }

    /**
    * Metodo de dirigir por parte del supervisor
    */
    public void dirigir() {
    }

    /**
    * Metodo que genera un formato XML del supervisor
    * @return Cadena XML con el NIF del supervisor
    */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<supervisor>\n")
                .append("\t<nif-supervisor>").append(nif).append("</nif-supervisor>\n")
                .append("</supervisor>");

        return xmlBuilder.toString();
    }

    /**
    * Metodo que genera un formato JSON del supervisor
    * @return Cadena JSON con el NIF del supervisor
    */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Supervisor\": {\n")
                .append("\t\t\"Nif supervisor\": ").append("\"").append(nif).append("\"\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }
}
