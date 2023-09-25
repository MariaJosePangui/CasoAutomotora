package controller;
import data.GestorDatos;
import model.Cliente;
import model.Vehiculo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GestorAutomotora {

    public void agregarCliente(Cliente cliente){
        ArrayList<Cliente> listaClientes = GestorDatos.leerArchivoCliente("Clientes.txt");
        if(ValidadorRut.validarDigito(cliente.getRut())){
            if(validar(cliente.getCorreoElectronico())){
                Cliente cliente1 = buscarCliente(cliente);
                if(cliente1 == null){
                    JOptionPane.showMessageDialog(null,"El clientes ha sido registrado correctamente");
                    listaClientes.add(cliente);
                    GestorDatos.registrarDatos(listaClientes,"Clientes.txt");
                }else{
                    JOptionPane.showMessageDialog(null,"El cliente ya había sido registrado anteriormente");
                }
            }else{
                JOptionPane.showMessageDialog(null,"El correo no contiene un @, por favor ingréselo correctamente");
            }
        }else{
            JOptionPane.showMessageDialog(null,"El rut es invalido");
        }
    }
    public void agregarVehiculo(Vehiculo vehiculo){
        ArrayList<Vehiculo> listaVehiculos = GestorDatos.leerArchivoVehiculo();
        listaVehiculos.add(vehiculo);
        GestorDatos.registrarDatos(listaVehiculos,"Vehiculos.txt");
        JOptionPane.showMessageDialog(null,"El vehiculo ha sido registrado correctamente");
    }
    public Cliente buscarCliente(Cliente cliente){
        ArrayList<Cliente> listaClientes = GestorDatos.leerArchivoCliente("Clientes.txt");
        for(Cliente cliente1 : listaClientes){
            if(cliente.getRut().equals(cliente1.getRut())){
                return cliente;
            }
        }
        return null;
    }
    public JTable buscarVehiculo(String marca, String modelo){
        ArrayList<Vehiculo> listaVehiculos = GestorDatos.leerArchivoVehiculo();
        DefaultTableModel modeloTabla = new DefaultTableModel();
        String[] nombreColumnas = {"Modelo","Marca","Año","Precio","Color","Kilómetros recorridos"};
        modeloTabla.addColumn(nombreColumnas);
        for(Vehiculo vehiculo1 : listaVehiculos){
            if(vehiculo1.getModelo().equals(modelo) && vehiculo1.getMarca().equals(marca)){
                String[] puesto1 = {vehiculo1.getModelo(),vehiculo1.getMarca(), String.valueOf(vehiculo1.getAnio()), String.valueOf(vehiculo1.getPrecio()),vehiculo1.getColor(), String.valueOf(vehiculo1.getKilometrosRecorrido())};
                modeloTabla.addRow(puesto1);
            }
        }
        JTable tabla = new JTable(modeloTabla);
        return tabla;
    }
    public boolean validar(String correo) {
        String regex = ".*@.*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);
        return matcher.matches();
    }
}