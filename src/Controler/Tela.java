package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.logging.*;
import java.util.zip.*;
import javax.swing.text.Position;
import Fases.TelaInicial;

/**
 *
 * @author junio
 */
public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;

    /**
     * Creates new form
     */
    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
 
        this.addMouseListener(this); /*mouse*/
        this.addKeyListener(this);   /*teclado*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        /*

        eElements = cControle.getFase().getElem();
        hHero = eElements.get(0);
        */
        hHero = new Hero(0,0);
        hHero.setCollectedItens(0);
        hHero.setLives(3);

        /*Este array vai guardar os elementos graficos*/
        eElementos = new ArrayList<Elemento>(100);
        //cControle.getFase().setAllElementos(eElementos, hHero);
    }

    public void removeElemento(Elemento umElemento) { //exclusivo da classe Tela, os elementos da fase são o estado inicial, não podendo excluir elementos
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    /*Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos*/    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        /*Criamos um contexto gráfico*/
        g2 = g.create(getInsets().left, getInsets().top, getWidth() - getInsets().right, getHeight() - getInsets().top);
        Fase f = this.cControle.getFase();
        int res, cell_side;
        if(f.getnFase() == 0){
            res = 1;
            cell_side = 605;
        }else{
            res = Consts.RES;
            cell_side = Consts.CELL_SIDE;
        }
        /*Desenha cenário*/
        for (int i = 0; i < res; i++) {
            for (int j = 0; j < res; j++) {
                try {
                    /*Linha para alterar o background*/
                    String bg =  cControle.getFase().getBackground();
                    Posicao p = new Posicao (i, j);
                    for(int k = 0; k < eElementos.size(); k++){
                        if((p.estaNaMesmaPosicao(eElementos.get(k).getPosicao())) && (eElementos.get(k).isbSeta())){
                            Seta s = (Seta) eElementos.get(k);
                            bg = s.getFloor();
                        }
                    }
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + bg); 
                    g2.drawImage(newImage,j*cell_side, i*cell_side, cell_side, cell_side, null);

                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        /*Aqui podem ser inseridos novos processamentos de controle*/
        
        if (!this.eElementos.isEmpty()) {
            
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
            this.cControle.vilaoMoveHabilitation(eElementos);
            this.cControle.heroMoveHabilitation(hHero);
            this.cControle.checkLives(eElementos); //o processamento checa a vida do heroi
            this.cControle.nextFase(eElementos); // checa se pode ir para a próxima fase
        }

        g.dispose();
        g2.dispose();
        if (!getBufferStrategy().contentsLost()) {
            getBufferStrategy().show();
        }
    }

    public void go() {
        TimerTask redesenhar = new TimerTask() {
            public void run() {
                repaint(); /*(executa o metodo paint)*/
            }
        };        
        
        /*Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos*/
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }

    public void keyPressed(KeyEvent e) {
        /*Movimento do heroi via teclado*/
        if(hHero.canMove() == true){
            hHero.setCanMove(false);
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                hHero.moveUp();
                cControle.movimentoEmpurravel(eElementos, hHero.getPosicao());
                hHero.setOrientacion(1);

            } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                hHero.moveDown();
                cControle.movimentoEmpurravel(eElementos, hHero.getPosicao());
                hHero.setOrientacion(0);

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                hHero.moveLeft();
                cControle.movimentoEmpurravel(eElementos, hHero.getPosicao());
                hHero.setOrientacion(2);

            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                hHero.moveRight();
                cControle.movimentoEmpurravel(eElementos, hHero.getPosicao());
                hHero.setOrientacion(3);

            } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    if(cControle.getFase().getnFase() == 0){
                        cControle.beginGame(eElementos, hHero);
                    }else{
                        hHero.quebrarBloco(eElementos);
                        hHero.setCanMove(true);
                    }
                
            }
            
        }
        
        /*Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava*/
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }

        this.setTitle("-> Cell: " + (hHero.getPosicao().getColuna()) + ", " + (hHero.getPosicao().getLinha()) + "Fase: " + cControle.getFase().getnFase() +  "/ Vidas " + hHero.getLives() + "  / Pontos:  " +  hHero.getPontos());
    }
    
    /*public void mousePressed(MouseEvent e) {
         //Movimento via mouse
         int x = e.getX();
         int y = e.getY();
     
         this.setTitle("X: "+ x + ", Y: " + y +
         " -> Cell: " + (y/Consts.CELL_SIDE) + ", " + (x/Consts.CELL_SIDE));
        
         this.hHero.getPosicao().setPosicao(y/Consts.CELL_SIDE, x/Consts.CELL_SIDE);

        //Se o heroi for para uma posicao invalida, sobre um elemento intransponivel, volta para onde estava
        if (!cControle.ehPosicaoValida(this.eElementos,hHero.getPosicao())) {
            hHero.voltaAUltimaPosicao();
        }
        
        cControle.movimentoSeta(eElementos, hHero.getPosicao(), hHero);
        
        repaint();
    }*/

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("POO2021");
        setAutoRequestFocus(false);
        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 561, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mouseDragged(MouseEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
    /*
    public void procurarBlocoEmpurravel(ArrayList<Elemento> e, Posicao p) {
        Elemento eTemp;
        for (int i = 1; i < e.size(); i++) {
            eTemp = e.get(i);
            if (eTemp.getPosicao().estaNaMesmaPosicao(p)) {
                return i;
            }
        }
    }*/
}
