package Controler;

import Modelo.*;
import Auxiliar.Posicao;
import java.util.ArrayList;
import Fases.*;

public class ControleDeJogo {

    private boolean killedHero;
    private ArrayList<Fase> Allfases;
    private Fase fase;

    public ControleDeJogo(){
        this.killedHero = false;
        setAllfases(new ArrayList<Fase>(4));

        Allfases.add(new FaseOne());
        Allfases.add(new FaseTwo());
        Allfases.add(new FaseThree());
        Allfases.add(new FaseFour());
        fase = getAllfases().get(0);
        //this.getAllfases().get(0).setAllElementos(, umElemento);
    }


    public void desenhaTudo(ArrayList<Elemento> e){
        for(int i = 0; i < e.size(); i++){
            e.get(i).autoDesenho();
        }
    }
    public void processaTudo(ArrayList<Elemento> e){
        Hero hHero = (Hero)e.get(0); /*O heroi (protagonista) eh sempre o primeiro do array*/
        Elemento eTemp;
        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())){
                /*Nem todos os elementos podem ser transpostos pelo heroi*/
                if(eTemp.isbMortal()){
                    hHero.setLives(hHero.getLives() - 1);
                    this.killedHero = true;
                }else{
                    this.killedHero = false;
                }
                if(eTemp.isbTransponivel())
                    e.remove(eTemp);
                if(eTemp.isItem() == true){
                    hHero.setCollectedItens(hHero.getCollectedItens() + 1);
                    System.out.println("Você coletou um item! Total coletado: " + hHero.getCollectedItens());
                    e.remove(eTemp);
                   /* if(this.getFase().getnItens() == hHero.getCollectedItens()){
                        this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0                   //então não é preciso colocar + 1               
                        this.getFase().setAllElementos(e, hHero);
                    } */
                }
            }
        }
    }
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(!eTemp.isbTransponivel())
                if(eTemp.getPosicao().estaNaMesmaPosicao(p))
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
        }
        return true;
    }
    
    public boolean ehPosicaoValidaVilao(ArrayList<Elemento> e, int vilao) {
        Elemento vilaoTemp;
        vilaoTemp = e.get(vilao);
        
        for(int i = 5; i < e.size(); i++) {
            if(e.get(i).getPosicao().getLinha() == vilaoTemp.getPosicao().getLinha() && e.get(i).getPosicao().getColuna() == vilaoTemp.getPosicao().getColuna()) {
                return false;
            }
        }
        return true;
    }
    
    public void movimentoSeta(ArrayList<Elemento> e, Posicao p, Hero h) {
        Elemento eTemp;
        for(int i = 5; i < e.size(); i++) {
            eTemp = e.get(i);
            if(eTemp.getPosicao().getColuna() == p.getColuna() && eTemp.getPosicao().getLinha() == p.getLinha()) {
                //System.out.println(eTemp.getClass().getCanonicalName()); //Debug
                switch(eTemp.getClass().getCanonicalName()) {
                    case "Modelo.SetaAbaixo":
                        h.moveDown();
                        movimentoSeta(e, p, h);
                        break;
                    case "Modelo.SetaAcima":
                        h.moveUp();
                        movimentoSeta(e, p, h);
                        break;
                    case "Modelo.SetaDireita":
                        h.moveRight();
                        movimentoSeta(e, p, h);
                        break;
                    case "Modelo.SetaEsquerda":
                        h.moveLeft();
                        movimentoSeta(e, p, h);
                        break;
                }
            }
        }
    }

    public void checkLives(ArrayList<Elemento> e){
        
        if(this.isKilledHero() == true){
            Hero hHero = (Hero)e.get(0);
            System.out.println("Herói perdeu uma vida! Restam agora " + hHero.getLives());
            if(hHero.getLives() == 0){
                System.out.println("Última vida perdida! Jogo reiniciando...");
                this.setFase(0);
                hHero.setLives(3);
            }
            hHero.setCollectedItens(0);
            this.getFase().setAllElementos(e, hHero);
            setKilledHero(false);
        }    
    }

    public void nextFase(ArrayList<Elemento> elem, Fase fFase){
        Hero hHero = (Hero)elem.get(0);
        if(hHero.getCollectedItens() == fFase.getnItens()){
            if(this.getFase().getnFase() == 4) {
            //Fim de jogo e agradecimentos
            }
            
            this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0     
            hHero.setCollectedItens(0);              //então não é preciso colocar + 1               
            this.getFase().setAllElementos(elem, hHero);
        }                                      //na fase 1 (posição 0), o setFase(getFase().getnFase()) é igual setFase(1)
    }                                      

    public boolean isKilledHero() {
        return killedHero;
    }

    public void setKilledHero(boolean killedHero) {
        this.killedHero = killedHero;
    }

    
    public ArrayList<Fase> getAllfases() {
        return Allfases;
    }

    public void setAllfases(ArrayList<Fase> allfases) {
        this.Allfases = allfases;
    }

    public Fase getFase() {
        return fase;
    }

    public void setFase(int n) {
        this.fase = this.getAllfases().get(n);
    }

    
}
