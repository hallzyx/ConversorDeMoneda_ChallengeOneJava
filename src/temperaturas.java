import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Vector;

 class temperaturas {
    private Vector<temperatura> vector_temperaturas;
    private String[] temperatura_options;
    private String[] abreviatura_options;



    public temperaturas(){
        vector_temperaturas=new Vector<>();
        temperatura temp1=new celsius();
        temperatura temp2=new kelvin();
        temperatura temp3=new fahrenheit();

        vector_temperaturas.add(temp1);
        vector_temperaturas.add(temp2);
        vector_temperaturas.add(temp3);

        temperatura_options=new String[]{"Celsius","Kelvin","Fahrenheit"};
        abreviatura_options=new String[]{"C","K","F"};

    }

    public Vector<temperatura> getVector_temperaturas() {
        return vector_temperaturas;
    }

    public String[] getTemperatura_options() {
        return temperatura_options;
    }

    public String[] getAbreviatura_options() {
        return abreviatura_options;
    }

    public void setVector_temperaturas(Vector<temperatura> vector_temperaturas) {
        this.vector_temperaturas = vector_temperaturas;
    }

    public void setTemperatura_options(String[] temperatura_options) {
        this.temperatura_options = temperatura_options;
    }

    public void setAbreviatura_options(String[] abreviatura_options) {
        this.abreviatura_options = abreviatura_options;
    }

    public String elegir_temperatura_entrada(){
        String token=  (String) JOptionPane.showInputDialog(null,"¿Cual es la temperatura actual?","Temperatura de entrada",
                JOptionPane.QUESTION_MESSAGE,null,getTemperatura_options(),getTemperatura_options()[0]);
        return token;
    }

    public String elegir_temperatura_salida() {
        String token2 = (String) JOptionPane.showInputDialog(null, "¿Cual es la temperatura a la que quieres cambiar?", "Temperatura de salida",
                JOptionPane.QUESTION_MESSAGE, null, getTemperatura_options(), getTemperatura_options()[1]);
        return token2;
    }
    public void imprimir_respuesta(int a, int b){
        DecimalFormat molde=new DecimalFormat("#.##");
        String rpta=molde.format(getVector_temperaturas().get(b).getCantidad());

        JOptionPane.showMessageDialog(null,"El valor de " +
                getVector_temperaturas().get(a).getCantidad()+" "+ getVector_temperaturas().get(a).getNomina()
                +" a "+temperatura_options[b]+" es: "+ rpta
                + " "+ getVector_temperaturas().get(b).getNomina());
    }
}
