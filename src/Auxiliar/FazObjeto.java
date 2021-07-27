package Auxiliar;

import Modelo.*;

/**
 *
 * @author lucas
 */
public class FazObjeto {
    public static void main(String[] args) {
        Save s = new Save();
        BlocoVermelho bv = new BlocoVermelho(0,0);
        SetaCima sc = new SetaCima(0,0);
        s.createFile("setacima.txt", sc);
        s.createFile("blocovermelho.txt", bv);
    }
}
