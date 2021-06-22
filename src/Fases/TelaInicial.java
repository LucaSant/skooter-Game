package Fases;

import java.util.ArrayList;

import Controler.Fase;
import Modelo.Elemento;
import Modelo.Hero;
import Modelo.Item;

public class TelaInicial extends Fase {    
  
    public TelaInicial() {
        super( 0 , "inicio.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) {
        e.clear();
        e.add(new Item(0, 0, 10));
    }

    


   
}
