package DAO.SalaDAO.model;

public class Sala {
    private int id;
    private String nombre;
    private String hechia;
    private String turno;
    private String sulfa;

    // Constructor para leer datos de la base de datos
    public Sala(int id, String nombre, String hechia, String turno, String sulfa) {
        this.id = id;
        this.nombre = nombre;
        this.hechia = hechia;
        this.turno = turno;
        this.sulfa = sulfa;
    }

    // Constructor para crear una nueva sala (el id lo genera MySQL)
    public Sala(String nombre, String hechia, String turno, String sulfa) {
        this.nombre = nombre;
        this.hechia = hechia;
        this.turno = turno;
        this.sulfa = sulfa;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getHechia() {
        return hechia;
    }

    public void setHechia(String hechia) {
        this.hechia = hechia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getSulfa() {
        return sulfa;
    }

    public void setSulfa(String sulfa) {
        this.sulfa = sulfa;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", hechia='" + hechia + '\'' +
                ", turno='" + turno + '\'' +
                ", sulfa='" + sulfa + '\'' +
                '}';
    }
}