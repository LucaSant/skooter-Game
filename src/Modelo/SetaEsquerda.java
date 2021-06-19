package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaEsquerda extends Seta{

    public SetaEsquerda(int linha, int coluna) {
        super(linha, coluna);
        this.orientacion = 2;
        this.floor = "seta-esquerda.png";
    }
}