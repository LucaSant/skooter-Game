package Modelo;

import Auxiliar.Consts;
import java.util.ArrayList;

public class Bomba extends Elemento {
    
    int fusivel;
    
    public Bomba(int linha, int coluna) {
        super("bomba.png");
        this.setPosicao(linha, coluna);
        this.setLabel("bomba");
        this.fusivel = 0;
    }
    
    public boolean pavio() {
        if (this.fusivel < Consts.TIMER_BOMBA) {
            this.fusivel++;
            return false;
        }
        else return true;
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
