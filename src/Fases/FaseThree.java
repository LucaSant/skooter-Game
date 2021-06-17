/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Fases;

import java.util.ArrayList;

import Controler.Fase;
import Modelo.*;
/**
 *
 * @author Antonio
 */
public class FaseThree extends Fase{
    
    public FaseThree(){
        super(3, "fundo3.png");
    }

    @Override
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 1
        e.clear();
        
        e.add(hero);
        hero.setPosicao(5, 5);

        this.addElement(e, new Item(5, 0));
        this.addElement(e, new Item(5, 2));
        this.addElement(e, new Item(5, 8));
        this.addElement(e, new Item(5, 10));

        this.addElement(e, new Vilao(0, 5));
        this.addElement(e, new Vilao(2, 5));
        this.addElement(e, new Vilao(8, 5));
        this.addElement(e, new Vilao(10, 5));

        this.addElement(e, new BlocoVermelhoMovivel(1, 1));
        this.addElement(e, new BlocoVermelhoMovivel(1, 2));
        this.addElement(e, new BlocoVermelhoMovivel(1, 3));
        this.addElement(e, new BlocoVermelhoMovivel(1, 4));
        this.addElement(e, new BlocoVermelhoMovivel(1, 5));
        this.addElement(e, new BlocoVermelhoMovivel(1, 6));
        this.addElement(e, new BlocoVermelhoMovivel(1, 7));
        this.addElement(e, new BlocoVermelhoMovivel(1, 8));
        this.addElement(e, new BlocoVermelhoMovivel(1, 9));

        this.addElement(e, new BlocoVermelhoMovivel(9, 1));
        this.addElement(e, new BlocoVermelhoMovivel(9, 2));
        this.addElement(e, new BlocoVermelhoMovivel(9, 3));
        this.addElement(e, new BlocoVermelhoMovivel(9, 4));
        this.addElement(e, new BlocoVermelhoMovivel(9, 5));
        this.addElement(e, new BlocoVermelhoMovivel(9, 6));
        this.addElement(e, new BlocoVermelhoMovivel(9, 7));
        this.addElement(e, new BlocoVermelhoMovivel(9, 8));
        this.addElement(e, new BlocoVermelhoMovivel(9, 9));

        this.addElement(e, new BlocoVermelhoMovivel(2, 1));
        this.addElement(e, new BlocoVermelhoMovivel(3, 1));
        this.addElement(e, new BlocoVermelhoMovivel(4, 1));
        this.addElement(e, new BlocoVermelhoMovivel(5, 1));
        this.addElement(e, new BlocoVermelhoMovivel(6, 1));
        this.addElement(e, new BlocoVermelhoMovivel(7, 1));
        this.addElement(e, new BlocoVermelhoMovivel(8, 1));

        this.addElement(e, new BlocoVermelhoMovivel(2, 9));
        this.addElement(e, new BlocoVermelhoMovivel(3, 9));
        this.addElement(e, new BlocoVermelhoMovivel(4, 9));
        this.addElement(e, new BlocoVermelhoMovivel(5, 9));
        this.addElement(e, new BlocoVermelhoMovivel(6, 9));
        this.addElement(e, new BlocoVermelhoMovivel(7, 9));
        this.addElement(e, new BlocoVermelhoMovivel(8, 9));

        this.addElement(e, new BlocoVermelhoMovivel(3, 3));
        this.addElement(e, new BlocoVermelhoMovivel(3, 4));
        this.addElement(e, new BlocoVermelhoMovivel(3, 5));
        this.addElement(e, new BlocoVermelhoMovivel(3, 6));
        this.addElement(e, new BlocoVermelhoMovivel(3, 7));

        this.addElement(e, new BlocoVermelhoMovivel(7, 3));
        this.addElement(e, new BlocoVermelhoMovivel(7, 4));
        this.addElement(e, new BlocoVermelhoMovivel(7, 5));
        this.addElement(e, new BlocoVermelhoMovivel(7, 6));
        this.addElement(e, new BlocoVermelhoMovivel(7, 7));
        
        this.addElement(e, new BlocoVermelhoMovivel(4, 3));
        this.addElement(e, new BlocoVermelhoMovivel(5, 3));
        this.addElement(e, new BlocoVermelhoMovivel(6, 3));

        this.addElement(e, new BlocoVermelhoMovivel(4, 7));
        this.addElement(e, new BlocoVermelhoMovivel(5, 7));
        this.addElement(e, new BlocoVermelhoMovivel(6, 7));
        this.setnItens(this.numberOfItens(e));
    }

}
