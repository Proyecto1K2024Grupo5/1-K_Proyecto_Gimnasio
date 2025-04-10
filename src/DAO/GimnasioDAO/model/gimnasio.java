package DAO.GimnasioDAO.model;

public class gimnasio {
    private int codigo;
    private String nombre;


    public gimnasio(int codigo, String nombre) {
        this.codigo=codigo;
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "gimnasio{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}

