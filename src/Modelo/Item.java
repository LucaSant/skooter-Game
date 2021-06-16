package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class Item extends Elemento implements Serializable {

    public Item(int linha, int coluna) {
        super("fruta.png");
        this.setPosicao(linha, coluna);
    }

    public void autoDesenho() {
        super.autoDesenho();
    }
}