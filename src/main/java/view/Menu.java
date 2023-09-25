package view;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame{
    private JPanel panel;

    public Menu(){
        setTitle("Menu");
        setBounds(50, 50, 300, 200);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        menu();
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public JButton crearBoton(String texto, int x, int y, int ancho, int alto, String estiloTexto){
        JButton boton = new JButton();
        boton.setText(texto);
        boton.setBounds(x,y,ancho,alto);
        boton.setForeground(Color.black);
        boton.setFont(new Font(estiloTexto,1,(alto)));
        return boton;
    }

    public void menu(){
        JButton boton1 = crearBoton("Registrar cliente",45,20,200,20,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Registrar vehiculo",45,70,200,20,"Calibri");
        panel.add(boton2);

        JButton boton3 = crearBoton("Buscar vehiculo",45,120,200,20,"Calibri");
        panel.add(boton3);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistroCliente ventanaRegistroCliente = new RegistroCliente();
                ventanaRegistroCliente.setVisible(true);
            }
        };
        boton1.addActionListener(eventoClick1);

        ActionListener eventoClick2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                RegistroVehiculo ventanaRegistroVehiculo = new RegistroVehiculo();
                ventanaRegistroVehiculo.setVisible(true);
            }
        };
        boton2.addActionListener(eventoClick2);

        ActionListener eventoClick3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                BusquedaVehiculo ventanaBusquedaVehiculo = new BusquedaVehiculo();
                ventanaBusquedaVehiculo.setVisible(true);
            }
        };
        boton3.addActionListener(eventoClick3);
    }
}