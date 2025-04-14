
package Gimnasio;
/**
 * Representacion de un cliente del gimasio con todas sus propiedades y metodos
 * @author Fernando Rodriguez
 * @version 1.0
 */
public class Cliente {

    private String nif; // Propiedad que representara el documento de identificacion del cliente
    private String nombre; // Propiedad que representa el nombre del cliente
    private String apellidos; // Propiedad que representa los apellidos del cliente
    private String fnac;   // Propiedad que representa la fecha nacimiento (dd/MM/yyyy)
    private String fAlta; // Propiedad que representa la fecha alta (dd/MM/yyyy)
    private int contAcceso; // Propiedad que representa el numero de accesos de un cliente en un mes
    private String tipoMembresia; // "BASICA", "PREMIUM",... .

    /**
     * Constructor por defecto para crear un nuevo cliente sin ningun tipo de parametro
     */
    public Cliente(){

    }

    /**
     * Constructor para crear un nuevo cliente con todos sus parametros
     * @param nif  Guardamos el nif del nuevo cliente en su propiedad
     * @param nombre Guardamos el nombre del nuevo cliente en su propiedad
     * @param apellidos Guardamos los apellidos del nuevo cliente en su propiedad
     * @param fnac Guardamos la fecha de nacimiento del nuevo cliente en su propiedad
     * @param fAlta Guardamos la fecha de alta del nuevo cliente en su propiedad
     * @param contAcceso Guardamos el contador de acceso del nuevo cliente en su propiedad
     * @param tipoMembresia Guardamos el tipo de membresis del nuevo cliente en su propiedad
     */
    public Cliente(String nif, String nombre, String apellidos, String fnac, String fAlta, int contAcceso, String tipoMembresia){

        this.nif = nif; // Guardamos el nif del nuevo cliente en su propiedad
        this.nombre = nombre; // Guardamos el nombre del nuevo cliente en su propiedad
        this.apellidos = apellidos; // Guardamos los apellidos del nuevo cliente en su propiedad
        this.fnac = fnac; // Guardamos la fecha de nacimiento del nuevo cliente en su propiedad
        this.fAlta = fAlta; // Guardamos la fecha de alta del nuevo cliente en su propiedad
        this.contAcceso = contAcceso; // Guardamos el contador de acceso del nuevo cliente en su propiedad
        this.tipoMembresia = tipoMembresia; // Guardamos el tipo de membresis del nuevo cliente en su propiedad

    }


    /**
     * Metodo para registrar el pago de una mensualidad de uno de los clientes
     */
    public void pagar(){
        System.out.println("Acabas de pagar una mensualidad");
    }

    /**
     * Metodo para realizar una reserva en una de las salas del gimnasio
     */
    public void reservar(){
        System.out.println("Acabas de reservar al gimnasio");
    }

    /**
     * Metodo para registrar el acceso de un cliente a uno de los gimnasios, lo cual
     * incrementara el contador de acceso en 1
     */
    public void acceder(){
        this.contAcceso++;
    }


    /**
     * Metodo para obtener la informacion de un cliente en formato JSON para poder trabajar con el
     * @return Devuelve la descripcion de un cliente en formato String
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
     * Metodo para obtener la informacion de un cliente en formato JSON para poder trabajar con el
     *@return Devuelve la descripcion de un cliente en formato String
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
