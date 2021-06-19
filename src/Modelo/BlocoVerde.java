package Modelo;

import java.io.Serializable;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class BlocoVerde extends Elemento implements Serializable{
    
    public BlocoVerde(int linha, int coluna) {
        super("blocoverde.png");
        this.setPosicao(linha, coluna);
        this.bQuebravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}