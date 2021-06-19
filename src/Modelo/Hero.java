package Modelo;

import Auxiliar.*;

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
public class Hero extends Elemento implements Cloneable{

    private int collectedItens;
    private int lives;
    private int orientacion; //0 - down, 1 - up, 2 - left, 3 - right

    public Hero(int linha, int coluna) {
        super("heroi.png");
        this.setPosicao(linha, coluna);
        this.lives = 3;
        this.collectedItens = 0;
        this.orientacion = 0; //começa na posição down
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
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }


}