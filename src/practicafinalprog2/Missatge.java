package practicafinalprog2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Missatge extends JFrame {
    //ATRIBUTS
    private JTextField text;
    private JButton boto;
    
    //CONSTRUCTORS
    public Missatge(int n) {
        inicialitzacio(n);
    }
    
    //Metode que crea la finestra emergent per indicar si has guanyat o has perdut
    private void inicialitzacio(int n) {
        if (n == 0) {
            text = new JTextField("                 HAS PERDUT");
        } else {
            text = new JTextField("                 HAS GUANYAT");
        }
        text.setFocusable(false);
        boto = new JButton("Acceptar");
        boto.setFocusable(false);
        boto.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(text, BorderLayout.CENTER);
        add(boto, BorderLayout.SOUTH);
        setResizable(false);
        setSize(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
}
