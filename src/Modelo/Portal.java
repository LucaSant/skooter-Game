/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class Portal extends Elemento{
    private Portal p;
    
    
    public Portal(int linha, int coluna){
        super("portal.png");
        this.setPosicao(linha, coluna);
        this.label = "portal";
        this.bTransponivel = true;
    }
    
    public Portal(int linha, int coluna, Portal portal){
        super("portal.png");
        this.setPosicao(linha, coluna);
        this.label = "portal";
        this.bTransponivel = true;
        portal.setLabel(portal.getLabel()+";pareado");
        this.setLabel(this.getLabel()+";pareado");
        portal.setP(this);
        this.setP(portal);
    }
    
    public void match(ArrayList<Elemento> e){
        if(!this.getLabel().contains("pareado")){
            for(int i = 5; i < e.size(); i++){
                if(!e.get(i).getPosicao().equals(this.getPosicao()))
                    if((e.get(i).getLabel().contains("portal")) && (!e.get(i).getLabel().contains("pareado"))){
                        e.get(i).setLabel(e.get(i).getLabel()+";pareado");
                        this.setLabel(this.getLabel()+";pareado");
                        ((Portal) e.get(i)).setP(this);
                        this.setP((Portal) e.get(i));
                    }
            }
        } 
    }
    
    public void movimentoPortal(Hero h){
        if(this.getLabel().contains("pareado")){
            if((h.getPosicao().getLinhaAnterior() != p.getPosicao().getLinha()) && (h.getPosicao().getColunaAnterior() != p.getPosicao().getColuna())){
                    h.getPosicao().setPosicao(p.getPosicao());
            }
        }
    }

    public Portal getP() {
        return p;
    }

    public void setP(Portal p) {
        this.p = p;
    }
    
    
}
