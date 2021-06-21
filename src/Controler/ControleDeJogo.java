package Controler;

import Modelo.*;
import Auxiliar.Consts;
import Auxiliar.Posicao;
import java.util.ArrayList;
import Fases.*;

public class ControleDeJogo {

    private boolean killedHero;
    private boolean naturalHeroMove;
    private int iContagemPressedKey;
    private ArrayList<Fase> Allfases;
    private Fase fase;
    
    public ControleDeJogo(){
        this.killedHero = false;
        this.naturalHeroMove = true;
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
        this.setNaturalHeroMove(true);
        /*Processa todos os demais em relacao ao heroi*/
        for(int i = 1; i < e.size(); i++){
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            /*Verifica se o heroi se sobrepoe ao i-ésimo elemento*/
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao())){
                /*Nem todos os elementos podem ser transpostos pelo heroi*/
                if(eTemp.isMortal()){
                    hHero.setLives(hHero.getLives() - 1);
                    this.killedHero = true;
                }else{
                    this.killedHero = false;
                }
                if(eTemp.isTransponivel())
                    //e.remove(eTemp);
                if(eTemp.isItem() == true){
                    hHero.setCollectedItens(hHero.getCollectedItens() + 1);
                    System.out.println("Você coletou um item! Total coletado: " + hHero.getCollectedItens());
                    e.remove(eTemp);
                   /* if(this.getFase().getnItens() == hHero.getCollectedItens()){
                        this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0                   //então não é preciso colocar + 1               
                        this.getFase().setAllElementos(e, hHero);
                    } */
                }
                if(eTemp.isbSeta()){
                    Seta seta = (Seta) eTemp;
                    seta.movimentoSeta(e, hHero.getPosicao(), seta);
                    hHero.setCanMove(false);
                    this.setNaturalHeroMove(false);
                }
            }
        }
    }
    
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp.isbSeta()){
                return true;
            }
            if(!eTemp.isTransponivel()){
                if(eTemp.getPosicao().estaNaMesmaPosicao(p)){
                    return false; /*A posicao p é invalida, pois ha um elemento (i-esimo eTemp) intransponivel lá*/
                }
            }       
        }
        return true;
    }
    
    public boolean ehPosicaoValidaVilao(ArrayList<Elemento> e, Posicao p) {
        Elemento eTemp;
        int qtdViloes;
        qtdViloes = getFase().getnViloes() + 1;
        for(int i = qtdViloes; i < e.size(); i++) {
            eTemp = e.get(i);
            
            if(eTemp.getPosicao().estaNaMesmaPosicao(p)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean ehPosicaoValidaEmpurravel(ArrayList<Elemento> e, Elemento b) {
        Elemento eTemp;
        int mesmoElemento;
        mesmoElemento = e.indexOf(b);
        for(int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            if(eTemp.getPosicao().estaNaMesmaPosicao(b.getPosicao()) && i != mesmoElemento) {
                return false;
            }
        }
        return true;
    }
    
    

    public void heroMoveHabilitation(Hero hHero){
        if((hHero.canMove() == false) && (this.isNaturalHeroMove())){
            iContagemPressedKey++;
            if(iContagemPressedKey == Consts.KEYPRESS_INTERVAL){
                hHero.setCanMove(true);
                iContagemPressedKey = 0;
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
            System.out.println("Você completou a fase " + this.getFase().getnFase() + "!");
            this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0     
            hHero.setCollectedItens(0);              //então não é preciso colocar + 1               
            this.getFase().setAllElementos(elem, hHero);
        }                                      //na fase 1 (posição 0), o setFase(getFase().getnFase()) é igual setFase(1)
    }   
    
    
    public void quebrarBloco(Hero h, ArrayList<Elemento> elem){

        Posicao p =  new Posicao(h.getPosicao().getLinha(), h.getPosicao().getColuna());
        
        
        switch(h.getOrientacion()){
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
            if((elem.get(i).isbQuebravel()) && (elem.get(i).getPosicao().estaNaMesmaPosicao(p))){
                elem.remove(elem.get(i));
            }
        }
        
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

    public boolean isNaturalHeroMove() {
        return naturalHeroMove;
    }

    public void setNaturalHeroMove(boolean naturalHeroMove) {
        this.naturalHeroMove = naturalHeroMove;
    }

    
}
