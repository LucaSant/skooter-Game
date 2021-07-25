package Fases;

import java.util.ArrayList;

import Controler.Fase;
import Modelo.Elemento;
import Modelo.FactoryElemento;
import Modelo.Hero;


public class TelaInicial extends Fase {    
  
    public TelaInicial() {
        super( 0 , "inicio.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) {
        e.clear();
        FactoryElemento fe = new FactoryElemento(e);
        fe.mk("item-10", 0, 0);
    }

    


   
}
