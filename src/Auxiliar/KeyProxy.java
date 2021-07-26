package Auxiliar;

import java.awt.event.KeyEvent;
import Controler.Tela;
import java.util.ArrayList;

public class KeyProxy {
    
    Tela tela;

    public KeyProxy(Tela tela) {
        this.tela = tela;
    }
    
    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if(tela.getHero().canMove() == true){
            tela.getHero().setCanMove(false);
            
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                tela.getHero().moveUp();
                tela.getControle().movimentoEmpurravel(tela.getElementos(), tela.getHero().getPosicao());
                tela.getHero().setOrientation(1);

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                tela.getHero().moveDown();
                tela.getControle().movimentoEmpurravel(tela.getElementos(), tela.getHero().getPosicao());
                tela.getHero().setOrientation(0);

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                tela.getHero().moveLeft();
                tela.getControle().movimentoEmpurravel(tela.getElementos(), tela.getHero().getPosicao());
                tela.getHero().setOrientation(2);

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                tela.getHero().moveRight();
                tela.getControle().movimentoEmpurravel(tela.getElementos(), tela.getHero().getPosicao());
                tela.getHero().setOrientation(3);

            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(tela.getControle().getFase().getnFase() == 0){
                        tela.getSave().deleteSave();
                        tela.getControle().beginGame(tela.getElementos(), tela.getHero(), tela.getSave());
                    }else{
                        tela.getHero().quebrarBloco(tela.getElementos());
                        tela.getHero().setCanMove(true);
                    }
            } else if (e.getKeyCode() == KeyEvent.VK_Z){
                if(tela.getControle().getFase().getnFase() == tela.getControle().getLastFase()) {
                    tela.getHero().setCollectedItens(0);
                    tela.getHero().setLives(0);
                    tela.getHero().setPontos(3);
                    tela.getHero().setFase(0);
                    tela.getHero().setImage("heroi-0.png");
                    tela.getSave().deleteSave();
                    tela.getControle().beginGame(tela.getElementos(), tela.getHero(), tela.getSave());
                    
                }else{
                    tela.getControle().setFase(tela.getControle().getFase().getnFase()); 
                    tela.getHero().setFase(tela.getControle().getFase().getnFase() - 1);
                    tela.getHero().setCollectedItens(0);                          
                    tela.getControle().getFase().setAllElementos(tela.getElementos(), tela.getHero());
                }
            } else if(e.getKeyCode() == KeyEvent.VK_S){
                if(tela.getControle().getFase().getnFase() == 0){
                    if(tela.getSave().saveExists()){
                       tela.getControle().beginGame(tela.getElementos(), tela.getHero(), tela.getSave()); 
                    }else{
                        System.out.println("Não há jogo salvo. Por favor aperte 'Enter'");
                    }
                    
                }else{
                    tela.getSave().SaveGame(tela.getElementos());
                    System.out.println("Jogo salvo s");
                }
            }
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!tela.getControle().ehPosicaoValida(tela.getElementos(),tela.getHero().getPosicao())) {
            tela.getHero().voltaAUltimaPosicao();
        }

        tela.setTitle("-> Cell: " + (tela.getHero().getPosicao().getColuna()) + ", " 
                + (tela.getHero().getPosicao().getLinha()) + "Fase: " + tela.getControle().getFase().getnFase() 
                +  "/ Vidas " + tela.getHero().getLives() + "  / Pontos:  " +  tela.getHero().getPontos());
    }
}
