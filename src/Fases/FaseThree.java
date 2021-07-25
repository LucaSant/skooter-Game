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
         e.add( new Vilao(2, 5));
         e.add( new Vilao(8, 5));
         e.add( new Vilao(10, 5));
         
        fe.mk("item-5", 5, 0);
        fe.mk("item-6", 5, 2);
        fe.mk("item-7", 5, 8);
        fe.mk("item-8", 5, 10);

        fe.mk("bloco vermelho movel", 1, 1);
        fe.mk("Bloco Vermelho Movel", 1, 2);
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
