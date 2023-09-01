package practicafinalprog2;

import java.awt.Color;
import java.awt.Image;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Casella extends JLabel implements Serializable {

    //ATRIBUTS
    private int numMines = 0;
    private boolean destapada;
    private final int i;
    private final int j;
    private final int dimX = 56;
    private final int dimY = 56;
    private ImageIcon c;
    private ImageIcon m;
    private ImageIcon zero;
    private ImageIcon un;
    private ImageIcon dos;
    private ImageIcon tres;
    private ImageIcon quatre;

    //CONSTRUCTOR
    public Casella(char teMina, int i, int j) {
        if (teMina == 'x') {
            this.numMines = -1;
        }
        this.destapada = false;
        this.i = i;
        this.j = j;
    }

    //SETTER I GETTERS
    public boolean isDestapada() {
        return destapada;
    }

    public void setDestapada(boolean destapada) {
        this.destapada = destapada;
    }

    public void setMina() {
        this.numMines = -1;
    }

    public void destapa() {
        this.destapada = true;
    }

    public void tapa() {
        this.destapada = false;
    }

    public void setNumMines(int numMines) {
        this.numMines = numMines;
    }

    public int getNumMines() {
        return this.numMines;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    //Metode per fer que les imatges tenguin la mateixa resolució
    public ImageIcon redimensionarImagenEtiqueta(ImageIcon imagen) {
        Image imgEscalada = imagen.getImage().getScaledInstance(dimX - 4,
                dimY - 4, java.awt.Image.SCALE_DEFAULT);
        return new ImageIcon(imgEscalada);
    }

    //Metode per posar la imatge en el objecte Casella
    public void inicializacionIcono(ImageIcon imagen) {
        setIcon(redimensionarImagenEtiqueta(imagen));
        setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        setBackground(Color.GRAY);
        setOpaque(true);
    }

    //Metode per actualitzar la aparença del objecte Casella 
    public void actualitzaCasella() throws IOException {
        c = new ImageIcon("casella.png");
        zero = new ImageIcon("0.jpg");
        un = new ImageIcon("1.jpg");
        dos = new ImageIcon("2.jpg");
        tres = new ImageIcon("3.jpg");
        quatre = new ImageIcon("4.jpg");
        m = new ImageIcon("mina.jpg");
        setSize(dimX, dimY);
        //Amb la ajuda del switch i el if podem determinar si la casella esta tapada, conte una mina
        //o el nombre de mines que te al voltant.
        if (this.destapada) {
            switch (this.numMines) {
                case 0:
                    inicializacionIcono(zero);
                    break;
                case 1:
                    inicializacionIcono(un);
                    break;
                case 2:
                    inicializacionIcono(dos);
                    break;
                case 3:
                    inicializacionIcono(tres);
                    break;
                case 4:
                    inicializacionIcono(quatre);
                    break;
                case -1:
                    inicializacionIcono(m);
                    break;
            }
        } else {
            inicializacionIcono(c);
        }

    }

}
