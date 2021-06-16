package Controler;

import java.util.ArrayList;

import Modelo.Elemento;

public class Fase {

    private int nFase;
    private ArrayList<Elemento> elem;
    private int nItens;
    private String background;

    public Fase(int fase, String backgroung){
        this.setnFase(fase);
        this.elem = new ArrayList<Elemento>(121);
        this.setnItens(0);
        this.setBackground(background);
    }


    public void addElement(Elemento umElemento){
        elem.add(umElemento);
        if(umElemento.isItem()){
            this.setnItens(this.getnItens() + 1);
        }
    }

    public void setAllElementos(Elemento eElemento){
        
    }

    public int getnFase() {
        return nFase;
    }

    private void setnFase(int nFase) {
        this.nFase = nFase;
    }

    public ArrayList<Elemento> getElem() {
        return elem;
    }

    public void setElem(ArrayList<Elemento> elem) {
        this.elem = elem;
    }

    public int getnItens() {
        return nItens;
    }

    public void setnItens(int nItens) {
        this.nItens = nItens;
    }

    public String getBackground() {
        return background;
    }

    private void setBackground(String background) {
        this.background = background;
    }



}
