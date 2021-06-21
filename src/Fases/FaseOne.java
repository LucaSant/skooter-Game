package Fases;

import java.util.ArrayList;
import Controler.Fase;
import Modelo.*;

public class FaseOne extends Fase {
    
    public FaseOne(){
        super(1, "fundo.png");

    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 1
        e.clear();
        e.add(hero);
        hero.setPosicao(4, 4);
        
         e.add( new Vilao(2, 0));
         e.add( new Vilao(0, 9));
         e.add( new Vilao(10, 1));
         e.add( new Vilao(10, 9));
        
         e.add( new Item(0, 0, 50));
         e.add( new Item(0, 10, 75));
         e.add( new Item(10, 0, 150));
         e.add( new Item(10, 10, 175));
        
         e.add( new BlocoVermelho(1, 1));
         e.add( new BlocoVermelho(1, 3));
         e.add( new BlocoVermelho(1, 5));
         e.add( new BlocoVermelho(1, 7));
         e.add( new BlocoVermelho(1, 9));
        
         e.add( new BlocoVermelho(3, 1));
         e.add( new BlocoVermelho(3, 3));
         e.add( new BlocoVermelho(3, 5));
         e.add( new BlocoVermelho(3, 7));
         e.add( new BlocoVermelho(3, 9));
        
         e.add( new BlocoVermelho(5, 1));
         e.add( new BlocoVermelho(5, 3));
         e.add( new BlocoVermelho(5, 5));
         e.add( new BlocoVermelho(5, 7));
         e.add( new BlocoVermelho(5, 9));
        
         e.add( new BlocoVermelho(7, 1));
         e.add( new BlocoVermelho(7, 3));
         e.add( new BlocoVermelho(7, 5));
         e.add( new BlocoVermelho(7, 7));
         e.add( new BlocoVermelho(7, 9));
        
         e.add( new BlocoVermelho(9, 1));
         e.add( new BlocoVermelho(9, 3));
         e.add( new BlocoVermelho(9, 5));
         e.add( new BlocoVermelho(9, 7));
         e.add( new BlocoVermelho(9, 9));
        
         e.add( new BlocoVerdeMovivel(0, 1));
         e.add( new BlocoVerdeMovivel(0, 5));
        
         e.add( new BlocoVerdeMovivel(1, 2));
         e.add( new BlocoVerdeMovivel(1, 8));
         e.add( new BlocoVerdeMovivel(1, 10));
        
         e.add( new BlocoVerdeMovivel(2, 1));
         e.add( new BlocoVerdeMovivel(2, 5));
        
         e.add( new BlocoVerdeMovivel(3, 0));
         e.add( new BlocoVerdeMovivel(3, 8));
        
         e.add( new BlocoVerdeMovivel(4, 1));
         e.add( new BlocoVerdeMovivel(4, 9));
        
         e.add( new BlocoVerdeMovivel(5, 2));
         e.add( new BlocoVerdeMovivel(5, 6));
        
         e.add( new BlocoVerdeMovivel(6, 5));
         e.add( new BlocoVerdeMovivel(6, 7));
        
         e.add( new BlocoVerdeMovivel(7, 8));
         e.add( new BlocoVerdeMovivel(7, 10));
        
         e.add( new BlocoVerdeMovivel(8, 3));
         e.add( new BlocoVerdeMovivel(8, 9));
        
         e.add( new BlocoVerdeMovivel(9, 0));
         e.add( new BlocoVerdeMovivel(9, 2));
         e.add( new BlocoVerdeMovivel(9, 6));
         e.add( new BlocoVerdeMovivel(9, 8));
        
         e.add( new BlocoVerdeMovivel(10, 7));  
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }

    

    
}