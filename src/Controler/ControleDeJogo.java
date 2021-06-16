package Controler;

import Modelo.Elemento;
import Modelo.Hero;
import Auxiliar.Posicao;
import java.util.ArrayList;

/**
 *
 * @author junio
 */
public class ControleDeJogo {

    private boolean killedHero;
    private ArrayList<Fase> Allfases;
    private Fase fase;

    public ControleDeJogo(){
        this.killedHero = false;
        setAllfases(new ArrayList<Fase>(4));
        fase = getAllfases().get(0);
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
            if(hHero.getPosicao().estaNaMesmaPosicao(eTemp.getPosicao()))
                /*Nem todos os elementos podem ser transpostos pelo heroi*/
                if(eTemp.isbTransponivel())
                    e.remove(eTemp);
                if(eTemp.isItem()){
                    hHero.setCollectedItens(hHero.getCollectedItens() + 1);
                    e.remove(eTemp);
                }
                if(eTemp.isbMortal()){
                    hHero.setLives(hHero.getLives() - 1);
                    this.killedHero = true;
                }else{
                    this.killedHero = false;
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

    public void checkLives(ArrayList<Elemento> e){
        
        if(this.isKilledHero() == true){
            Hero hHero = (Hero)e.get(0);
            
            if(hHero.getLives() == 0){
                this.setFase(0);
                hHero.setLives(0);
            }
            hHero.setCollectedItens(0);
            this.getFase().setAllElementos(e, hHero);
            setKilledHero(false);
        }    
    }

    public void nextFase(Hero hHero, Fase fFase){
        if(hHero.getCollectedItens() == fFase.getnItens()){
            this.setFase(getFase().getnFase());  //como o número da fase começa em 1 e as posições em 0                   //então não é preciso colocar + 1               
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
