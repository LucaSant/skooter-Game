package Fases;

import java.util.ArrayList;

import Controler.Fase;
import Modelo.Elemento;
import Modelo.Hero;


public class FaseOne extends Fase {
    
    public FaseOne(){
        super(1, "background.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) {
       //ajeita os elementos para a Fase 1
        e.clear();
        this.addElement(hero);
        this.addElement(umElemento);
        
    }

    
}
