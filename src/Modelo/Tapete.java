 
package Modelo;

import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public abstract class Tapete extends Elemento{
    
    protected String floor;
    protected boolean waitedframe;
    
    public Tapete(String sNomeImagePNG, String label) {
        super("", "tapete"+label);
        this.bTransponivel = false;
        this.waitedframe = false;
    }
    
    public abstract void action(Hero hHero);
    
    
    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean isWaitedframe() {
        return waitedframe;
    }

    public void setWaitedframe(boolean waitedframe) {
        this.waitedframe = waitedframe;
    }
}
