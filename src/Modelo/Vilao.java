package Modelo;

import java.util.ArrayList;

import Auxiliar.Posicao;
import Controler.ControleDeJogo;

public class Vilao extends Elemento {
    private Posicao lastposition;

    public Vilao(int linha, int coluna) {
        super("vilao.png");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
        this.bTransponivel = true;
        this.lastposition = getPosicao();

    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }

    public void setLastPosition(Posicao p){
        this.lastposition = p.copia();
    }

    public Posicao getLastPosition(){
        return lastposition;
    }

    public boolean checkLastPosicao(int count, ControleDeJogo c, ArrayList <Elemento> e, Posicao p){
        if(this.getPosicao().estaNaMesmaPosicao(this.lastposition)){
            return true;
        }else{
            if(c.ehPosicaoValidaVilao(e, p)){
                return false;
            }else{
                return true;
            }  
        }
    }

    public int endTest(int count, int mv){
        if(count == 4){
            return 4;
        }
        return mv;
    }
   
}