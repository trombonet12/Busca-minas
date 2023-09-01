package practicafinalprog2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class CercaMines extends JFrame {

    //DECLARACIÓ ATRIBUTS
    private Tauler t;
    private Menu m;

    public CercaMines() throws IOException {
        inicialitzacio();
        inicialitzacio();
    }
    //MÉTODES

    //Métode per generar la finestra desde zero
    private void inicialitzacio() throws IOException {
        t = new Tauler();
        m = new Menu(manipuladorEventsMenu);
        t.afegirGestorEvents(eventsMouse());
        add(t, BorderLayout.CENTER);
        add(m, BorderLayout.NORTH);
        setResizable(false);
        setSize(550, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    //Métode per generar la finestra amb un tauler ja fet
    private void inicialitzacio(Tauler t) throws IOException {
        t.inicialitzacio();
        m = new Menu(manipuladorEventsMenu);
        t.afegirGestorEvents(eventsMouse());
        add(t, BorderLayout.CENTER);
        add(m, BorderLayout.NORTH);
        setResizable(false);
        setSize(550, 550);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        CercaMines tab = new CercaMines();
    }

    //GESTOR D'EVENTS DEL MOUSE
    public MouseListener eventsMouse() {
        MouseListener gestor = new MouseListener() {
            @Override
            public void mousePressed(MouseEvent e) {
                try {
                    t.contaVeins((Casella) e.getSource());
                    t.clickCasella((Casella) e.getSource());
                } catch (IOException ex) {
                    Logger.getLogger(CercaMines.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }
        };
        return gestor;
    }

    //GESTOR D'EVENTS DEL MENU
    ActionListener manipuladorEventsMenu = new ActionListener() {
        public void actionPerformed(ActionEvent evento) {
            //Feim un switch per diferenciar tots els casos que poden arribar
            //dels diferents botons del menu
            switch (evento.getActionCommand()) {
                case "GUARDAR": {
                    try {
                        guardarArxiu();
                    } catch (IOException ex) {
                        Logger.getLogger(CercaMines.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                case "OBRIR":
                    FitxerPartidaIn fpi = new FitxerPartidaIn(obrirArxiu());
                     {
                        try {
                            t = (Tauler) fpi.lectura();
                            inicialitzacio(t);
                            fpi.tancar();
                        } catch (IOException ex) {
                            Logger.getLogger(CercaMines.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                case "REINICIAR":
                    try {
                        inicialitzacio();
                    } catch (IOException ex) {
                        Logger.getLogger(CercaMines.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case "SORTIR":
                    System.exit(0);
                    break;
            }
        }

    };

    //Métode per guardar el Tauler a un arxiu
    private void guardarArxiu() throws IOException {
        JFileChooser finestra = new JFileChooser();
        finestra.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int op = finestra.showSaveDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            String fitxer = finestra.getSelectedFile() + ".dat";
            FitxerPartidaOut fpo = new FitxerPartidaOut(fitxer);
            fpo.estritura(t);
            fpo.tancar();
        }
    }

    //Métode per obtenir un String que conte el nom de l'arxiu
    private String obrirArxiu() {
        String fitxer;
        JFileChooser finestra = new JFileChooser();
        finestra.setFileSelectionMode(JFileChooser.FILES_ONLY);

        int op = finestra.showSaveDialog(this);

        if (op == JFileChooser.APPROVE_OPTION) {
            fitxer = finestra.getSelectedFile().getAbsolutePath();
        } else {
            fitxer = null;
        }

        return fitxer;
    }

}
