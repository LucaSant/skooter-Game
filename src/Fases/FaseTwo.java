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
        fe.setHero(hero, 5,5);
        
        fe.mk("Vilao",1, 1);
        fe.mk("Vilao",1, 9);
        e.add(new Vilao(9, 1));
        e.add(new Vilao(9, 9));
        
        fe.mk("Item-1", 1, 5);
        fe.mk("item-2",5 , 1);
        fe.mk("item-3", 5, 9);
        fe.mk("item-4", 9, 5);
        
        e.add(new BlocoVermelho(1, 3));
        e.add(new BlocoVermelho(1, 7));
        
        e.add(new BlocoVermelho(3, 1));
        e.add(new BlocoVermelho(3, 3));
        e.add(new BlocoVermelho(3, 5));
        e.add(new BlocoVermelho(3, 7));
        e.add(new BlocoVermelho(3, 9));
        
        e.add(new BlocoVermelho(5, 3));
        e.add(new BlocoVermelho(5, 7));
        
        e.add(new BlocoVermelho(7, 1));
        e.add(new BlocoVermelho(7, 3));
        e.add(new BlocoVermelho(7, 5));
        e.add(new BlocoVermelho(7, 7));
        e.add(new BlocoVermelho(7, 9));
        
        e.add(new BlocoVermelho(9, 3));
        e.add(new BlocoVermelho(9, 7));
        
        fe.mk("seta Direita",0, 3);
        fe.mk("setadireita", 0, 7);
        fe.mk("SetaDireita", 2, 3);
        e.add(new SetaDireita(4, 3));
        e.add(new SetaDireita(4, 7));
        e.add(new SetaDireita(6, 3));
        e.add(new SetaDireita(8, 3));
        e.add(new SetaDireita(8, 7));
        e.add(new SetaDireita(10, 7));
        
        fe.mk("seta baixo", 2, 4);
        e.add(new SetaAbaixo(3, 2));
        e.add(new SetaAbaixo(3, 4));
        e.add(new SetaAbaixo(3, 10));
        e.add(new SetaAbaixo(7, 2));
        e.add(new SetaAbaixo(7, 4));
        
        e.add(new SetaEsquerda(2, 5));
        e.add(new SetaEsquerda(2, 6));
        e.add(new SetaEsquerda(2, 7));
        e.add(new SetaEsquerda(4, 9));
        e.add(new SetaEsquerda(4, 10));
        e.add(new SetaEsquerda(6, 7));
        e.add(new SetaEsquerda(10, 3));
        
        fe.mk("seta cima", 3, 0);
        e.add(new SetaAcima(3, 6));
        e.add(new SetaAcima(3, 8));
        e.add(new SetaAcima(4, 0));
        e.add(new SetaAcima(4, 8));
        e.add(new SetaAcima(5, 0));
        e.add(new SetaAcima(6, 0));
        e.add(new SetaAcima(7, 0));
        e.add(new SetaAcima(7, 6));
        e.add(new SetaAcima(7, 8));
        e.add(new SetaAcima(7, 10));
        
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }

    
}