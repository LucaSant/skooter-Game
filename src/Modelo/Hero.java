package Modelo;

import java.io.IOException;

import javax.swing.ImageIcon;

import Auxiliar.Consts;

/*import Auxiliar.*;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;
/**
 *
 * @author Junio
 */
public class Hero extends Elemento {

    private int collectedItens;
    private int lives;
    private int orientation; //0 - down, 1 - up, 2 - left, 3 - right
    private boolean canMove;

    public Hero(int linha, int coluna) {
        super("heroi-0.png");
        this.setPosicao(linha, coluna);
        this.lives = 3;
        this.collectedItens = 0;
        this.orientation = 0; //começa na posição down
        this.canMove = true;
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

    public int getOrientacion() {
        
        return orientation;

    }

    public void setOrientacion(int orientation) {
        String img = "heroi-" + orientation + ".png";
        try {
            this.iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + img);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.orientation = orientation;
    }

    public boolean canMove(){
        return this.canMove; 
    }

    public void setCanMove(boolean b){
        this.canMove = b;
    }


}