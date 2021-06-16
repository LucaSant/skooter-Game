package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;
import java.util.Random;

public class Vilao extends Elemento implements Serializable {
    
    Random rand = new Random();
    int mv;
    
    public Vilao(int linha, int coluna) {
        super("vilao.png");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
        
        mv = rand.nextInt(4);
        switch(mv) {
            case 0:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()+1);
                break;
            case 1:
                this.setPosicao(pPosicao.getLinha()+1, pPosicao.getColuna());
                break;
            case 2:
                this.setPosicao(pPosicao.getLinha(), pPosicao.getColuna()-1);
                break;
            case 3:
                this.setPosicao(pPosicao.getLinha()-1, pPosicao.getColuna());
                break;
        }
    }
    
}
