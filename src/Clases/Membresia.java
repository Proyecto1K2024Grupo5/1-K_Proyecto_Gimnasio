/**
 * @author Cristian Sánchez Martínez
 */
package Clases;

/**
 * Clase Membresia
 * @author Cristian Sanchez
 * @since 07-04-2025
 * @version 01-2025
 */
public class Membresia {

    private String tipo;     // Tipo de membresía (gold, silver, bronce)
    private double precio;   // Precio de la membresía

    /**
     * Constructor de la clase Membresia
     * @param tipo Tipo de la membresía
     * @param precio Precio de la membresía
     */
    public Membresia(String tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    /**
     * Convierte los datos de la membresía a formato XML
     * @return Representación XML de la membresía
     */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<membresia>\n")
                .append("\t<tipo>").append(tipo).append("</tipo>\n")
                .append("\t<precio>").append(precio).append("</precio>\n")
                .append("</membresia>");

        return xmlBuilder.toString();
    }

    /**
     * Convierte los datos de la membresía a formato JSON
     * @return Representación JSON de la membresía
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Membresia\": {\n")
                .append("\t\t\"Tipo\": \"").append(tipo).append("\",\n")
                .append("\t\t\"Precio\": ").append(precio).append("\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }
}
