/**
 * @author Akram Allaoui
 */
package Gimnasio;
/**
 * Representa el registro de acceso de un cliente al gimnasio.
 */

public class Acceso {

    private int codigoGimnasio;
    private String nifCliente;
    private String fechaEntrada;
    private String fechaSalida;
/**
     * Constructor para crear un registro de acceso.
     * @param codigo Código único del gimnasio (4 dígitos)
     * @param nif NIF del cliente (formato 12345678X)
     * @param feEn Fecha y hora de entrada (formato dd/MM/yyyy HH:mm)
     * @param fecSa Fecha y hora de salida (formato dd/MM/yyyy HH:mm)
     * @throws IllegalArgumentException Si algún parámetro no cumple el formato
     */

    public Acceso(int codigo, String nif, String feEn, String fecSa) {

        this.codigoGimnasio = codigo;
        this.nifCliente = nif;
        this.fechaEntrada = feEn;
        this.fechaSalida = fecSa;
    }

    /**
     * Genera representación JSON del acceso.
     * @return String en formato JSON con todos los campos
     * @example {"Acceso": {"CodigoGimnasio": "1234", "nifCliente": "12345678X", ...}}
     */

        public String toJson() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("{\n")
            .append("\t\"Acceso\": {\n")
            .append("\t \"CodigoGimnasio\": ").append("\"" + codigoGimnasio + "\"").append(",\n")
            .append("\t \"nifCliente\": ").append("\"" + nifCliente + "\"").append(",\n")
            .append("\t \"fechaEntrada\": ").append("\"" + fechaEntrada + "\"").append(",\n")
            .append("\t \"fechaSalida\": ").append("\"" + fechaSalida + "\"").append(",\n")
                .append("\t}\n")
                .append("}");

        return jsonBuilder.toString();

        }
/**
     * Genera representación XML del acceso.
     * @return String en formato XML con todos los campos
     * @example <Acceso><CodigoGimnasio>1234</CodigoGimnasio>...</Acceso>
     */
    public String toXml() {
        StringBuilder jsonBuilder = new StringBuilder();

        jsonBuilder.append("<Acceso>\n")
                .append("\t <CodigoGimnasio>: ").append(codigoGimnasio).append("</CodigoGimnasio>\n")
                .append("\t <nifCliente>: ").append(nifCliente).append("</nifCliente>\n")
                .append("\t <fechaEntrada>: ").append(fechaEntrada).append("</fechaEntrada>\n")
                .append("\t <fechaSalida>: ").append(fechaSalida).append("</fechaSalida>\n")
                .append("</Acceso>");

        return jsonBuilder.toString();

    }
}
