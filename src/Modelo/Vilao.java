package Modelo;

import Auxiliar.*;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Vilao extends Elemento implements Serializable {
    
    public Vilao(int linha, int coluna) {
        super("vilao.png");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}