package data;
import model.Cliente;
import model.Vehiculo;
import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    public static boolean registrarDatos(List objetos, String direccionArchivo) {
        try {
            File file = new File(direccionArchivo);
            Files.deleteIfExists(Paths.get(direccionArchivo));
            File fichero = new File(direccionArchivo);
            fichero.createNewFile();
            FileWriter fw = new FileWriter(fichero, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Object objeto : objetos) {
                bw.write(objeto.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static ArrayList<Cliente> leerArchivoCliente(String direccionArchivo) {
        ArrayList<Cliente> listaClientes = new ArrayList<>();
        String textoArchivo = "";
        try {
            File archivo = new File(direccionArchivo);
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                listaClientes.add(new Cliente(data[0], data[1],Integer.parseInt(data[2]),data[3],data[4]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Documento no disponible, favor contactar con administrador");
        }
        return listaClientes;
    }

    public static ArrayList<Vehiculo> leerArchivoVehiculo() {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        String textoArchivo = "";
        try {
            File archivo = new File("Vehiculos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            while ((textoArchivo = br.readLine()) != null) {
                String[] data = textoArchivo.split(",");
                listaVehiculos.add(new Vehiculo(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),data[4],data[5]));
            }
            br.close();
            fr.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Documento no disponible, favor contactar con administrador");
        }
        return listaVehiculos;
    }
}