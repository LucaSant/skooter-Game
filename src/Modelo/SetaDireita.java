package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaDireita extends Elemento implements Serializable {

    public SetaDireita(int linha, int coluna) {
        super("seta-direita.png");
        this.setPosicao(linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}