package Auxiliar;

import Modelo.*;

public class FazObjeto {
    public static void main(String[] args) {
        Save s = new Save();
        
        BlocoVermelho bv = new BlocoVermelho(0,0);
        s.createFile("bl_vermelho.txt", bv);
        
        BlocoVermelhoMovel bvm = new BlocoVermelhoMovel(0,0);
        s.createFile("bl_vermelho_movel.txt", bvm);
        
        BlocoVerde bvv = new BlocoVerde(0,0);
        s.createFile("bl_verde.txt", bvv);
        
        BlocoVerdeMovel bvvm = new BlocoVerdeMovel(0,0);
        s.createFile("bl_verde_movel.txt", bvvm);
        
        SetaCima sc = new SetaCima(0,0);
        s.createFile("seta_cima.txt", sc);
        
        SetaBaixo sb = new SetaBaixo(0,0);
        s.createFile("seta_baixo.txt", sb);
        
        SetaEsquerda se = new SetaEsquerda(0,0);
        s.createFile("seta_esquerda.txt", se);
        
        SetaDireita sd = new SetaDireita(0,0);
        s.createFile("seta_direita.txt", sd);
        
        Bomba bb = new Bomba(0,0);
        s.createFile("bomba.txt", bb);
        
        Portal p = new Portal(0,0);
        s.createFile("portal.txt", p);
    }
}
