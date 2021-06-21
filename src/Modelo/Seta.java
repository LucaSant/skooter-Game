package Modelo;

import java.util.ArrayList;

import Auxiliar.Posicao;

public class Seta extends Elemento {

    protected int orientacion;
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
         
         h.setOrientacion(s.getOrientacion()); //------------------------------Talvez eu apague, o jogo original não faz isso
         if(this.isWaitedframe()){
             switch(s.getOrientacion()) {
                 case 0:
                     h.moveDown();
                     //movimentoSeta(e, p, eTemp);
                     this.setWaitedframe(false);
                     break;
                 case 1:
                     h.moveUp();
                     //movimentoSeta(e, p, eTemp);
                     this.setWaitedframe(false);
                     break;
                 case 3:
                     h.moveRight();
                     //movimentoSeta(e, p, eTemp);
                     this.setWaitedframe(false);
                     break;
                 case 2:
                     h.moveLeft();
                     //movimentoSeta(e, p, eTemp);
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

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
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
