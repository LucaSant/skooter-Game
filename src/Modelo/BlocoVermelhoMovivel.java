package Modelo;

import java.io.Serializable;
import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class BlocoVermelhoMovivel extends Elemento implements Serializable{
    
    public BlocoVermelhoMovivel(int linha, int coluna) {
        super("blocovermelholosango.png");
        this.setPosicao(linha, coluna);
        this.bTransponivel = false;
        this.bEmpurravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}