package Gimnasio;

public class principal {


    public static void main(String[] args) {



        Clases clase1 = new Clases(122);
        Acceso acces1 = new Acceso(12,"2123t", "15-02-90", "15-02-13");


        System.out.println(clase1.toXml());




    }
}
