package Modelo;

import Auxiliar.Consts;
import Auxiliar.Desenhador;
import Auxiliar.Posicao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import javax.swing.ImageIcon;

public abstract class Elemento implements Serializable {

    protected ImageIcon iImage;
    protected Posicao pPosicao;
    protected String label ;
    protected String imagepath;
    protected boolean bTransponivel; /*Pode passar por cima?*/
    protected boolean bEmpurravel;   /*Pode empurrar?*/
    protected boolean bMortal;       /*Se encostar, morre?*/
    protected boolean bItem;         /*É um item?*/
    protected boolean bQuebravel;
    protected boolean bSeta;
   
    
    protected Elemento(String sNomeImagePNG, String label) {
        this.pPosicao = new Posicao(1, 1);
        this.imagepath = sNomeImagePNG;
        this.bTransponivel = false;
        this.bMortal = false;
        this.bQuebravel = false;
        this.bSeta = false;
        this.label = label;
        this.setImage(sNomeImagePNG);
        
    }

    
    public void setImage(String sNomeImagePNG){
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
    
    public String getImagepath() {
        return imagepath;
    }

    public void setImagepath(String imagepath) {
        this.imagepath = imagepath;
        this.setImage(imagepath);
    }

    public boolean isTransponivel() {
        return bTransponivel;
    }

    public void setTransponivel(boolean bTransponivel) {
        this.bTransponivel = bTransponivel;
    }

    public boolean setPosicao(int linha, int coluna) {
        return pPosicao.setPosicao(linha, coluna);
    }

    public void setPosicao(Posicao p){
        this.pPosicao = new Posicao(p.getLinha(), p.getColuna());
    }

    public  boolean isItem(){
        return this.bItem;
    }

    public boolean isMortal() {
        return bMortal;
    }

    public boolean isEmpurravel() {
        return bEmpurravel;
    }

    public boolean isbSeta() {
        return bSeta;
    }

    public void setbSeta(boolean bSeta) {
        this.bSeta = bSeta;
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

    public boolean isbQuebravel() {
        return bQuebravel;
    }

    public void setbQuebravel(boolean bQuebravel) {
        this.bQuebravel = bQuebravel;
    }

   public void autoDesenho(){
        Desenhador.desenhar(this.iImage, pPosicao.getColuna(), pPosicao.getLinha());        
    }

    public String getCanonicalName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}
