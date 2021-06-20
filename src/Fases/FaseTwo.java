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
        e.clear();
        this.setnViloes(0);
        e.add(hero);
        hero.setPosicao(5, 5);
        
        this.addElement(e, new Vilao(1, 1));
        this.addElement(e, new Vilao(1, 9));
        this.addElement(e, new Vilao(9, 1));
        this.addElement(e, new Vilao(9, 9));
        
        this.addElement(e, new Item(1, 5));
        this.addElement(e, new Item(5, 1));
        this.addElement(e, new Item(5, 9));
        this.addElement(e, new Item(9, 5));
        
        this.addElement(e, new BlocoVermelho(1, 3));
        this.addElement(e, new BlocoVermelho(1, 7));
        
        this.addElement(e, new BlocoVermelho(3, 1));
        this.addElement(e, new BlocoVermelho(3, 3));
        this.addElement(e, new BlocoVermelho(3, 5));
        this.addElement(e, new BlocoVermelho(3, 7));
        this.addElement(e, new BlocoVermelho(3, 9));
        
        this.addElement(e, new BlocoVermelho(5, 3));
        this.addElement(e, new BlocoVermelho(5, 7));
        
        this.addElement(e, new BlocoVermelho(7, 1));
        this.addElement(e, new BlocoVermelho(7, 3));
        this.addElement(e, new BlocoVermelho(7, 5));
        this.addElement(e, new BlocoVermelho(7, 7));
        this.addElement(e, new BlocoVermelho(7, 9));
        
        this.addElement(e, new BlocoVermelho(9, 3));
        this.addElement(e, new BlocoVermelho(9, 7));
        
        this.addElement(e, new SetaDireita(0, 3));
        this.addElement(e, new SetaDireita(0, 7));
        this.addElement(e, new SetaDireita(2, 3));
        this.addElement(e, new SetaDireita(4, 3));
        this.addElement(e, new SetaDireita(4, 7));
        this.addElement(e, new SetaDireita(6, 3));
        this.addElement(e, new SetaDireita(8, 3));
        this.addElement(e, new SetaDireita(8, 7));
        this.addElement(e, new SetaDireita(10, 7));
        
        this.addElement(e, new SetaAbaixo(2, 4));
        this.addElement(e, new SetaAbaixo(3, 2));
        this.addElement(e, new SetaAbaixo(3, 4));
        this.addElement(e, new SetaAbaixo(3, 10));
        this.addElement(e, new SetaAbaixo(7, 2));
        this.addElement(e, new SetaAbaixo(7, 4));
        
        this.addElement(e, new SetaEsquerda(2, 5));
        this.addElement(e, new SetaEsquerda(2, 6));
        this.addElement(e, new SetaEsquerda(2, 7));
        this.addElement(e, new SetaEsquerda(4, 9));
        this.addElement(e, new SetaEsquerda(4, 10));
        this.addElement(e, new SetaEsquerda(6, 7));
        this.addElement(e, new SetaEsquerda(10, 3));
        
        this.addElement(e, new SetaAcima(3, 0));
        this.addElement(e, new SetaAcima(3, 6));
        this.addElement(e, new SetaAcima(3, 8));
        this.addElement(e, new SetaAcima(4, 0));
        this.addElement(e, new SetaAcima(4, 8));
        this.addElement(e, new SetaAcima(5, 0));
        this.addElement(e, new SetaAcima(6, 0));
        this.addElement(e, new SetaAcima(7, 0));
        this.addElement(e, new SetaAcima(7, 6));
        this.addElement(e, new SetaAcima(7, 8));
        this.addElement(e, new SetaAcima(7, 10));
        
        this.setnItens(this.numberOfItens(e));
    }

    
}