package Controler;

import Modelo.*;
import Auxiliar.Consts;
import Auxiliar.Posicao;
import Auxiliar.Save;
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
        for(int i = e.size() -1 ; i >= 0; i--){
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
                if(eTemp.getLabel().contains("vilao")){
                    hHero.setLives(hHero.getLives() - 1);
                    this.killedHero = true;
                }else{
                    this.killedHero = false;
                }
                if(eTemp.getLabel().contains("item")){
                    hHero.setCollectedItens(hHero.getCollectedItens() + 1);
                    System.out.println("Item de numero " + hHero.getCollectedItens());
                    System.out.println("Ele valia " + ((Item) eTemp).getPontosEquiv() + ", entao voce ganhou: " + hHero.getCollectedItens() * ((Item) eTemp).getPontosEquiv() + " pontos.");
                    hHero.setPontos(hHero.getPontos() + (hHero.getCollectedItens() * ((Item) eTemp).getPontosEquiv()));
                    e.remove(eTemp);
                }
                if(eTemp.getLabel().contains("seta")){
                    Seta s = (Seta) eTemp;
                    s.movimentoSeta(hHero);
                    if(!this.ehPosicaoValida(e, hHero.getPosicao())){
                      hHero.voltaAUltimaPosicao();
                    }
                    hHero.setCanMove(false);
                    this.setNaturalHeroMove(false);
                }
                if(eTemp.getLabel().contains("portal")){
                    Portal p = (Portal) eTemp;
                    p.movimentoPortal(hHero);
                }
            }
        }
        this.atualizaPortal(e);
        this.vilaoMoveHabilitation(e);
        this.bombaExplodir(e);
    }

    public void beginGame(ArrayList<Elemento> elem, Hero hHero, Save s){
       
        if(!s.saveExists()){
            this.setFase(0);
            this.getFase().setAllElementos(elem, hHero);
        }else{
            this.setFase((int) ((Hero)s.readSave().get(0)).getFase());
            this.getFase().setAllElementos(elem, hHero, s);
        }
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
                int nViloes = this.getFase().getnViloes();
                for(int i = 0; i < nViloes; i++) {
                    Elemento e = elem.get(i+1);
                        Random rand = new Random();
                        int mv = rand.nextInt(4);
                        int count = 0;
                    if(e.getLabel().contains("vilao")) {
                        
                        Vilao v = (Vilao)e;
                        v.movimentoVilao(mv, count, elem, nViloes);
                    }
                }
        }
    }
   
    public boolean ehPosicaoValida(ArrayList<Elemento> e, Posicao p){
        Elemento eTemp;
        /*Validacao da posicao de todos os elementos com relacao a Posicao p*/
        for(int i = 1; i < e.size(); i++){ /*Olha todos os elementos*/
            eTemp = e.get(i); /*Pega o i-esimo elemento do jogo*/
            if(eTemp.getLabel().contains("seta")){
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
    
    public void movimentoEmpurravel(ArrayList<Elemento> e, Posicao p) {
        Elemento eTemp;
        for(int i = this.getFase().getnViloes()+1; i < e.size(); i++) {
            eTemp = e.get(i);
            if(eTemp.getPosicao().estaNaMesmaPosicao(p) && eTemp.getLabel().contains("movel")) {
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
    
    public void checkLives(ArrayList<Elemento> e, Save s){
    
        if(this.isKilledHero() == true){
            Hero hHero = (Hero)e.get(0);
            
            System.out.println("Herói perdeu uma vida! Restam agora " + hHero.getLives());
            
            if(hHero.getLives() == 0){
                System.out.println("Última vida perdida! \n - - - Game Over - - - ");
                hHero.setCollectedItens(0);
                hHero.setLives(3);
                hHero.setPontos(0);
                hHero.setFase(0);
                hHero.setImage("heroi-0.png");
                s.deleteSave();
                this.beginGame(e, hHero, s);
            }else{
                hHero.setCollectedItens(0);
                this.getFase().setAllElementos(e, hHero);
            }
            setKilledHero(false);
        }     
    }

    public void nextFase(ArrayList<Elemento> elem, Save s){
        Hero hHero = (Hero)elem.get(0);
        Fase fFase = this.getFase();
        if(hHero.getCollectedItens() == fFase.getnItens()){
            if(this.getFase().getnFase() == this.getLastFase()) {
                //Fim de jogo e agradecimentos
                System.out.println("Você zerou o jogo. Parabens");
                hHero.setCollectedItens(0);
                hHero.setLives(3);
                hHero.setPontos(0);
                hHero.setImage("heroi-0.png");
                hHero.setFase(0);
                this.beginGame(elem, hHero, s);
            }else{
                System.out.println("Você completou a fase " + this.getFase().getnFase() + "!");
                this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0
                hHero.setFase(this.getFase().getnFase()-1);
                hHero.setCollectedItens(0);              //então não é preciso colocar + 1               
                this.getFase().setAllElementos(elem, hHero);
            }
        }                                  //na fase 1 (posição 0), o setFase(getFase().getnFase()) é igual setFase(1)
    }
    
    public void bombaExplodir(ArrayList<Elemento> elem) {
        for (int i = 1; i < elem.size(); i++) {
            if (elem.get(i).getLabel().contains("bomba")) {
                Bomba b = (Bomba) elem.get(i);
                if (b.pavio()) {
                    for (int j = 0; j < elem.size(); j++) {
                        if ((elem.get(j).getPosicao().getLinha() == b.getPosicao().getLinha()+1)
                                || (elem.get(j).getPosicao().getLinha() == b.getPosicao().getLinha()-1)) {
                            if (elem.get(j).getPosicao().getColuna() == b.getPosicao().getColuna()) {
                                if (elem.get(j).getLabel().contains("bloco"))
                                    elem.remove(j);
                            }
                        }
                        else if ((elem.get(j).getPosicao().getColuna() == b.getPosicao().getColuna()+1)
                                || (elem.get(j).getPosicao().getColuna() == b.getPosicao().getColuna()-1)) {
                            if (elem.get(j).getPosicao().getLinha() == b.getPosicao().getLinha()) {
                                if (elem.get(j).getLabel().contains("bloco"))
                                    elem.remove(j);
                            }
                        }
                    }
                    elem.remove(i);
                }
            }
        }
    }
    
    public void atualizaPortal(ArrayList<Elemento> e){
        for(int i = 5; i < e.size();i++){
            if((e.get(i).getLabel().contains("portal")) && !(e.get(i).getLabel().contains("pareado"))){
                ((Portal)e.get(i)).match(e);
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

    public int getLastFase() {
        return lastFase;
    }

    public void setLastFase(int lastFase) {
        this.lastFase = lastFase;
    }
}