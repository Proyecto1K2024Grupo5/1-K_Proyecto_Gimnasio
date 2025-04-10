/**
 * @author Akram Allaoui
 */
package Gimnasio;
/**
 * Representa una clase grupal ofrecida en el gimnasio.
 */

public class Clases extends Sala {
/**
     * Constructor para crear una clase programada.
     * @param nifCliente NIF del cliente que reserva
     * @param codGimnasio Código del gimnasio 
     * @param codigo Código único de la clase 
     * @param clases Tipo de clase (1=Spinning, 2=Yoga,...)
     * @param horario Horario en formato "Día HH:MM-HH:MM"
     */
    public Clases(String nifCliente, int codGimnasio, int codigo, int clases, String horario) {
        super(nifCliente, codGimnasio, codigo, clases, horario);
    }
/**
     * Serializa la clase a formato JSON.
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
     * Serializa la clase a formato XML.
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
