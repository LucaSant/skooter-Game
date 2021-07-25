package Modelo;

import java.util.ArrayList;

import Auxiliar.Posicao;

public class Vilao extends Elemento {
    private Posicao lastposition;

    public Vilao(int linha, int coluna) {
        super("trooper.png", "vilao");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
        this.bTransponivel = true;
        this.lastposition = getPosicao();

    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

    public void setLastPosition(Posicao p){
        this.lastposition = p.copia();
    }

    public Posicao getLastPosition(){
        return lastposition;
    }
    
    
    public int endTest(int count, int mv){
        if(count == 4){
            return 4;
        }
        return mv;
    }
    
    
    public boolean ehPosicaoValidaVilao(ArrayList<Elemento> e, Posicao p, int nviloes) {
        Elemento eTemp;
        int qtdViloes;
        qtdViloes = nviloes + 1;
        for(int i = qtdViloes; i < e.size(); i++) {
            eTemp = e.get(i);
            
            if(eTemp.getPosicao().estaNaMesmaPosicao(p)) {
                return false;
            }
        }
        return true;
    }

    public boolean checkLastPosicao(int count, ArrayList <Elemento> e, Posicao p, int nviloes){
        if(this.getPosicao().estaNaMesmaPosicao(this.lastposition)){
            return true;
        }else{
            return !this.ehPosicaoValidaVilao(e, p, nviloes);  
        }
    }

    
    
    public void movimentoVilao(int mv, int countMove, ArrayList<Elemento> elem, int nviloes) {
    /*
    * Método para que o vilão possa se mover "aleatoriamente" sem colidir ou escapar do mapa.
    */    
        Posicao ePos = this.getPosicao();
        Posicao pAtual = new Posicao(ePos.getLinha(), ePos.getColuna());

        mv = this.endTest(countMove, mv);      
            
        switch(mv) {
            case 0: //Tentando para baixo
                
                if(ePos.getLinha() == 10) {
                    mv = 1;
                    countMove++;
                    this.movimentoVilao(mv, countMove, elem, nviloes);
                    
                }
                else {
                    this.moveDown();
                    boolean isLastPos = this.checkLastPosicao(countMove, elem, ePos, nviloes);
                    if((!this.ehPosicaoValidaVilao(elem, ePos, nviloes)) || (isLastPos)) {
                        ePos.volta();
                        mv = 1;
                        countMove++;
                        this.movimentoVilao( mv, countMove, elem, nviloes);
                    }
                }
                this.setLastPosition(pAtual);
                break;
            case 1: //Tentando para cima
                if(ePos.getLinha() == 0) {
                    mv = 2;
                    countMove++;
                    this.movimentoVilao(mv, countMove, elem, nviloes);
                }
                else {
                    this.moveUp();
                    boolean isLastPos = this.checkLastPosicao(countMove,elem, ePos, nviloes);
                    if((!this.ehPosicaoValidaVilao(elem, ePos, nviloes)) || (isLastPos)) {
                        ePos.volta();
                        mv = 2;
                        countMove++;
                        this.movimentoVilao(mv, countMove, elem, nviloes);
                    }
                }
                this.setLastPosition(pAtual);
                break;
            case 2: //Tentando pra a direita
                if(ePos.getColuna() == 10) {
                    mv = 3;
                    countMove++;
                    this.movimentoVilao(mv, countMove, elem, nviloes);
                }
                else {
                    this.moveRight();
                    boolean isLastPos = this.checkLastPosicao(countMove, elem, ePos, nviloes);
                    if((!this.ehPosicaoValidaVilao(elem, ePos, nviloes)) || (isLastPos)) {
                        ePos.volta();
                        mv = 3;
                        countMove++;
                        this.movimentoVilao(mv, countMove, elem, nviloes);
                    }
                }
                this.setLastPosition(pAtual);
                break;
            case 3: //Tentando para a esquerda
                if(ePos.getColuna() == 0) {
                    mv = 0;
                    countMove++;
                    this.movimentoVilao(mv, countMove, elem, nviloes);
                }
                else {
                    this.moveLeft();
                    boolean isLastPos = this. checkLastPosicao(countMove, elem, ePos, nviloes);
                    if((!this.ehPosicaoValidaVilao(elem, ePos, nviloes)) || (isLastPos)) {
                        ePos.volta();
                        mv = 0;
                        countMove++;
                        this.movimentoVilao(mv, countMove, elem, nviloes);
                    }
                }
                this.setLastPosition(pAtual);
                break;

            case 4:
                this.setPosicao(ePos.getLinha(), ePos.getColuna());
                if(!this.ehPosicaoValidaVilao(elem, ePos, nviloes)) {
                    ePos.volta();
                }
                this.setLastPosition(pAtual);
                break;
            
        } 
    }
}      
    
   
