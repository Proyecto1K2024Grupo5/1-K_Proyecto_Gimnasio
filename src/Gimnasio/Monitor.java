/**
 * @author Cristian Sánchez Martínez
 */
package Gimnasio;

/**
 * Clase que representa a un monitor del gimnasio.
 * Hereda de la clase Trabajador.
 */
public class Monitor extends Trabajador {

    /**
     * Constructor de la clase Monitor.
     * @param nif NIF del monitor.
     * @param nombre Nombre del monitor.
     * @param apellidos Apellidos del monitor.
     * @param fnac Fecha de nacimiento del monitor.
     * @param email Email del monitor.
     */
    public Monitor(String nif, String nombre, String apellidos, String fnac, String email) {
        super(nif, nombre, apellidos, fnac, email);
    }

    /**
     * Método que simula que el monitor está dirigiendo una clase.
     */
    public void dirigir() {
       
    }

    /**
     * Convierte los datos del monitor a formato XML.
     * @return Representación XML del monitor.
     */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<monitor>\n")
                .append("\t<nif-monitor>").append(getNif()).append("</nif-monitor>\n")
                .append("</monitor>");

        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos del monitor a formato JSON.
     * @return Representación JSON del monitor.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Monitor\": {\n")
                .append("\t\t\"Nif monitor\": \"").append(getNif()).append("\"\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }
}
