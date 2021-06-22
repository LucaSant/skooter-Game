package Controler;

import Modelo.*;
import Auxiliar.Consts;
import Auxiliar.Posicao;
import java.util.ArrayList;
import java.util.Random;

import Fases.*;

public class ControleDeJogo {

    private boolean killedHero;
    private boolean naturalHeroMove;
    private int iContagemVilao;
    private int iContagemPressedKey;
    private ArrayList<Fase> Allfases;
    private Fase fase;
    private int lastFase;
    
   

    public ControleDeJogo(){
        this.killedHero = false;
        this.naturalHeroMove = true;

        setAllfases(new ArrayList<Fase>(4));

        Allfases.add(new FaseOne());
        Allfases.add(new FaseTwo());
        Allfases.add(new FaseThree());
        Allfases.add(new FaseFour());
        Allfases.add(new TelaInicial());
        
        fase = getAllfases().get(Allfases.size() - 1);
        lastFase = getAllfases().get(Allfases.size() -2).getnFase();
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
                    System.out.println("Item de numero " + hHero.getCollectedItens());
                    System.out.println("Ele valia " + ((Item) eTemp).getPontosEquiv() + ", entao voce ganhou: " + hHero.getCollectedItens() * ((Item) eTemp).getPontosEquiv() + " pontos.");
                    hHero.setPontos(hHero.getPontos() + (hHero.getCollectedItens() * ((Item) eTemp).getPontosEquiv()));
                    e.remove(eTemp);
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

    public void beginGame(ArrayList<Elemento> elem, Hero hHero){
        this.setFase(0);
        this.getFase().setAllElementos(elem, hHero);
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


    public void vilaoMoveHabilitation(ArrayList<Elemento> elem){
        iContagemVilao++;
            if(iContagemVilao == Consts.TIMER_VILAO) {
                iContagemVilao = 0;
                for(int i = 0; i < this.getFase().getnViloes(); i++) {
                    Random rand = new Random();
                    int mv = rand.nextInt(4);
                    int count = 0;
                    this.movimentoVilao(elem.get(i+1), mv, count, elem);
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


    public void movimentoVilao(Elemento e, int mv, int countMove, ArrayList<Elemento> elem) {
    /**
    * Método para que o vilão possa se mover aleatoriamente sem colidir ou escapar do mapa.
    * Ele ficou em Tela pois precisávamos conferir o espaço ao redor por obstáculos e 
    * atualizar o desenho de maneira que não ficasse "indo e voltando".
    */    
        if(e.getClass().getCanonicalName() == "Modelo.Vilao") {
            Vilao v = (Vilao) e;
            Posicao ePos = v.getPosicao();
            Posicao pAtual = new Posicao(ePos.getLinha(), ePos.getColuna());

            mv = v.endTest(countMove, mv);      
            
            switch(mv) {
            case 0: //Tentando para baixo
                
                if(ePos.getLinha() == 10) {
                    mv = 1;
                    countMove++;
                    this.movimentoVilao(e, mv, countMove, elem);
                    
                }
                else {
                    v.moveDown();
                    boolean isLastPos = v.checkLastPosicao(countMove, this, elem, ePos);
                    if((!this.ehPosicaoValidaVilao(elem, ePos)) || (isLastPos)) {
                        ePos.volta();
                        mv = 1;
                        countMove++;
                        this.movimentoVilao(e, mv, countMove, elem);
                    }
                }
                v.setLastPosition(pAtual);
                break;
            case 1: //Tentando para cima
                if(ePos.getLinha() == 0) {
                    mv = 2;
                    countMove++;
                    this.movimentoVilao(e, mv, countMove, elem);
                }
                else {
                    v.moveUp();
                    boolean isLastPos = v.checkLastPosicao(countMove, this, elem, ePos);
                    if((!this.ehPosicaoValidaVilao(elem, ePos)) || (isLastPos)) {
                        ePos.volta();
                        mv = 2;
                        countMove++;
                        this.movimentoVilao(e, mv, countMove, elem);
                    }
                }
                v.setLastPosition(pAtual);
                break;
            case 2: //Tentando pra a direita
                if(ePos.getColuna() == 10) {
                    mv = 3;
                    countMove++;
                    this.movimentoVilao(e, mv, countMove, elem);
                }
                else {
                    v.moveRight();
                    boolean isLastPos = v.checkLastPosicao(countMove, this,  elem, ePos);
                    if((!this.ehPosicaoValidaVilao(elem, ePos)) || (isLastPos)) {
                        ePos.volta();
                        mv = 3;
                        countMove++;
                        this.movimentoVilao(e, mv, countMove, elem);
                    }
                }
                v.setLastPosition(pAtual);
                break;
            case 3: //Tentando para a esquerda
                if(ePos.getColuna() == 0) {
                    mv = 0;
                    countMove++;
                    this.movimentoVilao(e, mv, countMove, elem);
                }
                else {
                    v.moveLeft();
                    boolean isLastPos = v.checkLastPosicao(countMove, this,  elem, ePos);
                    if((!this.ehPosicaoValidaVilao(elem, ePos)) || (isLastPos)) {
                        ePos.volta();
                        mv = 0;
                        countMove++;
                        this.movimentoVilao(e, mv, countMove, elem);
                    }
                }
                v.setLastPosition(pAtual);
                break;

            case 4:
                v.setPosicao(ePos.getLinha(), ePos.getColuna());
                if(!this.ehPosicaoValidaVilao(elem, ePos)) {
                    ePos.volta();
                }
                v.setLastPosition(pAtual);
                break;
            }
        } 
    }


    public void movimentoEmpurravel(ArrayList<Elemento> e, Posicao p) {
        Elemento eTemp;
        for(int i = this.getFase().getnViloes()+1; i < e.size(); i++) {
            eTemp = e.get(i);
            if(eTemp.getPosicao().estaNaMesmaPosicao(p) && eTemp.isEmpurravel()) {
                if (p.getLinha() - p.getLinhaAnterior() < 0) {
                    eTemp.moveUp();
                    if(!this.ehPosicaoValidaEmpurravel(e, eTemp)) {
                        if(!eTemp.isTransponivel()) {
                            eTemp.getPosicao().volta();
                        }
                    }
                }
                else if (p.getLinha() - p.getLinhaAnterior() > 0) {
                    eTemp.moveDown();
                    if(!this.ehPosicaoValidaEmpurravel(e, eTemp)) {
                        if(!eTemp.isTransponivel()) {
                            eTemp.getPosicao().volta();
                        }
                    }
                }
                else if (p.getColuna() - p.getColunaAnterior() < 0) {
                        eTemp.moveLeft();
                    if(!this.ehPosicaoValidaEmpurravel(e, eTemp)) {
                        if(!eTemp.isTransponivel()) {
                            eTemp.getPosicao().volta();
                        }
                    }
                }
                else if (p.getColuna() - p.getColunaAnterior() > 0) {
                        eTemp.moveRight();
                    if(!this.ehPosicaoValidaEmpurravel(e, eTemp)) {
                        if(!eTemp.isTransponivel()) {
                            eTemp.getPosicao().volta();
                        }
                    }
                }
            }
        }
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
    

    
    public void checkLives(ArrayList<Elemento> e){
    
        if(this.isKilledHero() == true){
            Hero hHero = (Hero)e.get(0);
            
            System.out.println("Herói perdeu uma vida! Restam agora " + hHero.getLives());
            
            if(hHero.getLives() == 0){
                System.out.println("Última vida perdida! \n - - - Game Over - - - ");
    
                hHero.setCollectedItens(0);
                hHero.setLives(0);
                hHero.setPontos(3);
                hHero.setImage("heroi-0.png");
                this.beginGame(e, hHero);
            }else{
                hHero.setCollectedItens(0);
                this.getFase().setAllElementos(e, hHero);
            }
            setKilledHero(false);
            
        }     
    }


    public void nextFase(ArrayList<Elemento> elem){
        Hero hHero = (Hero)elem.get(0);
        Fase fFase = this.getFase();
        if(hHero.getCollectedItens() == fFase.getnItens()){
            if(this.getFase().getnFase() == this.getLastFase()) {
                //Fim de jogo e agradecimentos
                System.out.println("Você zerou o jogo. Parabens");
                hHero.setCollectedItens(0);
                hHero.setLives(0);
                hHero.setPontos(3);
                hHero.setImage("heroi-0.png");
                this.beginGame(elem, hHero);
            }else{
                System.out.println("Você completou a fase " + this.getFase().getnFase() + "!");
                this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0     
                hHero.setCollectedItens(0);              //então não é preciso colocar + 1               
                this.getFase().setAllElementos(elem, hHero);
            }
        }                                  //na fase 1 (posição 0), o setFase(getFase().getnFase()) é igual setFase(1)
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

    public int getLastFase() {
        return lastFase;
    }

    public void setLastFase(int lastFase) {
        this.lastFase = lastFase;
    }

    
}
