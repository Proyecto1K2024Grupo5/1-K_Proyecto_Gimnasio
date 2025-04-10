package Gimnasio;

/**
* <p>Clase Musculacion, representa una sala de musculación en un gimnasio,
* heredando los atributos y métodos de la clase Sala.</p>
* @version 01-2025
* @author Juan Franco
* @since 07-04-2025
*/
public class Musculacion extends Sala {

    /**
    * Constructor con todos los parámetros para inicializar la sala de musculación.
    * @param nifCliente NIF del cliente asociado a la sala
    * @param codGimnasio Código del gimnasio al que pertenece la sala
    * @param codigo Código identificador de la sala de musculación
    * @param clases Número de clases disponibles en la sala
    * @param horario Horario de uso de la sala
    */
    public Musculacion(String nifCliente, int codGimnasio, int codigo, int clases, String horario) {
        super(nifCliente, codGimnasio, codigo, clases, horario);
    }

    /**
    * Método que genera una representación en formato JSON de la sala de musculación.  
    * @return Cadena JSON que contiene el código de musculación
    */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Musculacion\": {\n")
                .append("\t\t\"Codigo Musculacion\": ").append("\"").append(codigo).append("\"\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }

    /**
    * Método que genera una representación en formato XML de la sala de musculación.
    * @return Cadena XML que contiene el código de musculación
    */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<musculacion>\n")
                .append("\t<codigo-musculacion>").append(codigo).append("</codigo-musculacion>\n")
                .append("</musculacion>");

        return xmlBuilder.toString();
    }

}

