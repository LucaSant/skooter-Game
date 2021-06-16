package Modelo;

import java.io.Serializable;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class BlocoVerdeMovivel extends Elemento implements Serializable{
    
    public BlocoVerdeMovivel(int linha, int coluna) {
        super("blocoverdelosango.png");
        this.setPosicao(linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}