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
        fe.mk("bloco vermelho", 5, 8);
        
        fe.mk("bloco vermelho", 6, 3);
        
        fe.mk("bloco vermelho", 7, 0);
        
        fe.mk("bloco vermelho", 5, 1);
        fe.mk("bloco vermelho", 8, 7);
        fe.mk("bloco vermelho", 8, 10);
        
        fe.mk("bloco vermelho", 10, 1);
        
        fe.mk("bloco verde", 1, 1);
        fe.mk("bloco verde", 1, 3);
        fe.mk("bloco verde", 1, 5);
        fe.mk("bloco verde", 1, 7);
        fe.mk("bloco verde", 1, 9);
        
        fe.mk("bloco verde", 2, 2);
        fe.mk("bloco verde", 2, 4);
        fe.mk("bloco verde", 2, 6);
        fe.mk("bloco verde", 2, 8);
        
        fe.mk("bloco verde", 3, 1);
        fe.mk("bloco verde", 3, 3);
        fe.mk("bloco verde", 3, 5);
        fe.mk("bloco verde", 3, 7);
        fe.mk("bloco verde", 3, 9);
        
        fe.mk("bloco verde", 4, 2);
        fe.mk("bloco verde", 4, 4);
        fe.mk("bloco verde", 4, 6);
        fe.mk("bloco verde", 4, 8);
        
        fe.mk("bloco verde", 5, 1);
        fe.mk("bloco verde", 5, 3);
        fe.mk("bloco verde", 5, 5);
        fe.mk("bloco verde", 5, 7);
        fe.mk("bloco verde", 5, 9);
        
        fe.mk("bloco verde", 6, 2);
        fe.mk("bloco verde", 6, 4);
        fe.mk("bloco verde", 6, 6);
        fe.mk("bloco verde", 6, 8);
        
        fe.mk("bloco verde", 7, 1);
        fe.mk("bloco verde", 7, 3);
        fe.mk("bloco verde", 7, 5);
        fe.mk("bloco verde", 7, 7);
        fe.mk("bloco verde", 7, 9);
        
        fe.mk("bloco verde", 8, 2);
        fe.mk("bloco verde", 8, 4);
        fe.mk("bloco verde", 8, 6);
        fe.mk("bloco verde", 8, 8);
        
        fe.mk("bloco verde", 9, 1);
        fe.mk("bloco verde", 9, 3);
        fe.mk("bloco verde", 9, 5);
        fe.mk("bloco verde", 9, 7);
        fe.mk("bloco verde", 9, 9);
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }
}