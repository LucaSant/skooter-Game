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
                if(this.getPosicao().getLinha() == 10) {
                    this.autoDesenho();
                }
                else {
                    this.moveDown();
                }
                break;
            case 1:
                if(this.getPosicao().getLinha() == 0) {
                    this.autoDesenho();
                }
                else {
                    this.moveUp();
                }
                break;
            case 2:
                if(this.getPosicao().getColuna() == 10) {
                    this.autoDesenho();
                }
                else {
                    this.moveRight();
                }
                break;
            case 3:
                if(this.getPosicao().getColuna() == 0) {
                    this.autoDesenho();
                }
                else {
                    this.moveLeft();
                }
                break;
        }
    }
    
}
