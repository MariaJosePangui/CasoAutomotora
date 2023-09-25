package view;
import controller.GestorAutomotora;
import model.Cliente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroCliente extends JFrame{
    private JPanel panel;

    public RegistroCliente(){
        setTitle("Registro de cliente");
        setBounds(50, 50, 400, 370);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(){
        generarPanel();
        registroCliente();
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

    public void registroCliente(){
        JLabel etiqueta1 = crearEtiqueta("Registro de cliente",120,10,200,20,"Calibri");
        panel.add(etiqueta1);

        JLabel etiqueta2 = crearEtiqueta("Nombre: ",10,50,100,14,"Calibri");
        panel.add(etiqueta2);

        JLabel etiqueta3 = crearEtiqueta("Rut: ",10,90,100,14,"Calibri");
        panel.add(etiqueta3);

        JLabel etiqueta4 = crearEtiqueta("Dirección: ",10,130,100,14,"Calibri");
        panel.add(etiqueta4);

        JLabel etiqueta5 = crearEtiqueta("Correo electrónico: ",10,170,170,14,"Calibri");
        panel.add(etiqueta5);

        JLabel etiqueta6 = crearEtiqueta("Número telefónico: ",10,210,170,14,"Calibri");
        panel.add(etiqueta6);

        JTextField cajaTexto1 = crearCajaTexto(170,47,170,20);
        panel.add(cajaTexto1);

        JTextField cajaTexto2 = crearCajaTexto(170,87,170,20);
        panel.add(cajaTexto2);

        JTextField cajaTexto3 = crearCajaTexto(170,127,170,20);
        panel.add(cajaTexto3);

        JTextField cajatexto4 = crearCajaTexto(170,167,170,20);
        panel.add(cajatexto4);

        JTextField cajaTexto5 = crearCajaTexto(170,207,170,20);
        panel.add(cajaTexto5);

        JButton boton1 = crearBoton("Registrar",40,270,150,18,"Calibri");
        panel.add(boton1);

        JButton boton2 = crearBoton("Volver a menu",200,270,200,18,"Calibri");
        panel.add(boton2);

        ActionListener eventoClick1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GestorAutomotora gestorAutomotora = new GestorAutomotora();
                String nombre = cajaTexto1.getText();
                String rut = cajaTexto2.getText();
                String direccion = cajaTexto3.getText();
                String correoElectronico = cajatexto4.getText();
                int numeroTelefonico = Integer.parseInt(cajaTexto5.getText());
                Cliente cliente = new Cliente(nombre,direccion,numeroTelefonico,correoElectronico,rut);
                gestorAutomotora.agregarCliente(cliente);
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