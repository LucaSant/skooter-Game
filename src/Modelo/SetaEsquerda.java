package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaEsquerda extends Elemento implements Serializable {

    public SetaEsquerda(int linha, int coluna) {
        super("seta-esquerda.png");
        this.setPosicao(linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}