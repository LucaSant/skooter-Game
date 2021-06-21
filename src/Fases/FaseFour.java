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
        e.add(hero);
        hero.setPosicao(4, 5);
        
         e.add( new Vilao(0, 5));
         e.add( new Vilao(5, 0));
         e.add( new Vilao(5, 10));
         e.add( new Vilao(10, 5));
        
         e.add( new Item(0, 0, 6));
         e.add( new Item(0, 10, 7));
         e.add( new Item(10, 0, 8));
         e.add( new Item(10, 10, 9));
        
         e.add( new BlocoVermelho(0, 3));
         e.add( new BlocoVermelho(0, 7));
        
         e.add( new BlocoVermelho(1, 0));
         e.add( new BlocoVermelho(1, 8));
        
         e.add( new BlocoVermelho(2, 5));
        
         e.add( new BlocoVermelho(3, 2));
         e.add( new BlocoVermelho(3, 10));
        
         e.add( new BlocoVermelho(5, 2));
         e.add( new BlocoVermelho(5, 8));
        
         e.add( new BlocoVermelho(6, 3));
        
         e.add( new BlocoVermelho(7, 0));
        
         e.add( new BlocoVermelho(8, 1));
         e.add( new BlocoVermelho(8, 7));
         e.add( new BlocoVermelho(8, 10));
        
         e.add( new BlocoVermelho(10, 1));
        
         e.add( new BlocoVerde(1, 1));
         e.add( new BlocoVerde(1, 3));
         e.add( new BlocoVerde(1, 5));
         e.add( new BlocoVerde(1, 7));
         e.add( new BlocoVerde(1, 9));
        
         e.add( new BlocoVerde(2, 2));
         e.add( new BlocoVerde(2, 4));
         e.add( new BlocoVerde(2, 6));
         e.add( new BlocoVerde(2, 8));
        
         e.add( new BlocoVerde(3, 1));
         e.add( new BlocoVerde(3, 3));
         e.add( new BlocoVerde(3, 5));
         e.add( new BlocoVerde(3, 7));
         e.add( new BlocoVerde(3, 9));
        
         e.add( new BlocoVerde(4, 2));
         e.add( new BlocoVerde(4, 4));
         e.add( new BlocoVerde(4, 6));
         e.add( new BlocoVerde(4, 8));
        
         e.add( new BlocoVerde(5, 1));
         e.add( new BlocoVerde(5, 3));
         e.add( new BlocoVerde(5, 5));
         e.add( new BlocoVerde(5, 7));
         e.add( new BlocoVerde(5, 9));
        
         e.add( new BlocoVerde(6, 2));
         e.add( new BlocoVerde(6, 4));
         e.add( new BlocoVerde(6, 6));
         e.add( new BlocoVerde(6, 8));
        
         e.add( new BlocoVerde(7, 1));
         e.add( new BlocoVerde(7, 3));
         e.add( new BlocoVerde(7, 5));
         e.add( new BlocoVerde(7, 7));
         e.add( new BlocoVerde(7, 9));
        
         e.add( new BlocoVerde(8, 2));
         e.add( new BlocoVerde(8, 4));
         e.add( new BlocoVerde(8, 6));
         e.add( new BlocoVerde(8, 8));
        
         e.add( new BlocoVerde(9, 1));
         e.add( new BlocoVerde(9, 3));
         e.add( new BlocoVerde(9, 5));
         e.add( new BlocoVerde(9, 7));
         e.add( new BlocoVerde(9, 9));
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }

    
}