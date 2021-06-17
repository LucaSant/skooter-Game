package Controler;

import java.util.ArrayList;

import Modelo.Elemento;
import Modelo.Hero;

public class Fase {

    private int nFase;
    private int nItens;
    private int nViloes;
    private String background;

    public Fase(int fase, String background){
        this.setnFase(fase);
        this.setnItens(0);
        this.setnViloes(0);
        this.setBackground(background);
    }


    public void addElement(ArrayList <Elemento> elem, Elemento umElemento){
        elem.add(umElemento);
        if(umElemento.isbMortal() == true){
            this.setnItens(this.getnViloes() + 1);
        }

    }

    public int numberOfItens(ArrayList<Elemento> elem){
        int n = 0;
        for(int i = 0; i < elem.size(); i++){
            if(elem.get(i).isItem()){
                n++;
            }
        }
        return n;
    }

    public void setAllElementos(ArrayList<Elemento> e, Hero hero){
     
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
