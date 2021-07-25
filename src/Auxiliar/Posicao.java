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

    public void setPosicao(Posicao p)
    {
        this.linha = p.getLinha();
        this.coluna = p.getColuna();
    }

    public Posicao getPosicao(){
        return this;
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

    public Posicao copia(){
        return (new Posicao(this.getLinha(), this.getColuna()));
    }
    
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
}
