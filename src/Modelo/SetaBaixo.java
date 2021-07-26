package Modelo;

import Auxiliar.Posicao;
import java.util.ArrayList;

public class SetaBaixo extends Seta {

    public SetaBaixo(int linha, int coluna) {
        super(linha, coluna,"baixo");
        this.orientation = 0;
        this.floor = "seta-abaixo.png";
    }

    @Override
    public void movimentoSeta(Hero h) {
        boolean f;
        if(this.isWaitedframe()){
            h.moveDown();
            h.setOrientation(0);
            f = false; 
        }else{
            f = true;
        }
         this.setWaitedframe(f);
       
    }
    
    
}