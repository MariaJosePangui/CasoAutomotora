package view;
import controller.GestorAutomotora;
import model.Vehiculo;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroVehiculo extends JFrame{
    private JPanel panel;

    public RegistroVehiculo (){
        setTitle("Registro de vehiculo");
        setBounds(50, 50, 400, 370);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        registroVehiculo();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JLabel crearEtiqueta(String texto, int x, int y, int ancho, int alto,String estiloTexto){
        JLabel etiqueta = new JLabel();
        etiqueta.setText(texto);
        etiqueta.setBounds(x,y,ancho,alto);
        etiqueta.setHorizontalAlignment(SwingConstants.LEFT);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font(estiloTexto,1,alto));
        return etiqueta;
    }

    public JTextField crearCajaTexto(int x, int y, int ancho, int alto){
        JTextField cajaTexto = new JTextField();
        cajaTexto.setBounds(x,y,ancho,alto);
        return cajaTexto;
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto){
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public void registroVehiculo() {
        JLabel etiqueta1 = crearEtiqueta("Registro de vehiculo", 120, 10, 200, 20, "Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Modelo del vehiculo: ", 10, 50, 210, 14, "Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Año: ", 10, 130, 100, 14, "Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Precio: ", 10, 170, 170, 14, "Calibri");
        panel.add(etiqueta4);

        JLabel etiqueta5 = crearEtiqueta("Kilómetros recorrido: ", 10, 210, 170, 14, "Calibri");
        panel.add(etiqueta5);

        JLabel etiqueta6 = crearEtiqueta("Marca del vehiculo: ",10,90,150,14,"Calibri");
        panel.add(etiqueta6);

        JLabel etiqueta7 = crearEtiqueta("Color del vehiculo: ",210,90,120,14,"Calibri");
        panel.add(etiqueta7);

        JTextField cajaTexto1 = crearCajaTexto(170, 50, 170, 14);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(170, 130, 170, 14);
        panel.add(cajaTexto2);

        JTextField cajatexto3 = crearCajaTexto(170,170,170,14);
        panel.add(cajatexto3);

        JTextField cajaTexto4 = crearCajaTexto(170,210,170,14);
        panel.add(cajaTexto4);

        JButton boton1 = crearBoton("Registrar",40,270,150,18,"Arial");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver a menu",200,270,150,18,"Arial");
        panel.add(boton2);

        String[] marcas = {"Toyota", "Honda","Suzuki","Nissan"};
        JComboBox listaDesplegable1 = new JComboBox(marcas);
        listaDesplegable1.setBounds(130,87,70,16);
        panel.add(listaDesplegable1);

        String[] colores = {"Azul","Negro","Verde","Rojo","Rosado"};
        JComboBox listaDesplegable2 = new JComboBox(colores);
        listaDesplegable2.setBounds(325,87,50,16);
        panel.add(listaDesplegable2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorAutomotora gestorAutomotora = new GestorAutomotora();
                String modelo = cajaTexto1.getText();
                int anio = Integer.parseInt(cajaTexto2.getText());
                int precio = Integer.parseInt(cajatexto3.getText());
                int kilometroRecorridos = Integer.parseInt(cajaTexto4.getText());
                String marca = (String) listaDesplegable1.getSelectedItem();
                String color = (String) listaDesplegable2.getSelectedItem();
                Vehiculo vehiculo= new Vehiculo(modelo,anio,precio,kilometroRecorridos,color,marca);
                gestorAutomotora.agregarVehiculo(vehiculo);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Menu ventanaMenu = new Menu();
                ventanaMenu.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);
    }
}