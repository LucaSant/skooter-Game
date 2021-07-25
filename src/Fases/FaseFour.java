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
        FactoryElemento fe = new FactoryElemento(e);
        
        e.clear();
        fe.setHero(hero, 4, 5);
        
        fe.mk("vilao", 0, 5);
        fe.mk("vilao", 5, 0);
        fe.mk("vilao", 5, 10);
        fe.mk("vilao", 10, 5);
        
        fe.mk("item-6", 0, 0);
        fe.mk("item-7", 0, 10);
        fe.mk("item-8", 10, 0);
        fe.mk("item-9", 10, 10);
        
        fe.mk("bloco vermelho", 0, 3);
        fe.mk("Bloco vermelho", 0, 7);
        fe.mk("bloco vermelho", 1, 0);
        fe.mk("vermelho bloco", 1, 8);
        fe.mk("bloco vermelho", 2, 5);
        fe.mk("bloco vermelho", 3, 2);
        fe.mk("bloco vermelho", 3, 10);
        fe.mk("bloco vermelho", 5, 2);
        fe.mk("BlocoVermelho",5, 8);
        
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