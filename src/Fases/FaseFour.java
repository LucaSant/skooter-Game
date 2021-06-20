package Fases;

import java.util.ArrayList;
import Controler.Fase;
import Modelo.*;

public class FaseFour extends Fase {
    
    public FaseFour(){
        super(4, "fundo4.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 4
        e.clear();
        this.setnViloes(0);
        e.add(hero);
        hero.setPosicao(4, 5);
        
        this.addElement(e, new Vilao(0, 5));
        this.addElement(e, new Vilao(5, 0));
        this.addElement(e, new Vilao(5, 10));
        this.addElement(e, new Vilao(10, 5));
        
        this.addElement(e, new Item(0, 0));
        this.addElement(e, new Item(0, 10));
        this.addElement(e, new Item(10, 0));
        this.addElement(e, new Item(10, 10));
        
        this.addElement(e, new BlocoVermelho(0, 3));
        this.addElement(e, new BlocoVermelho(0, 7));
        
        this.addElement(e, new BlocoVermelho(1, 0));
        this.addElement(e, new BlocoVermelho(1, 8));
        
        this.addElement(e, new BlocoVermelho(2, 5));
        
        this.addElement(e, new BlocoVermelho(3, 2));
        this.addElement(e, new BlocoVermelho(3, 10));
        
        this.addElement(e, new BlocoVermelho(5, 2));
        this.addElement(e, new BlocoVermelho(5, 8));
        
        this.addElement(e, new BlocoVermelho(6, 3));
        
        this.addElement(e, new BlocoVermelho(7, 0));
        
        this.addElement(e, new BlocoVermelho(8, 1));
        this.addElement(e, new BlocoVermelho(8, 7));
        this.addElement(e, new BlocoVermelho(8, 10));
        
        this.addElement(e, new BlocoVermelho(10, 1));
        
        this.addElement(e, new BlocoVerde(1, 1));
        this.addElement(e, new BlocoVerde(1, 3));
        this.addElement(e, new BlocoVerde(1, 5));
        this.addElement(e, new BlocoVerde(1, 7));
        this.addElement(e, new BlocoVerde(1, 9));
        
        this.addElement(e, new BlocoVerde(2, 2));
        this.addElement(e, new BlocoVerde(2, 4));
        this.addElement(e, new BlocoVerde(2, 6));
        this.addElement(e, new BlocoVerde(2, 8));
        
        this.addElement(e, new BlocoVerde(3, 1));
        this.addElement(e, new BlocoVerde(3, 3));
        this.addElement(e, new BlocoVerde(3, 5));
        this.addElement(e, new BlocoVerde(3, 7));
        this.addElement(e, new BlocoVerde(3, 9));
        
        this.addElement(e, new BlocoVerde(4, 2));
        this.addElement(e, new BlocoVerde(4, 4));
        this.addElement(e, new BlocoVerde(4, 6));
        this.addElement(e, new BlocoVerde(4, 8));
        
        this.addElement(e, new BlocoVerde(5, 1));
        this.addElement(e, new BlocoVerde(5, 3));
        this.addElement(e, new BlocoVerde(5, 5));
        this.addElement(e, new BlocoVerde(5, 7));
        this.addElement(e, new BlocoVerde(5, 9));
        
        this.addElement(e, new BlocoVerde(6, 2));
        this.addElement(e, new BlocoVerde(6, 4));
        this.addElement(e, new BlocoVerde(6, 6));
        this.addElement(e, new BlocoVerde(6, 8));
        
        this.addElement(e, new BlocoVerde(7, 1));
        this.addElement(e, new BlocoVerde(7, 3));
        this.addElement(e, new BlocoVerde(7, 5));
        this.addElement(e, new BlocoVerde(7, 7));
        this.addElement(e, new BlocoVerde(7, 9));
        
        this.addElement(e, new BlocoVerde(8, 2));
        this.addElement(e, new BlocoVerde(8, 4));
        this.addElement(e, new BlocoVerde(8, 6));
        this.addElement(e, new BlocoVerde(8, 8));
        
        this.addElement(e, new BlocoVerde(9, 1));
        this.addElement(e, new BlocoVerde(9, 3));
        this.addElement(e, new BlocoVerde(9, 5));
        this.addElement(e, new BlocoVerde(9, 7));
        this.addElement(e, new BlocoVerde(9, 9));
        
        this.setnItens(this.numberOfItens(e));
    }

    
}