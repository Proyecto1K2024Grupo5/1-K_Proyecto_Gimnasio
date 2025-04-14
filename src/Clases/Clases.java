/**
 * @author Akram Allaoui
 */
package Clases;
/**
 * Clase Sala
 * Hereda de Sala
 * @author Akram Allaoui
 * @since 07-04-2025
 * @version 01-2025
 */
public class Clases extends Sala {
/**
     * Constructor para crear una clase
     * @param nifCliente NIF del cliente que reserva
     * @param codGimnasio Código del gimnasio 
     * @param codigo Código único de la clase 
     * @param clases Tipo de clase
     * @param horario Horario con formato
     */
    public Clases(String nifCliente, int codGimnasio, int codigo, int clases, String horario) {
        super(nifCliente, codGimnasio, codigo, clases, horario);
    }
/**
     * Convierte la clase a formato JSON
     * @return Representación JSON con el código de clase
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Clases\": {\n")
                .append("\t \"CodigoClases\": ").append("\"" + codigo + "\"").append(",\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();

    }
/**
     * Convierte la clase a formato XML
     * @return Representación XML con el código de clase
     */
    public String toXml() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("<clases>\n")
                .append("\t <codigo-de-clases>: ").append(codigo).append("</codigo-de-gimnasio>\n")
                .append("</clases>");

        return jsonBuilder.toString();

    }
}
