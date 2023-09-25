package view;
import controller.GestorAutomotora;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BusquedaVehiculo extends JFrame {
    private JPanel panel;

    public BusquedaVehiculo(){
        setTitle("Búsqueda de vehiculo");
        setBounds(50, 50, 305, 250);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        busquedavehiculo();
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

    public void busquedavehiculo(){
        JLabel etiqueta1 = crearEtiqueta("Modelo del vehiculo: ",10,20,170,14,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Marca de vehiculo: ",10,70,170,14,"Calibri");
        panel.add(etiqueta2);

        JTextField cajaTexto = crearCajaTexto(150,20,100,16);
        panel.add(cajaTexto);

        String[] marcas = {"Toyota", "Honda", "Suzuki", "Nissan"};
        JComboBox listaDesplegable1 = new JComboBox(marcas);
        listaDesplegable1.setBounds(150,67,70,16);
        panel.add(listaDesplegable1);

        JButton boton1 = crearBoton("Buscar Vehiculo",10,140,130,14,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver al menu",150,140,130,14,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorAutomotora gestorAutomotora = new GestorAutomotora();
                String modelo = cajaTexto.getText();
                String marca = (String) listaDesplegable1.getSelectedItem();
                JTable tabla = gestorAutomotora.buscarVehiculo(marca,modelo);
                Tabla ventanaTabla = new Tabla(tabla);
                ventanaTabla.setVisible(true);
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