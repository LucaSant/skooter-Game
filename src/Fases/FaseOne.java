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
        
        this.addElement(e, new Vilao(2, 0));
        this.addElement(e, new Vilao(0, 9));
        this.addElement(e, new Vilao(10, 1));
        this.addElement(e, new Vilao(10, 9));
        
        this.addElement(e, new Item(0, 0));
        this.addElement(e, new Item(0, 10));
        this.addElement(e, new Item(10, 0));
        this.addElement(e, new Item(10, 10));
        
        this.addElement(e, new BlocoVermelho(1, 1));
        this.addElement(e, new BlocoVermelho(1, 3));
        this.addElement(e, new BlocoVermelho(1, 5));
        this.addElement(e, new BlocoVermelho(1, 7));
        this.addElement(e, new BlocoVermelho(1, 9));
        
        this.addElement(e, new BlocoVermelho(3, 1));
        this.addElement(e, new BlocoVermelho(3, 3));
        this.addElement(e, new BlocoVermelho(3, 5));
        this.addElement(e, new BlocoVermelho(3, 7));
        this.addElement(e, new BlocoVermelho(3, 9));
        
        this.addElement(e, new BlocoVermelho(5, 1));
        this.addElement(e, new BlocoVermelho(5, 3));
        this.addElement(e, new BlocoVermelho(5, 5));
        this.addElement(e, new BlocoVermelho(5, 7));
        this.addElement(e, new BlocoVermelho(5, 9));
        
        this.addElement(e, new BlocoVermelho(7, 1));
        this.addElement(e, new BlocoVermelho(7, 3));
        this.addElement(e, new BlocoVermelho(7, 5));
        this.addElement(e, new BlocoVermelho(7, 7));
        this.addElement(e, new BlocoVermelho(7, 9));
        
        this.addElement(e, new BlocoVermelho(9, 1));
        this.addElement(e, new BlocoVermelho(9, 3));
        this.addElement(e, new BlocoVermelho(9, 5));
        this.addElement(e, new BlocoVermelho(9, 7));
        this.addElement(e, new BlocoVermelho(9, 9));
        
        this.addElement(e, new BlocoVerdeMovivel(0, 1));
        this.addElement(e, new BlocoVerdeMovivel(0, 5));
        
        this.addElement(e, new BlocoVerdeMovivel(1, 2));
        this.addElement(e, new BlocoVerdeMovivel(1, 8));
        this.addElement(e, new BlocoVerdeMovivel(1, 10));
        
        this.addElement(e, new BlocoVerdeMovivel(2, 1));
        this.addElement(e, new BlocoVerdeMovivel(2, 5));
        
        this.addElement(e, new BlocoVerdeMovivel(3, 0));
        this.addElement(e, new BlocoVerdeMovivel(3, 8));
        
        this.addElement(e, new BlocoVerdeMovivel(4, 1));
        this.addElement(e, new BlocoVerdeMovivel(4, 9));
        
        this.addElement(e, new BlocoVerdeMovivel(5, 2));
        this.addElement(e, new BlocoVerdeMovivel(5, 6));
        
        this.addElement(e, new BlocoVerdeMovivel(6, 5));
        this.addElement(e, new BlocoVerdeMovivel(6, 7));
        
        this.addElement(e, new BlocoVerdeMovivel(7, 8));
        this.addElement(e, new BlocoVerdeMovivel(7, 10));
        
        this.addElement(e, new BlocoVerdeMovivel(8, 3));
        this.addElement(e, new BlocoVerdeMovivel(8, 9));
        
        this.addElement(e, new BlocoVerdeMovivel(9, 0));
        this.addElement(e, new BlocoVerdeMovivel(9, 2));
        this.addElement(e, new BlocoVerdeMovivel(9, 6));
        this.addElement(e, new BlocoVerdeMovivel(9, 8));
        
        this.addElement(e, new BlocoVerdeMovivel(10, 7));  
        
        this.setnItens(this.numberOfItens(e));
    }

    

    
}