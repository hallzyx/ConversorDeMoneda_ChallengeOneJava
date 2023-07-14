import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class main2 {
    public static void main(String[] args) {
        int bucle=0;
        UIManager.put("OptionPane.cancelButtonText","Cancelar");
        UIManager.put("OptionPane.okButtonText","Siguiente");
        UIManager.put("OptionPane.yesButtonText","Sí");
        UIManager.put("OptionPane.noButtonText","No");

        do{
            monedas manager=new monedas();
            temperaturas controler=new temperaturas();
            //Aca puedes cambiar la tasa de cambio a una más actualizada
            Map<String, Double> tasaDeCambio = new LinkedHashMap<String,Double>(){{
                put("un_sol_a_soles",1.0);
                put("un_dolar_a_soles",3.64);
                put("un_euro_a_soles",4.0);
                put("una_libra_a_soles",4.68);
                put("un_yen_a_soles",0.026);
                put("un_won_a_soles",0.0028);
            }};
            List<Double> index_tasaDeCambio=new ArrayList();
            for (Map.Entry<String, Double> entry : tasaDeCambio.entrySet()) {
                Double tasa = entry.getValue();
                index_tasaDeCambio.add(tasa);
            }
            for(int i=0;i<manager.getVector_monedas().size();i++){
                manager.getVector_monedas().get(i).setTasa(index_tasaDeCambio.get(i));
            }
            String TipoDeProceso="";
            String monedaEntrada="";
            Double montoEntrada=0.0;
            String monedaSalida="";
            Double montoSalida=0.0;
            String validar;
            String[] conversor_options={"Conversor de moneda","Conversor de temperatura"};

            TipoDeProceso =(String) JOptionPane.showInputDialog(null,"Diga que conversor desea usar: ","Tipo de Conversor",
                    JOptionPane.QUESTION_MESSAGE,null,conversor_options,conversor_options[0]);
            if(TipoDeProceso==conversor_options[0]){
                //2.1 En caso hayamos elegido el conversor de monedas...
                //2.1.1 Elegimos cual es la divisa de la moneda que queremos convertir

                monedaEntrada=manager.elegir_divisa_entrada();
                if(monedaEntrada==null){
                    break;
                }
                do{
                    validar=JOptionPane.showInputDialog(null,
                            "Ingresa la cantidad de dinero que deseas convertir: ",
                            "Ingresar Cantidad",JOptionPane.QUESTION_MESSAGE);
                    if(validar.isEmpty()){
                        JOptionPane.showMessageDialog(null,"No ha digitado un monto, intente de nuevo");
                    }
                    else if(Double.parseDouble(validar)>=0) {
                        montoEntrada=Double.parseDouble(validar);
                        break;
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"El monto digitado es negativo, intente de nuevo");
                    }
                }while(true);
                if(monedaEntrada==manager.getMoneda_options()[0]){

                    //2.1.3.1 Se Le pedirá a que moneda quiere cambiarlo
                    monedaSalida=manager.elegir_divisa_salida();
                    if(monedaSalida==null){
                        break;
                    }
                    for (int i=0;i<manager.getVector_monedas().size();i++){
                        if(manager.getMoneda_options()[i]==monedaSalida){
                            manager.getVector_monedas().get(0).setValor(montoEntrada);
                            manager.getVector_monedas().get(0).setTasa(1/manager.getVector_monedas().get(i).getTasa());
                            montoSalida=manager.getVector_monedas().get(0).exchange();
                            manager.getVector_monedas().get(i).setValor(montoSalida);
                            manager.imprimir_respuesta(0,i);
                        }
                    }
                }
                else{
                    for(int i=0;i<manager.getVector_monedas().size();i++){
                        if(monedaEntrada==manager.getMoneda_options()[i]){
                            manager.getVector_monedas().get(i).setValor(montoEntrada);
                            montoSalida=manager.getVector_monedas().get(i).exchange();
                            manager.getVector_monedas().get(0).setValor(montoSalida);
                            manager.imprimir_respuesta(i,0);
                        }
                    }
                }
            }
            else if(TipoDeProceso==conversor_options[1]){
                //2.2 En caso hayamos elegido el conversor de temperatura...
                monedaEntrada=controler.elegir_temperatura_entrada();
                if(monedaEntrada==null){
                    break;
                }
                do{
                    validar=JOptionPane.showInputDialog("Ingresa la temperatura: ");
                    if(validar.isEmpty()){
                        JOptionPane.showMessageDialog(null,"No ha digitado una cifra, intente de nuevo");
                    }
                    else {
                        montoEntrada = Double.parseDouble(validar);
                        break;
                    }
                }while(true);
                monedaSalida=controler.elegir_temperatura_salida();
                for(int i=0;i<controler.getVector_temperaturas().size();i++){
                    for(int j=0;j<controler.getVector_temperaturas().size();j++){
                        if(monedaEntrada==controler.getTemperatura_options()[i]&&monedaSalida==controler.getTemperatura_options()[j]){
                            controler.getVector_temperaturas().get(i).setCantidad(montoEntrada);
                            controler.getVector_temperaturas().get(i).igualar();
                            montoSalida=controler.getVector_temperaturas().get(i).convertir(j);
                            controler.getVector_temperaturas().get(j).setCantidad(montoSalida);
                            controler.imprimir_respuesta(i,j);
                        }
                    }
                }
            }
            else{
                break;
            }
            bucle=JOptionPane.showConfirmDialog(null,"¿Deseas realizar el proceso de conversion otra vez?",
                    "¿Continuar?",JOptionPane.YES_NO_OPTION);
            if(bucle==JOptionPane.YES_OPTION){
                bucle=0;
            }
            else if(bucle==JOptionPane.NO_OPTION){
                bucle=1;
            }
        }while(bucle==0);

    }

}
