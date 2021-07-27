package Modelo;

import static java.lang.Integer.parseInt;
import java.util.ArrayList;

public class FactoryElemento {
    private ArrayList<Elemento> e;
    public FactoryElemento(ArrayList<Elemento> e) {
        this.e = e;
    }
    
    public FactoryElemento(){
        
    }
    
    public void setHero(Hero hero, int linha, int coluna){
        e.add(hero);
        e.get(0).setPosicao(linha, coluna);
    }
    
    public void mk(String s, int linha, int coluna){
        s = s.toLowerCase();
        
        if(s.contains("bloco")){
            if(s.contains("verde")){
                if(s.contains("movel")){
                    e.add(new BlocoVerdeMovel(linha, coluna));
                }else{
                    e.add(new BlocoVerde(linha, coluna));
                }
            }else if(s.contains("vermelho")){
               if(s.contains("movel")){
                    e.add(new BlocoVermelhoMovel(linha, coluna));
                }else{
                    e.add(new BlocoVermelho(linha, coluna));
                }
            } 
        }
        
        if(s.contains("seta"))
            e.add(this.carpetFunctions(s, linha, coluna));
        
        if(s.contains("item")){
            String[] desc = s.split("-");
            Item item = new Item(linha, coluna);
            
            if(desc.length > 1){
                int x = parseInt(desc[1], 10);
                this.ItemTypeSelection(x, item);
            }else{
                this.ItemTypeSelection(1, item);   
            }
            e.add(item);   
        }
        
        if(s.contains("vilao")){
            Vilao v = new Vilao(linha, coluna);
            e.add(v);
        }
        
        if(s.contains("portal")){
            Portal p = new Portal(linha, coluna);
            p.match(e);
            e.add(p);
        }
    }
    
   
        
    private Seta carpetFunctions(String s, int linha, int coluna){
        if(s.contains("cima")){
            return  new SetaCima(linha, coluna);
        }else if(s.contains("baixo")){
            return  new SetaBaixo(linha, coluna);
        }else if(s.contains("esquerda")){
            return new SetaEsquerda(linha, coluna);
        }else if(s.contains("direita")){
            return new SetaDireita(linha, coluna);
        }else{
            return new SetaCima(linha, coluna);
        }
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