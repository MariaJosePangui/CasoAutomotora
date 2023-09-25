
package view;
import javax.swing.*;
import java.awt.*;

public class Tabla extends JFrame{
    private JPanel panel;

    public Tabla(JTable tabla){
        setTitle("Tabla de búsqueda");
        setBounds(50, 50, 400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        iniciarComponentes(tabla);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void iniciarComponentes(JTable tabla){
        generarPanel();
        mostrarTabla(tabla);
    }

    public void generarPanel(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.white);
        this.getContentPane().add(panel);
    }

    public void mostrarTabla(JTable tabla){
        panel.add(tabla);
    }
}

