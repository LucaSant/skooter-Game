package Auxiliar;

import java.io.Serializable;

public class Posicao implements Serializable{
    private int	linha;
    private int coluna;
    
    private int linhaAnterior;
    private int colunaAnterior;

    public Posicao(int linha, int coluna){
        this.setPosicao(linha,coluna);
    }

    public boolean setPosicao(int linha, int coluna){       
        if(linha < 0 || linha >= Auxiliar.Consts.RES)
            return false;
        linhaAnterior = this.linha;
        this.linha = linha;
        
        if(coluna < 0 || coluna >= Auxiliar.Consts.RES)
            return false;
        colunaAnterior = this.coluna;
        this.coluna = coluna;
        return true;
    }
   
    public boolean volta(){
        return this.setPosicao(linhaAnterior,colunaAnterior);
    }
    
    public int getLinha(){
        return linha;
    }

    public int getColuna(){
        return coluna;
    }
    
    public int getLinhaAnterior() {
        return linhaAnterior;
    }

    public int getColunaAnterior() {
        return colunaAnterior;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public void setLinhaAnterior(int linhaAnterior) {
        this.linhaAnterior = linhaAnterior;
    }

    public void setColunaAnterior(int colunaAnterior) {
        this.colunaAnterior = colunaAnterior;
    }
    
    public boolean estaNaMesmaPosicao(Posicao posicao){
        return (linha == posicao.getLinha() && coluna == posicao.getColuna());
    }

    public boolean copia(Posicao posicao){
        return this.setPosicao(posicao.getLinha(),posicao.getColuna());
    }
    /*
    public int heroMovementDirection(Hero h) { //0 Norte - 1 Sul - 2 Leste - 3 Oeste
        Posicao p;
        p = h.getPosicao();
        if (p.linha - p.linhaAnterior < 0) return 0;
        else if (p.linha - p.linhaAnterior > 0) return 1;
        else if (p.coluna - p.colunaAnterior < 0) return 2;
        else if (p.coluna - p.colunaAnterior > 0) return 3;
        else return -1;
    }*/
    
    public boolean moveUp(){
        return this.setPosicao(this.getLinha()-1, this.getColuna());
    }
    public boolean moveDown(){
        return this.setPosicao(this.getLinha()+1, this.getColuna());
    }
    public boolean moveRight(){
        return this.setPosicao(this.getLinha(), this.getColuna()+1);
    }
    public boolean moveLeft(){
        return this.setPosicao(this.getLinha(), this.getColuna()-1);        
    }

    @Override
    public Posicao clone() {
        try {
            return (Posicao) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
            return this;
    }

    
}
