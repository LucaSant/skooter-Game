package Modelo;

import Auxiliar.Desenhador;
import Controler.Tela;
import java.awt.Graphics;
import java.io.Serializable;

public class SetaAcima extends Seta {

    public SetaAcima(int linha, int coluna) {
        super(linha, coluna);
        this.orientacion = 1;
        this.floor = "seta-acima.png";
    }
}