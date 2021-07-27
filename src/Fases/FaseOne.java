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
        
        FactoryElemento fe = new FactoryElemento(e);
        e.clear();
        
        fe.setHero(hero, 4, 4);
        
        fe.mk("vilao", 2, 0);
        fe.mk("vilao", 0, 9);
        fe.mk("vilao", 10, 1);
        fe.mk("vilao", 10, 9);
        
        fe.mk("item-1", 0,0);
        fe.mk("item-2", 0, 10);
        fe.mk("Item-3",10, 0);
        fe.mk("item-4", 10, 10);
        
        fe.mk("bloco vermelho", 1, 1);
        fe.mk("bloco vermelho", 1, 3);
        fe.mk("bloco vermelho", 1, 5);
        fe.mk("bloco vermelho", 1, 7);
        fe.mk("bloco vermelho", 1, 9);
        
        fe.mk("bloco vermelho", 3, 1);
        fe.mk("bloco vermelho", 3, 3);
        fe.mk("bloco vermelho", 3, 5);
        fe.mk("bloco vermelho", 3, 7);
        fe.mk("bloco vermelho", 3, 9);
        
        fe.mk("bloco vermelho", 5, 1);
        fe.mk("bloco vermelho", 5, 3);
        fe.mk("bloco vermelho", 5, 5);
        fe.mk("bloco vermelho", 5, 7);
        fe.mk("bloco vermelho", 5, 9);
        
        fe.mk("bloco vermelho", 7, 1);
        fe.mk("bloco vermelho", 7, 3);
        fe.mk("bloco vermelho", 7, 5);
        fe.mk("bloco vermelho", 7, 7);
        fe.mk("bloco vermelho", 7, 9);
        
        fe.mk("bloco vermelho", 9, 1);
        fe.mk("bloco vermelho", 9, 3);
        fe.mk("bloco vermelho", 9, 5);
        fe.mk("bloco vermelho", 9, 7);
        fe.mk("bloco vermelho", 9, 9);
        
        fe.mk("bloco verde movel", 0, 1);
        fe.mk("Bloco verde movel", 0, 5);
        
        fe.mk("Bloco verde movel", 1, 2);
        fe.mk("Bloco verde movel", 1, 8);
        
        fe.mk("Bloco verde movel", 2, 1);
        fe.mk("Bloco verde movel", 2, 5);
        
        fe.mk("Bloco verde movel", 3, 0);
        fe.mk("Bloco verde movel", 3, 8);
        
        fe.mk("Bloco verde movel", 4, 1);
        fe.mk("Bloco verde movel", 4, 9);
        
        fe.mk("Bloco verde movel", 5, 2);
        fe.mk("Bloco verde movel", 5, 6);
        
        fe.mk("Bloco verde movel", 6, 5);
        fe.mk("Bloco verde movel", 6, 7);
        
        fe.mk("Bloco verde movel", 7, 8);
        fe.mk("Bloco verde movel", 7, 10);
        
        fe.mk("Bloco verde movel", 8, 3);
        fe.mk("Bloco verde movel", 8, 9);
        
        fe.mk("Bloco verde movel", 9, 0);
        fe.mk("Bloco verde movel", 9, 2);
        fe.mk("Bloco verde movel", 9, 6);
        fe.mk("Bloco verde movel", 9, 8);
        
        fe.mk("Bloco verde movel", 10, 7);
        fe.mk("portal", 4, 0);
        fe.mk("portal", 0, 6);
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }
}