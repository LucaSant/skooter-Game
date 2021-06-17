package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Controler.Tela;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.util.Random;
import javax.swing.ImageIcon;

/**
 *
 * @author Junio
 */
public abstract class Elemento implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean bItem;         /*É um item?*/
    protected boolean bVilao;         /*É um vilão?*/
    
    Random rand = new Random(); //Para uso dos vilões
    private int mv;
       
    protected Elemento(String sNomeImagePNG) {
        this.pPosicao = new Posicao(1, 1);
        this.bTransponivel = true;
        this.bMortal = false;
        //this.bItem = false;
        try {   /*Procurar imagem para usar*/
            iImage = new ImageIcon(new java.io.File(".").getCanonicalPath() + Consts.PATH + sNomeImagePNG);
            Image img = iImage.getImage();
            BufferedImage bi = new BufferedImage(Consts.CELL_SIDE, Consts.CELL_SIDE, BufferedImage.TYPE_INT_ARGB);
            Graphics g = bi.createGraphics();
            g.drawImage(img, 0, 0, Consts.CELL_SIDE, Consts.CELL_SIDE, null);
            iImage = new ImageIcon(bi);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Posicao getPosicao() {
        return pPosicao;
    }

    public boolean isbTransponivel() {
        return bTransponivel;
    }

    public void setbTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public  boolean isItem(){
        return this.bItem;
    }

    public boolean isbMortal() {
        return bMortal;
    }

    public boolean moveUp() {
        return this.pPosicao.moveUp();
    }

    public boolean moveDown() {
        return this.pPosicao.moveDown();
    }

    public boolean moveRight() {
        return this.pPosicao.moveRight();
    }

    public boolean moveLeft() {
        return this.pPosicao.moveLeft();
    }
    
   public void autoDesenho(){
        Desenhador.desenhar(this.iImage, pPosicao.getColuna(), pPosicao.getLinha());        
    }
   
   //Para que o vilão possa se mover aleatoriamente
   public void direcao() {
        mv = rand.nextInt(4);
        switch(mv) {
            case 0:
                if(this.getPosicao().getLinha() == 10) {
                    direcao();
                }
                else {
                    this.moveDown();
                }
                break;
            case 1:
                if(this.getPosicao().getLinha() == 0) {
                    direcao();
                }
                else {
                    this.moveUp();
                }
                break;
            case 2:
                if(this.getPosicao().getColuna() == 10) {
                    direcao();
                }
                else {
                    this.moveRight();
                }
                break;
            case 3:
                if(this.getPosicao().getColuna() == 0) {
                    direcao();
                }
                else {
                    this.moveLeft();
                }
                break;
        }
    }
}
