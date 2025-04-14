
package Clases;

/**
 * Clase que representa a un cliente del gimnasio con todas sus propiedades
 * @author Fernando Rodriguez
 * @version 1.0
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
     * Constructor por defecto que no contiene ningun parametro para la creacion de un Cliente
     */
    public Cliente(){

    }

    /**
     * Constructor de un nuevo cliente con todas sus propiedades pasadas como parametros
     * @param nif Almacenamos el nif del cliente en su propiedad
     * @param nombre Almacenamos el nombre del cliente en su propiedad
     * @param apellidos Almacenamos los apellidos del cliente en su propiedad
     * @param fnac Almacenamos la fecha de nacimiento del cliente en su propiedad
     * @param fAlta Almacenamos la fecha de alta del cliente en su propiedad
     * @param contAcceso Almacenamos lo accesos del cliente en su propiedad
     * @param tipoMembresia Almacenamos el tipo de memebresia que tiene el cliente en su propiedad
     */
    public Cliente(String nif, String nombre, String apellidos, String fnac, String fAlta, int contAcceso, String tipoMembresia){

        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fnac = fnac;
        this.fAlta = fAlta;
        this.contAcceso = contAcceso;
        this.tipoMembresia = tipoMembresia;

    }

    /**
     * Metodo para realizar el pago de un cliente en el gimnasio
     */
    public void pagar(){
        System.out.println("Acabas de pagar una mensualidad");
    }

    /**
     * Metodo para realizar la reserva de un cliente en el gimnasio
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
     * Metodo para generar la informacion de un cliente en formato XML
     * @return Devuelve la informacion del cliente en formato XML
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
