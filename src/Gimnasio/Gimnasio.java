/**
 * @author Cristian Sánchez Martínez
 */
package Gimnasio;
/**
 * Clase que representa un gimnasio con su código y nombre.
 */
public class Gimnasio {

    private int codigo;     // Código único del gimnasio
    private String nombre;  // Nombre del gimnasio

    /**
     * Constructor de la clase Gimnasio.
     * @param codigo Código único del gimnasio.
     * @param nombre Nombre del gimnasio.
     */
    public Gimnasio(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    /**
     * Convierte los datos del gimnasio a formato JSON.
     * @return Representación JSON del gimnasio.
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Gimnasio\": {\n")
                .append("\t \"Codigo\": ").append("\"" + codigo + "\"").append(",\n")
                .append("\t \"Nombre\": ").append("\"" + nombre + "\"").append(",\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }

    /**
     * Convierte los datos del gimnasio a formato XML.
     * @return Representación XML del gimnasio.
     */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<gimnasio>\n")
                .append("\t <codigo>: ").append(codigo).append("</codigo>\n")
                .append("\t <nombre>: ").append(nombre).append("</nombre>\n")
                .append("</gimnasio>");

        return xmlBuilder.toString();
    }
}
