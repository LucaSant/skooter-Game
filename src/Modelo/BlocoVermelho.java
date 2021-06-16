package Modelo;

import java.io.Serializable;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class BlocoVermelho extends Elemento implements Serializable{
    
    public BlocoVermelho(int linha, int coluna) {
        super("blocovermelho.png");
        this.setPosicao(linha, coluna);
        this.bTransponivel = false;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}
