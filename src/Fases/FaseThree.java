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
    public void setAllElementos(ArrayList<Elemento> e, Hero hero) { //Ajeita os elementos para a Fase 3
        e.clear();
        e.add(hero);
        hero.setPosicao(5, 5);

         e.add( new Vilao(0, 5));
         e.add( new Vilao(2, 5));
         e.add( new Vilao(8, 5));
         e.add( new Vilao(10, 5));

         e.add( new Item(5, 0, 120));
         e.add( new Item(5, 2, 180));
         e.add( new Item(5, 8, 225));
         e.add( new Item(5, 10, 300));

         e.add( new BlocoVermelhoMovivel(1, 1));
         e.add( new BlocoVermelhoMovivel(1, 2));
         e.add( new BlocoVermelhoMovivel(1, 3));
         e.add( new BlocoVermelhoMovivel(1, 4));
         e.add( new BlocoVermelhoMovivel(1, 5));
         e.add( new BlocoVermelhoMovivel(1, 6));
         e.add( new BlocoVermelhoMovivel(1, 7));
         e.add( new BlocoVermelhoMovivel(1, 8));
         e.add( new BlocoVermelhoMovivel(1, 9));

         e.add( new BlocoVermelhoMovivel(9, 1));
         e.add( new BlocoVermelhoMovivel(9, 2));
         e.add( new BlocoVermelhoMovivel(9, 3));
         e.add( new BlocoVermelhoMovivel(9, 4));
         e.add( new BlocoVermelhoMovivel(9, 5));
         e.add( new BlocoVermelhoMovivel(9, 6));
         e.add( new BlocoVermelhoMovivel(9, 7));
         e.add( new BlocoVermelhoMovivel(9, 8));
         e.add( new BlocoVermelhoMovivel(9, 9));

         e.add( new BlocoVermelhoMovivel(2, 1));
         e.add( new BlocoVermelhoMovivel(3, 1));
         e.add( new BlocoVermelhoMovivel(4, 1));
         e.add( new BlocoVermelhoMovivel(5, 1));
         e.add( new BlocoVermelhoMovivel(6, 1));
         e.add( new BlocoVermelhoMovivel(7, 1));
         e.add( new BlocoVermelhoMovivel(8, 1));

         e.add( new BlocoVermelhoMovivel(2, 9));
         e.add( new BlocoVermelhoMovivel(3, 9));
         e.add( new BlocoVermelhoMovivel(4, 9));
         e.add( new BlocoVermelhoMovivel(5, 9));
         e.add( new BlocoVermelhoMovivel(6, 9));
         e.add( new BlocoVermelhoMovivel(7, 9));
         e.add( new BlocoVermelhoMovivel(8, 9));

         e.add( new BlocoVermelhoMovivel(3, 3));
         e.add( new BlocoVermelhoMovivel(3, 4));
         e.add( new BlocoVermelhoMovivel(3, 5));
         e.add( new BlocoVermelhoMovivel(3, 6));
         e.add( new BlocoVermelhoMovivel(3, 7));

         e.add( new BlocoVermelhoMovivel(7, 3));
         e.add( new BlocoVermelhoMovivel(7, 4));
         e.add( new BlocoVermelhoMovivel(7, 5));
         e.add( new BlocoVermelhoMovivel(7, 6));
         e.add( new BlocoVermelhoMovivel(7, 7));
        
         e.add( new BlocoVermelhoMovivel(4, 3));
         e.add( new BlocoVermelhoMovivel(5, 3));
         e.add( new BlocoVermelhoMovivel(6, 3));

         e.add( new BlocoVermelhoMovivel(4, 7));
         e.add( new BlocoVermelhoMovivel(5, 7));
         e.add( new BlocoVermelhoMovivel(6, 7));
        this.setnItens(this.numberOfItens(e));
        this.setnViloes(this.numberOfVillans(e));
    }

}
