package Fases;

import java.util.ArrayList;
import Controler.Fase;
import Modelo.*;

public class FaseThree extends Fase{
    
    public FaseThree(){
        super(3, "fundo3.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 3
        
        FactoryElemento fe = new FactoryElemento(e);
        
        e.clear();
        
        fe.setHero(hero, 5, 5);

        fe.mk("vilao", 0, 5);
        fe.mk("vilao", 2, 5);
        fe.mk("vilao", 8, 5);
        fe.mk("vilao", 10, 5);
         
        fe.mk("item-5", 5, 0);
        fe.mk("item-6", 5, 2);
        fe.mk("item-7", 5, 8);
        fe.mk("item-8", 5, 10);

        fe.mk("bloco vermelho movel", 1, 1);
        fe.mk("bloco vermelho movel", 1, 2);
        fe.mk("bloco vermelho movel", 1, 3);
        fe.mk("bloco vermelho movel", 1, 4);
        fe.mk("bloco vermelho movel", 1, 5);
        fe.mk("bloco vermelho movel", 1, 6);
        fe.mk("bloco vermelho movel", 1, 7);
        fe.mk("bloco vermelho movel", 1, 8);
        fe.mk("bloco vermelho movel", 1, 9);
        
        fe.mk("bloco vermelho movel", 9, 1);
        fe.mk("bloco vermelho movel", 9, 2);
        fe.mk("bloco vermelho movel", 9, 3);
        fe.mk("bloco vermelho movel", 9, 4);
        fe.mk("bloco vermelho movel", 9, 5);
        fe.mk("bloco vermelho movel", 9, 6);
        fe.mk("bloco vermelho movel", 9, 7);
        fe.mk("bloco vermelho movel", 9, 8);
        fe.mk("bloco vermelho movel", 9, 9);
        
        fe.mk("bloco vermelho movel", 2, 1);
        fe.mk("bloco vermelho movel", 3, 1);
        fe.mk("bloco vermelho movel", 4, 1);
        fe.mk("bloco vermelho movel", 5, 1);
        fe.mk("bloco vermelho movel", 6, 1);
        fe.mk("bloco vermelho movel", 7, 1);
        fe.mk("bloco vermelho movel", 8, 1);
        
        fe.mk("bloco vermelho movel", 2, 9);
        fe.mk("bloco vermelho movel", 3, 9);
        fe.mk("bloco vermelho movel", 4, 9);
        fe.mk("bloco vermelho movel", 5, 9);
        fe.mk("bloco vermelho movel", 6, 9);
        fe.mk("bloco vermelho movel", 7, 9);
        fe.mk("bloco vermelho movel", 8, 9);
        
        fe.mk("bloco vermelho movel", 3, 3);
        fe.mk("bloco vermelho movel", 3, 4);
        fe.mk("bloco vermelho movel", 3, 5);
        fe.mk("bloco vermelho movel", 3, 6);
        fe.mk("bloco vermelho movel", 3, 7);
        
        fe.mk("bloco vermelho movel", 7, 3);
        fe.mk("bloco vermelho movel", 7, 4);
        fe.mk("bloco vermelho movel", 7, 5);
        fe.mk("bloco vermelho movel", 7, 6);
        fe.mk("bloco vermelho movel", 7, 7);
        
        fe.mk("bloco vermelho movel", 4, 3);
        fe.mk("bloco vermelho movel", 5, 3);
        fe.mk("bloco vermelho movel", 6, 3);
        fe.mk("bloco vermelho movel", 4, 7);
        fe.mk("bloco vermelho movel", 5, 7);
        fe.mk("bloco vermelho movel", 6, 7);
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }
}