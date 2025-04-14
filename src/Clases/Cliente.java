/**
 * @author Akram Allaoui
 */
package Gimnasio;
/**
 * Representa un miembro del gimnasio con sus datos personales y membresía.
 */
public class Cliente {

    private String nif;
    private String nombre;
    private String apellidos;
    private String fnac;   // Fecha nacimiento (dd/MM/yyyy)
    private String fAlta; // Fecha alta (dd/MM/yyyy)
    private int contAcceso;
    private String tipoMembresia; // "BASICA", "PREMIUM",... .
/**
     * Registra el pago de una mensualidad.
     * Actualiza automáticamente la fecha de vencimiento.
     */
    public void pagar(){
        System.out.println("Acabas de pagar una mensualidad");
    }
      /**
     * Realiza una reserva para una clase o instalación.
     * @return true si la reserva fue exitosa
     */
    public void reservar(){
        System.out.println("Acabas de reservar al gimnasio");
    }
    /**
     * Registra un acceso al gimnasio.
     * Incrementa el contador de accesos.
     */
    public void acceder(){
        this.contAcceso++;
    }
    /**
     * Genera ficha del cliente en formato XML.
     * @return XML con todos los datos del cliente
     */
    public String toXml() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("<cliente>\n")
                .append("\t <nif>: ").append(nif).append("</nif>\n")
                .append("\t <nombre>: ").append(nombre).append("</nombre>\n")
                .append("\t <apellidos>: ").append(apellidos).append("</apellidos>\n")
                .append("\t <fecha-de-nacimiento>: ").append(fnac).append("</fecha-de-nacimiento>\n")
                .append("\t <fecha-de-alta>: ").append(fAlta).append("</fecha-de-alta>\n")
                .append("\t <contador-de-acceso>: ").append(contAcceso).append("</contador-de-acceso>\n")
                .append("\t <tipo-de-membresia>: ").append(tipoMembresia).append("</tipo-de-membresia>\n")
                .append("</cliente>");

        return jsonBuilder.toString();

    }
    /**
     * Genera ficha del cliente en formato JSON.
     * @return JSON con todos los datos del cliente
     */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Cliente\": {\n")
                .append("\t \"Nif\": ").append("\"" + nif + "\"").append(",\n")
                .append("\t \"Nombre\": ").append("\"" + nombre + "\"").append(",\n")
                .append("\t \"Apellidos\": ").append("\"" + apellidos + "\"").append(",\n")
                .append("\t \"Fecha de nacimiento\": ").append("\"" + fnac + "\"").append(",\n")
                .append("\t \"Fecha de alta\": ").append("\"" + fAlta + "\"").append(",\n")
                .append("\t \"Contador de acceso\": ").append("\"" + contAcceso + "\"").append(",\n")
                .append("\t \"Tipo de membresia\": ").append("\"" + tipoMembresia + "\"").append(",\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();

    }
}
