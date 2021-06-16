package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaAcima extends Elemento implements Serializable {

    public SetaAcima(int linha, int coluna) {
        super("seta-acima.png");
        this.setPosicao(linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}