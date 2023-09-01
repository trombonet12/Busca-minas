package practicafinalprog2;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javax.swing.JPanel;

public class Tauler extends JPanel implements Serializable {

    //ATRIBUTS
    private Casella[][] caselles = new Casella[9][9];
    private final int MIDA = 9;
    private final int NUMTOTALMINES = 10;
    private Missatge m;

    //CONSTRUCTOR
    public Tauler() throws IOException {
        posaBombes();
        inicialitzacio();
        setBackground(Color.GRAY);
        setLayout(new GridLayout(9, 9));
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                add(caselles[i][j]);
            }
        }

    }

    //METODES
    //Metode que actualitza tot l'array de dues dimensions de Caselles
    public void inicialitzacio() throws IOException {
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                caselles[i][j].actualitzaCasella();
            }
        }
    }

    //Metode que reparteix 10 mines de forma aleatoria en el tauler
    private void posaBombes() {
        Random rnd = new Random();
        int i;
        int j;
        for (int k = 0; k < MIDA; k++) {
            for (int l = 0; l < MIDA; l++) {
                this.caselles[k][l] = new Casella('0', k, l);
            }
        }
        for (int n = 0; n < NUMTOTALMINES;) {
            i = rnd.nextInt(MIDA);
            j = rnd.nextInt(MIDA);
            if (!((this.caselles[i][j].getNumMines()) == -1)) {
                this.caselles[i][j].setMina();
                n++;
            }
        }

    }

    //Metode que distingeix 9 casos de caselles i conta si hi ha mines al voltant
    public void contaVeins(Casella c) throws IOException {
        int n = 0;
        int i = c.getI();
        int j = c.getJ();
        if ((i == 0) & (j == 0)) {
            if (this.caselles[0][0].getNumMines() != -1) {
                if (this.caselles[1][0].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[0][1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[1][1].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i == 0) & (j == 8)) {
            if (this.caselles[0][8].getNumMines() != -1) {
                if (this.caselles[0][7].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[1][8].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[1][7].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i == 8) & (j == 0)) {
            if (this.caselles[8][0].getNumMines() != -1) {
                if (this.caselles[8][1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][0].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][1].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i == 8) & (j == 8)) {
            if (this.caselles[8][8].getNumMines() != -1) {
                if (this.caselles[8][7].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][8].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][7].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i > 0) & (i < 8) & (j == 0)) {
            if (this.caselles[i][0].getNumMines() != -1) {
                if (this.caselles[i - 1][1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i][1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i - 1][0].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][0].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i > 0) & (i < 8) & (j == 8)) {
            if (this.caselles[i][8].getNumMines() != -1) {
                if (this.caselles[i - 1][7].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i][7].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][7].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i - 1][8].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][8].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i == 0) & (j > 0) & (j < 8)) {
            if (this.caselles[0][j].getNumMines() != -1) {
                if (this.caselles[1][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[1][j].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[1][j + 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[0][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[0][j + 1].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i == 8) & (j > 0) & (j < 8)) {
            if (this.caselles[8][j].getNumMines() != -1) {
                if (this.caselles[7][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][j].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[7][j + 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[8][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[8][j + 1].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        } else if ((i < 8) & (i > 0) & (j > 0) & (j < 8)) {
            if (this.caselles[i][j].getNumMines() != -1) {
                if (this.caselles[i - 1][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i - 1][j].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i - 1][j + 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i][j + 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][j - 1].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][j].getNumMines() == -1) {
                    n++;
                }
                if (this.caselles[i + 1][j + 1].getNumMines() == -1) {
                    n++;
                }
                this.caselles[i][j].setNumMines(n);
            } else {
                acabarPartida();
            }
        }
    }

    //SETTERS I GETTERS
    public void destapa(int i, int j) {
        caselles[i][j].destapa();
    }

    public Casella[][] getCaselles() {
        return caselles;
    }

    //Metode que posa els listeners a totes les caselles
    public void afegirGestorEvents(MouseListener gestorEvent) {
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                caselles[i][j].addMouseListener(gestorEvent);
            }
        }
    }

    //Metode que gestiona quan una casella ha estat clickada
    public void clickCasella(Casella casella) throws IOException {
        caselles[casella.getI()][casella.getJ()].destapa();
        caselles[casella.getI()][casella.getJ()].actualitzaCasella();
        comprovaVictoria();
    }

    //Metode que gestiona el final de partida
    private void acabarPartida() throws IOException {
        destapaTot();
        inicialitzacio();
        m = new Missatge(0);
    }

    //Metode que destapa totes les caselles del tauler
    private void destapaTot() throws IOException {
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                caselles[i][j].setDestapada(true);
            }
        }
    }

    //Metode que detecta quan s'ha guanyat la partida
    private void comprovaVictoria() throws IOException {
        int n = 0;
        for (int i = 0; i < MIDA; i++) {
            for (int j = 0; j < MIDA; j++) {
                if (!(caselles[i][j].isDestapada())) {
                    n++;
                }
            }
        }
        if (n == NUMTOTALMINES) {
            destapaTot();
            m = new Missatge(1);
        }

    }

}
