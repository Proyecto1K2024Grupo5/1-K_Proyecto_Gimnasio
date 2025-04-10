package Gimnasio;

/**
* <p>Clase Sala, contiene la información general de cualquier sala dentro del gimnasio.
* Incluye atributos como NIF del cliente, código del gimnasio, código de la sala, cantidad de clases y horario.</p>
* @version 01-2025
* @author Juan Franco
* @since 07-04-2025
*/
public class Sala {

    protected String nifCliente;
    protected int codGimnasio;  
    protected int codigo;       
    protected int clases;       
    protected String horario;    

    /**
    * Constructor de la clase Sala con todos sus parámetros.
    * @param nifCliente NIF del cliente
    * @param codGimnasio Código del gimnasio
    * @param codigo Código identificador de la sala
    * @param clases Número de clases disponibles
    * @param horario Horario asignado a la sala
    */
    public Sala(String nifCliente, int codGimnasio, int codigo, int clases, String horario) {
        this.nifCliente = nifCliente;
        this.codGimnasio = codGimnasio;
        this.codigo = codigo;
        this.clases = clases;
        this.horario = horario;
    }

    /** @return NIF del cliente */
    public String getNifCliente() {
        return nifCliente;
    }

    /** @param nifCliente Nuevo NIF a asignar */
    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    /** @return Código del gimnasio */
    public int getCodGimnasio() {
        return codGimnasio;
    }

    /** @param codGimnasio Código del gimnasio a asignar */
    public void setCodGimnasio(int codGimnasio) {
        this.codGimnasio = codGimnasio;
    }

    /** @return Código de la sala */
    public int getCodigo() {
        return codigo;
    }

    /** @param codigo Nuevo código de sala a asignar */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /** @return Cantidad de clases disponibles */
    public int getClases() {
        return clases;
    }

    /** @param clases Número de clases a asignar */
    public void setClases(int clases) {
        this.clases = clases;
    }

    /** @return Horario asignado a la sala */
    public String getHorario() {
        return horario;
    }

    /** @param horario Nuevo horario de la sala */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
    * Método que genera una representación en formato XML de la sala.  
    * @return Cadena XML con los datos de la sala
    */
    public String toXml() {
        StringBuilder xmlBuilder = new StringBuilder();

        xmlBuilder.append("<sala>\n")
                .append("\t<nif-cliente>").append(nifCliente).append("</nif-cliente>\n")
                .append("\t<codigo-gimnasio>").append(codGimnasio).append("</codigo-gimnasio>\n")
                .append("\t<codigo>").append(codigo).append("</codigo>\n")
                .append("\t<clases>").append(clases).append("</clases>\n")
                .append("\t<horario>").append(horario).append("</horario>\n")
                .append("</sala>");

        return xmlBuilder.toString();
    }

    /**
    * Método que genera una representación en formato JSON de la sala.  
    * @return Cadena JSON con los datos de la sala
    */
    public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
                .append("\t\"Sala\": {\n")
                .append("\t\t\"Nif cliente\": ").append("\"").append(nifCliente).append("\",\n")
                .append("\t\t\"Codigo de gimnasio\": ").append("\"").append(codGimnasio).append("\",\n")
                .append("\t\t\"Codigo\": ").append("\"").append(codigo).append("\",\n")
                .append("\t\t\"Clases\": ").append("\"").append(clases).append("\",\n")
                .append("\t\t\"Horario\": ").append("\"").append(horario).append("\"\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();
    }
}
