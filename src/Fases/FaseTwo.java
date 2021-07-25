package Fases;

import java.util.ArrayList;
import Controler.Fase;
import Modelo.*;

public class FaseTwo extends Fase {
    
    public FaseTwo(){
        super(2, "fundo2.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 2
        
        FactoryElemento fe = new FactoryElemento(e);
        
        e.clear();
        
        fe.setHero(hero, 5, 5);
        
        fe.mk("Vilao", 1, 1);
        fe.mk("Vilao", 1, 9);
        fe.mk("Vilao", 9, 1);
        fe.mk("Vilao", 9, 9);
        
        fe.mk("Item-1", 1, 5);
        fe.mk("item-2",5 , 1);
        fe.mk("item-3", 5, 9);
        fe.mk("item-4", 9, 5);
        
        fe.mk("bloco vermelho", 1, 3);
        fe.mk("bloco vermelho", 1, 7);
        
        fe.mk("bloco vermelho", 3, 1);
        fe.mk("bloco vermelho", 3, 3);
        fe.mk("bloco vermelho", 3, 5);
        fe.mk("bloco vermelho", 3, 7);
        fe.mk("bloco vermelho", 3, 9);
        
        fe.mk("bloco vermelho", 5, 3);
        fe.mk("bloco vermelho", 5, 7);
        
        fe.mk("bloco vermelho", 7, 1);
        fe.mk("bloco vermelho", 7, 3);
        fe.mk("bloco vermelho", 7, 5);
        fe.mk("bloco vermelho", 7, 7);
        fe.mk("bloco vermelho", 7, 9);
        
        fe.mk("bloco vermelho", 9, 3);
        fe.mk("bloco vermelho", 9, 7);
        
        fe.mk("seta direita", 0, 3);
        fe.mk("seta direita", 0, 7);
        fe.mk("seta direita", 2, 3);
        fe.mk("seta direita", 4, 3);
        fe.mk("seta direita", 4, 7);
        fe.mk("seta direita", 6, 3);
        fe.mk("seta direita", 8, 3);
        fe.mk("seta direita", 8, 7);
        fe.mk("seta direita", 10, 7);
        
        fe.mk("seta baixo", 2, 4);
        fe.mk("seta baixo", 3, 2);
        fe.mk("seta baixo", 3, 4);
        fe.mk("seta baixo", 3, 10);
        fe.mk("seta baixo", 7, 2);
        fe.mk("seta baixo", 7, 4);
        
        fe.mk("seta esquerda", 2, 5);
        fe.mk("seta esquerda", 2, 6);
        fe.mk("seta esquerda", 2, 7);
        fe.mk("seta esquerda", 4, 9);
        fe.mk("seta esquerda", 4, 10);
        fe.mk("seta esquerda", 6, 7);
        fe.mk("seta esquerda", 10, 3);
        
        fe.mk("seta cima", 3, 0);
        fe.mk("seta cima", 3, 6);
        fe.mk("seta cima", 3, 8);
        fe.mk("seta cima", 4, 0);
        fe.mk("seta cima", 4, 8);
        fe.mk("seta cima", 5, 0);
        fe.mk("seta cima", 6, 0);
        fe.mk("seta cima", 7, 0);
        fe.mk("seta cima", 7, 6);
        fe.mk("seta cima", 7, 8);
        fe.mk("seta cima", 7, 10);
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }

    
}