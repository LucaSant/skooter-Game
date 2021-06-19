package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaDireita extends Seta{

    public SetaDireita(int linha, int coluna) {
        super(linha, coluna);
        this.orientacion = 3;
        this.floor = "seta-direita.png";
    }
}