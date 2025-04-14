package Clases;

/**
* Clase Sala
* @version 01-2025
* @author Juan Franco
* @since 07-04-2025
*/
public class Sala {

    private String nifCliente;
    private int codGimnasio;
    protected int codigo;
    private int clases;
    private String horario;

    /**
    * Constructor de la clase Sala
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

    /**
     * Metodo para obtener el nif del cliente
     * @return NIF del cliente
     */
    public String getNifCliente() {
        return nifCliente;
    }

    /**
     * Metodo para guardar el nif de un cliente
     * @param nifCliente Nuevo NIF a asignar
     */
    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    /**
     * Metodo para obtener el codigo del gimnasio
     * @return Código del gimnasio
     */
    public int getCodGimnasio() {
        return codGimnasio;
    }

    /**
     * Metodo para guardar el codigo de un gimnasio
     * @param codGimnasio Código del gimnasio a asignar
     */
    public void setCodGimnasio(int codGimnasio) {
        this.codGimnasio = codGimnasio;
    }

    /**
     * Metodo para obtener el codigo de la sala
     * @return Código de la sala
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Metodo para guardar el codigo de una sala
     * @param codigo Nuevo código de sala a asignar
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Metodo para obtener el codigo de la clase
     * @return Cantidad de clases disponibles
     */
    public int getClases() {
        return clases;
    }

    /**
     * Metodo para guardar el codigo de la clase
     * @param clases Número de clases a asignar
     */
    public void setClases(int clases) {
        this.clases = clases;
    }

    /**
     * Metodo para obtener el horario de una clase
     * @return Horario asignado a la sala
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Metodo para guardar el horario de una clase
     * @param horario Nuevo horario de la sala
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
    * Metodo que genera un formato XML de la sala
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
    * Metodo que genera un JSON de la sala
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
