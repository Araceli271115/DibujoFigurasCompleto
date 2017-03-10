package dibujofiguras;

import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Interfaz extends JFrame {

    private final JDesktopPane escritorio;
    private final JMenuBar menu;
    private final JMenu crearVentana;
    private final JMenuItem nuevaVentana;
    private int cont = 0;
    private int posicion = 10;
    private JLabel fondo;

    public Interfaz() {
        Image icono = Toolkit.getDefaultToolkit().getImage("src\\imagenes\\icono.png");
        this.setIconImage(icono);
        ImageIcon icon = new ImageIcon("src\\imagenes\\icono.png");
        fondo = new JLabel(icon);
        fondo.setBounds(70, 0, 700, 700);
        add(fondo);
        escritorio = new JDesktopPane();
        add(escritorio);
        nuevaVentana = new JMenuItem("NUEVA VENTANA");
        nuevaVentana.setBackground(Color.DARK_GRAY);
        nuevaVentana.setForeground(Color.WHITE);
        nuevaVentana.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                fondo.setVisible(false);
                cont++;
                MarcoDibujo ventanaInterna = new MarcoDibujo("Ventana" + cont, true, true, true, true);
                ventanaInterna.setBounds(0 + posicion, 0 + posicion, 200, 200);
                posicion += 10;
                escritorio.add(ventanaInterna);
                ventanaInterna.setVisible(true);
            }
        });
        crearVentana = new JMenu("CREAR NUEVA VENTANA");
        crearVentana.setBackground(Color.DARK_GRAY);
        crearVentana.setForeground(Color.WHITE);
        crearVentana.add(nuevaVentana);
        menu = new JMenuBar();
        menu.setBackground(Color.DARK_GRAY);
        setJMenuBar(menu);
        menu.add(crearVentana);
    }
}
