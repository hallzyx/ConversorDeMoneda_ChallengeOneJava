import javax.swing.*;

public class Serie {
    private String nombre;
    private int capitulos;

    private String genero;
    private boolean explicito;


    Serie(String nombre, String genero, int capitulos, boolean explicito){
        this.nombre=nombre;
        this.capitulos=capitulos;
        this.genero=genero;
        this.explicito=explicito;
    }

    public void mostrarInfo(){

        String mensaje = "Nombre: " + nombre + "\n" +
                "Género: " + genero + "\n" +
                "Capítulos: " + capitulos + "\n" +
                "Explícito: " + explicito;



        JOptionPane.showMessageDialog(null,mensaje);
    }



}
