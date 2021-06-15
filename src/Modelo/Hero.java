package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Junio
 */
public class Hero extends Elemento implements Serializable{

    private int collectedItens;
    private int lives;

   

    public Hero(String sNomeImagePNG) {
        super(sNomeImagePNG);
        this.lives = 3;
        this.collectedItens = 0;
    }

    public void voltaAUltimaPosicao(){
        this.pPosicao.volta();
    }


    public int getCollectedItens() {
        return collectedItens;
    }

    public void setCollectedItens(int collectedItens) {
        this.collectedItens = collectedItens;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }
}
