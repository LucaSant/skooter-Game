package Modelo;

import Auxiliar.*;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Vilao extends Elemento implements Serializable {
    
    private int iContaFrames;
    
    public Vilao(int linha, int coluna) {
        super("vilao.png");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
        
        this.iContaFrames++;
        /* A cada segundo, anda para algum lado possível */
        if(this.iContaFrames == Consts.TIMER_VILAO){
            this.iContaFrames = 0;
            this.direcao();
        }
    }
    
    public void pegouHeroi(Hero h){
        
    }
}