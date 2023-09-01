package practicafinalprog2;

import java.io.*;

public class FitxerPartidaIn {
    //ATRIBUTS
    private ObjectInputStream fitxer = null;
    
    //CONSTRUCTOR
    public FitxerPartidaIn(String nomFitx) {
        try {
            fitxer = new ObjectInputStream(new FileInputStream(nomFitx));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR ENLLAÇ FIXTER LECTURA: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("ERROR ENLLAÇ FITXER LECTURA: " + ex.toString());
        }
    }
    
    //Metode que llegeix un objecte Tauler d'un arxiu
    public Tauler lectura() throws IOException {
        Tauler objecte = new Tauler();
        try {
            objecte = (Tauler) fitxer.readObject();
        } catch (ClassNotFoundException ex) {
            System.out.println("ERROR EN LECTURA DE FITXER: " + ex.toString());

        } catch (IOException ex) {
            System.out.println("ERROR EN LECTURA DE FITXER: " + ex.toString());
        }
        return objecte;
    }
    
    //Metode per tancar la connexió logica amb l'arxiu
    public void tancar() {
        try {
            if (fitxer != null) {
                fitxer.close();
            }

        } catch (IOException ex) {
            System.out.println("ERROR EN TANCAR FITXER LECTURA: " + ex.toString());
        }
    }

}
