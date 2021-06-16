package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaAbaixo extends Elemento implements Serializable {

    public SetaAbaixo(int linha, int coluna) {
        super("seta-abaixo.png");
        this.setPosicao(linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}