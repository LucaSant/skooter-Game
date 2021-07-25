
package Modelo;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;

/**
 *
 * @author lucas
 */
public class FactoryElemento {
    private ArrayList<Elemento> e;
    public FactoryElemento(ArrayList<Elemento> e) {
        this.e = e;
        
    }
    
    public void setHero(Hero hero, int linha, int coluna){
        e.add(hero);
        e.get(0).setPosicao(linha, coluna);
    }
    
    
    
    
    public void mk(String s, int linha, int coluna){
        s = s.toLowerCase();
        
        if(s.contains("bloco")){
            
            if(s.contains("verde")){
                BlocoVerde bv = new BlocoVerde(linha,coluna);
                e.add(this.blockFunctions(bv, s));
            }else if(s.contains("vermelho")){
                BlocoVermelho bv = new BlocoVermelho(linha,coluna);
                e.add(this.blockFunctions(bv, s));
            } 
        }
        
        
        if(s.contains("seta")){
            Chao t = new Chao(linha, coluna);
            e.add(this.carpetFunctions(t, s));  
        }
        
        if(s.contains("item")){
            String[] desc = s.split("-");
            int x = parseInt(desc[1], 10);
            Item item = new Item(linha, coluna);
            this.ItemTypeSelection(x, item);
            e.add(item);   
        }
        
        if(s.contains("vilao")){
            Vilao v = new Vilao(linha, coluna);
            e.add(v);
        }
    
    } 
        
       
    
    private Bloco blockFunctions(Bloco bv, String s){
        if(s.contains("movel")){
            Movel bvm = new Movel(bv);
            String path = bv.getImagepath();
            bv.setImagepath(path.substring(0, path.length() - 5) + "M.png");
            return bvm;
        }else {return bv;}
    }
    
    
    private Tapete carpetFunctions(Tapete tp, String s){
        Tapete seta;
        if(s.contains("cima")){
            seta = new SetaCima(tp);
        }else if(s.contains("baixo")){
            seta = new SetaBaixo(tp);
        }else if(s.contains("esquerda")){
            seta = new SetaEsquerda(tp);
        }else if(s.contains("direita")){
            seta = new SetaDireita(tp);
        }else{
            seta = (SetaCima) tp;
        }
        return seta;
    }
    
    public void ItemTypeSelection(int tipo, Item item){
        switch(tipo){
            case 1:
                item.setPontosEquiv(100);
                item.setImage("fita2.png");
                break;

            case 2:
                item.setPontosEquiv(150);
                item.setImage("rainbow.png");
                break;

            case 3:
                item.setPontosEquiv(200);
                item.setImage("magiccub.png");
                break;

            case 4:
                item.setPontosEquiv(250);
                item.setImage("gameboy.png");
                break;

            case 5: 
                item.setPontosEquiv(100);
                item.setImage("disquete.png");
                break;

            case 6: 
                item.setPontosEquiv(150);
                item.setImage("fita1.png");
                break;

            case 7: 
                item.setPontosEquiv(200);
                item.setImage("oculos3d.png");
                break;
            case 8:
                item.setPontosEquiv(300);
                item.setImage("som.png");
                break;
            
            case 9:
                item.setPontosEquiv(500);
                item.setImage("pacman.png");
                break;
            case 10:
                item.setPontosEquiv(0);
                item.setImage("transparente.png");
                break;
            default:
                item.setPontosEquiv(150);
                item.setImage("fruta.png");
                break;

        }
        
    }
}
