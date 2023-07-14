import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Vector;

 class monedas {
    private Vector<moneda> vector_monedas;
     private String[] divisa_options;
     private String[] moneda_options;

    monedas(){
        vector_monedas = new Vector<>();
        moneda moneda_0=new Soles();
        moneda moneda_1=new Dolar();
        moneda moneda_2=new Euro();
        moneda moneda_3=new Libras();
        moneda moneda_4=new Yen();
        moneda moneda_5=new WonCoreano();

        vector_monedas.add(moneda_0);
        vector_monedas.add(moneda_1);
        vector_monedas.add(moneda_2);
        vector_monedas.add(moneda_3);
        vector_monedas.add(moneda_4);
        vector_monedas.add(moneda_5);

        divisa_options= new String[]{"PEN", "USD", "EUR", "GPB", "YEN", "WON"};
        moneda_options= new String[]{"Soles", "Dolares", "Euros", "Libras", "Yenes", "Wones Coreanos"};
    }

    public Vector<moneda> getVector_monedas() {
        return vector_monedas;
    }

    public String[] getMoneda_options() {
        return moneda_options;
    }

    public void imprimir_respuesta(int a, int b){
        DecimalFormat molde=new DecimalFormat("#.##");
        String rpta=molde.format(getVector_monedas().get(b).getValor());

        JOptionPane.showMessageDialog(null,"El valor de " +
               getVector_monedas().get(a).getValor()+" "+ getVector_monedas().get(a).getNomina()
                +" a "+moneda_options[b]+" es: "+ rpta
                + " "+ getVector_monedas().get(b).getNomina());
    }

    public String elegir_divisa_entrada(){
       String token=  (String)JOptionPane.showInputDialog(null,"¿Cual es la divisa de tu moneda?","Divisa de entrada",
                JOptionPane.QUESTION_MESSAGE,null,getMoneda_options(),getMoneda_options()[0]);
       return token;
    }

    public String elegir_divisa_salida(){
        String token2=  (String)JOptionPane.showInputDialog(null,"¿Cual es la divisa a la que quieres cambiar tu moneda?","Divisa de salida",
                JOptionPane.QUESTION_MESSAGE,null,getMoneda_options(),getMoneda_options()[1]);
        return token2;
    }

}
