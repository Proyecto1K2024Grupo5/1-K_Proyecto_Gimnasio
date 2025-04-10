package Gimnasio;

/**
* <p>Clase Supervisor, representa un trabajador con rol de supervisor en el gimnasio.  
* Hereda de la clase {@code Trabajador} y puede dirigir actividades.</p>
* @version 01-2025
* @author Fernando del Alamo
* @since 07-04-2025
*/
public class Supervisor extends Trabajador {

    /**
    * Constructor completo de la clase Supervisor.
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
    * Método que representa la acción de dirigir por parte del supervisor.  
    * (Actualmente sin implementación).
    */
    public void dirigir() {
    }

    /**
    * Método que genera una representación en formato XML del supervisor.  
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
    * Método que genera una representación en formato JSON del supervisor.  
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
