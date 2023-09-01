package practicafinalprog2;

import java.io.*;

public class FitxerPartidaOut {
    //ATRIBUTS
    private ObjectOutputStream fitxer = null;
    
    //CONSTRUCTOR
    public FitxerPartidaOut(String nomFitx) {
        try {
            fitxer = new ObjectOutputStream(new FileOutputStream(nomFitx));
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR ENLLAÇ FITXER ESCRITURA: " + ex.toString());
        } catch (IOException ex) {
            System.out.println("ERROR ENLLAÇ FITXER ESCRITURA: " + ex.toString());
        }
    }
    
    //Metode que escriu un objecte Tauler a un arxiu
    public void estritura(Tauler objecte) {
        try {
            fitxer.writeObject(objecte);
        } catch (IOException ex) {
            System.out.println("ERROR EN L'ECRITURA DE L'OBJECTE");
        }
    }
    
    //Metode per tancar la connexió logica amb l'arxiu
    public void tancar() {
        try {
            fitxer.close();
        } catch (IOException ex) {
            System.out.println("ERROR TANCAR FITXER ESCRITURA");
        }
    }

}
