package practicafinalprog2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Menu extends JPanel {

    //ATRIBUTS
    private JMenu menu;
    private JMenuItem opcGuardar;
    private JMenuItem opcObrir;
    private JMenuItem opcReiniciar;
    private JMenuItem opcSortir;
    private JMenuBar barraMenu;
    
    //CONSTRUCTOR
    public Menu(ActionListener gestor) {
        inicialitzacio(gestor);
    }
    
    //Metode que crea el menu amb tots els botons corresponents. També posa els ActionListeners
    public void inicialitzacio(ActionListener manipuladorEventsMenu) {

        barraMenu = new JMenuBar();
        menu = new JMenu("MENU");
        opcGuardar = new JMenuItem("GUARDAR");
        opcObrir = new JMenuItem("OBRIR");
        opcReiniciar = new JMenuItem("REINICIAR");
        opcSortir = new JMenuItem("SORTIR");
        opcGuardar.addActionListener(manipuladorEventsMenu);
        opcObrir.addActionListener(manipuladorEventsMenu);
        opcReiniciar.addActionListener(manipuladorEventsMenu);
        opcSortir.addActionListener(manipuladorEventsMenu);

        menu.add(opcGuardar);
        menu.add(opcObrir);
        menu.add(opcReiniciar);
        menu.add(opcSortir);
        setLayout(new GridLayout(1, 1));
        barraMenu.add(menu, BorderLayout.WEST);

        add(barraMenu);
        setVisible(true);

    }

}
