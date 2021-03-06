package Modelo;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import Auxiliar.Consts;
import Auxiliar.Posicao;

public class Hero extends Elemento {
    
    private static Hero hero = null;
    
    public static Hero getHero() {
        if (hero == null)
            hero = new Hero(0,0);
        return hero;
    }
    
    private int collectedItens;
    private int lives;
    private int fase;
    private int orientation; //0 - down, 1 - up, 2 - left, 3 - right
    private boolean canMove;
    private int pontos;

    private Hero(int linha, int coluna) {
        super("heroi-0.png");
        this.setPosicao(linha, coluna);
        this.setLabel("heroi");
        this.lives = 3;
        this.collectedItens = 0;
        this.orientation = 0; //começa na posição down
        this.canMove = true;
        this.pontos = 0;
    }

    public void quebrarBloco(ArrayList<Elemento> elem){
        
        Posicao p =  new Posicao(this.getPosicao().getLinha(), this.getPosicao().getColuna());
        
        switch(this.getOrientation()){
            case 0: //ultimo movimento foi pra baixo
                p.setLinha(p.getLinha() + 1);
                break;
            case 1: //ultimo movimento foi para cima
                p.setLinha(p.getLinha() - 1);
                break;
            case 2: //ultimo movimento foi para esquerda
                p.setColuna(p.getColuna() - 1);
                break;
            case 3: //ultimo movimento foi para direita
                p.setColuna(p.getColuna() + 1);
                break;
            default:
                System.out.println("Erro inesperado");
                break;
        }
        
        for(int i = 1; i < elem.size(); i++){
            if((elem.get(i).getLabel().contains("verde")) && (elem.get(i).getPosicao().estaNaMesmaPosicao(p))){
                this.setPontos(this.getPontos() + 10);
                elem.remove(elem.get(i));
            }
        }
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

    public int getOrientation() {
        
        return orientation;
    }

    public void setOrientation(int orientation) {
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

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }
}