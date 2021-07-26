package Controler;

import Auxiliar.Save;
import java.util.ArrayList;

import Modelo.Elemento;
import Modelo.Hero;

public class Fase {

    protected int nFase;
    protected int nItens;
    protected int nViloes;
    protected String background;

    public Fase(int fase, String background){
        this.setnFase(fase);
        this.setnItens(0);
        this.setnViloes(0);
        this.setBackground(background);
    }

    public int numberOfItens(ArrayList<Elemento> elem){
        int n = 0;
        for(int i = 0; i < elem.size(); i++){
            if(elem.get(i).getLabel().contains("item")){
                n++;
            }
        }
        return n;
    }

    public int numberOfVillans(ArrayList<Elemento> elem){
        int n = 0;
        for(int i = 0; i < elem.size(); i++){
            if(elem.get(i).getLabel().contains("vilao")){
                n++;
            }
        }
        return n;
    }

    public void setAllElementos(ArrayList<Elemento> e, Hero hero){
     
    }
    
    
    public void setAllElementos(ArrayList<Elemento> elem, Hero hHero, Save s){
         elem.clear();
            ArrayList<Elemento> elemSave = s.readSave();
            Hero h = (Hero) s.readSave().get(0);
            hHero.setFase(h.getFase());
            this.setAllElementos(elem,hHero);
            elem.clear();
            hHero.setOrientation(h.getOrientation());
            hHero.setPontos(h.getPontos());
            hHero.setLives(h.getLives());
            hHero.setPosicao(h.getPosicao());
            
            elem.add(hHero);
            for(int i = 1; i < elemSave.size(); i++){
                elem.add(elemSave.get(i));
            }
    }
   

    public int getnFase() {
        return nFase;
    }

    private void setnFase(int nFase) {
        this.nFase = nFase;
    }

    public int getnItens() {
        return nItens;
    }

    public void setnItens(int nItens) {
        this.nItens = nItens;
    }
    
    public int getnViloes() {
        return nViloes;
    }

    public void setnViloes(int nViloes) {
        this.nViloes = nViloes;
    }

    public String getBackground() {
        return background;
    }

    private void setBackground(String background) {
        this.background = background;
    }
}
