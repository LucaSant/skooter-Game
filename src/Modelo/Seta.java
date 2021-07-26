package Modelo;

import java.util.ArrayList;

import Auxiliar.Posicao;

public class Seta extends Elemento {

    protected int orientation;
    protected String floor;
    protected boolean waitedframe;
   
    protected Seta(int linha, int coluna) {
        super("transparente.png");
        this.setPosicao(linha, coluna);
        this.bSeta = true;
        this.bTransponivel = false;
        this.waitedframe = false;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public void movimentoSeta(ArrayList<Elemento> e, Posicao p, Elemento eTemp) {

         Hero h = (Hero) e.get(0);
         Seta s = (Seta) eTemp;
         
         h.setOrientation(s.getOrientation());
         if(this.isWaitedframe()){
             switch(s.getOrientation()) {
                 case 0:
                     h.moveDown();
                     this.setWaitedframe(false);
                     break;
                 case 1:
                     h.moveUp();
                     this.setWaitedframe(false);
                     break;
                 case 3:
                     h.moveRight();
                     this.setWaitedframe(false);
                     break;
                 case 2:
                     h.moveLeft();
                     this.setWaitedframe(false);
                     break;
             }
         }
         this.setWaitedframe(true);
     }

    public boolean isbSeta() {
        return bSeta;
    }

    public void setbSeta(boolean bSeta) {
        this.bSeta = bSeta;
    }

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

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