package Modelo;

import Auxiliar.Posicao;
import java.util.ArrayList;


public class SetaEsquerda extends TapeteDecorator{

    public SetaEsquerda(Tapete tap) {
        super(tap);
        t.floor = "seta-esquerda.png";
        t.setLabel(t.getLabel()+";seta;esquerda");
    }
    
    @Override
     public void action(Hero h) {
       if(t.isWaitedframe()){
            h.moveLeft();
            h.setOrientation(2);
            t.setWaitedframe(false);
       }
       t.setWaitedframe(true);
       t.action(h);
     }
}