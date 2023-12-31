package controller;
import java.util.Locale;

public class ValidadorRut {
    public static String eliminarCaracteresRut(String rut){
        rut= rut.replace(".","");
        rut= rut.replace("-","");
        return rut;
    }
    public static String[] dividirRutDigitoVerificador(String rut){
        rut= eliminarCaracteresRut(rut);
        String[] rutDividido= new String[]{rut.substring(0,rut.length()-1),rut.substring(rut.length()-1)};
        System.out.println("rut "+rutDividido[0]+" guion "+rutDividido[1]);
        return rutDividido;
    }
    public static char[] segmentarRut(String rut) {
        char[] rutInvertido = rut.toCharArray();
        rutInvertido = invertirRut(rutInvertido);
        return rutInvertido;
    }
    public static boolean validarRut(String rut){
        try {
            int rutInt = Integer.parseInt(rut);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    public static int convertirDigitoVerificador(String digito){
        int digitoVerificador;
        try {
            digitoVerificador = Integer.parseInt(digito);
            if (digitoVerificador == 0) {
                digitoVerificador= 11;
            }
        }
        catch (Exception e){
            if(digito.toUpperCase(Locale.ROOT).equals("K")){
                digitoVerificador=10;
            }
            else{
                digitoVerificador=-1;
            }
        }
        return digitoVerificador;
    }
    public static char[] invertirRut(char[] rut) {
        char aux;
        for (int i = 0; i < rut.length / 2; i++) {
            aux = rut[i];
            rut[i] = rut[rut.length - 1 - i];
            rut[rut.length - 1 - i] = aux;
        }
        return rut;
    }
    public static int multiplicacionCadena(char[] rut) {
        int resultadoCadena = 0;
        int contador = 2;
        for (int i = 0; i < rut.length; i++) {
            resultadoCadena = resultadoCadena + Integer.parseInt(String.valueOf(rut[i])) * contador;
            if (contador >= 7) {
                contador = 2;
            } else {
                contador++;
            }
        }
        return resultadoCadena;
    }
    public static int obtenerDigitoVerificador(int multiplicacionCadena){
        int digito= 11- (multiplicacionCadena % 11);
        return digito ;
    }
    public static int calcularDigito(String rut){
        char[] rutInvertido= segmentarRut(rut);
        int multiplicacionCadena= multiplicacionCadena(rutInvertido);
        return obtenerDigitoVerificador(multiplicacionCadena);
    }
    public static boolean validarDigito(String rut){
        if(rut.length()<2){
            return false;
        }
        String[] rutDigitoVerificador= dividirRutDigitoVerificador(rut);
        if(validarRut(rutDigitoVerificador[0])){
            int digitoVerificador= calcularDigito(rutDigitoVerificador[0]);
            return digitoVerificador==convertirDigitoVerificador(rutDigitoVerificador[1]);
        }
        else{
            return false;
        }
    }
}