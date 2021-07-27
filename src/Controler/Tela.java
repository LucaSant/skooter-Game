package Controler;

import Modelo.*;
import Auxiliar.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import static java.lang.Math.floor;
import java.util.*;
import java.util.logging.*;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Tela extends javax.swing.JFrame implements MouseListener, KeyListener {

    private Hero hHero;
    private ArrayList<Elemento> eElementos;
    private ControleDeJogo cControle = new ControleDeJogo();
    private Graphics g2;
    private Save save;
    private KeyProxy kp = new KeyProxy(this);

    public Tela() {
        Desenhador.setCenario(this); /*Desenhador funciona no modo estatico*/
        initComponents();
        this.addKeyListener(this);   /*teclado*/
        this.addMouseListener(this); /*mouse*/
        
        /*Cria a janela do tamanho do cenario + insets (bordas) da janela*/
        this.setSize(Consts.RES * Consts.CELL_SIDE + getInsets().left + getInsets().right,
                Consts.RES * Consts.CELL_SIDE + getInsets().top + getInsets().bottom);

        hHero = Hero.getHero();
        hHero.setCollectedItens(0);
        hHero.setLives(3);

        eElementos = new ArrayList<Elemento>(100);
        save =  new Save();
        this.AutoSave();
    }

    public void removeElemento(Elemento umElemento) { //exclusivo da classe Tela, os elementos da fase são o estado inicial, não podendo excluir elementos
        eElementos.remove(umElemento);
    }

    public Graphics getGraphicsBuffer(){
        return g2;
    }
    
    public void AutoSave(){
    new Thread() {
        public void run() {
            while(true){
                
              if(cControle.getFase().getnFase() >  0) {
                  save.SaveGame(eElementos);
                  System.out.println("auto save ...");
              }
              
              try {
                Thread.sleep(save.readFile("saves/saveconfig.txt") * 1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
      }.start();
    }
    
    // Este metodo eh executado a cada Consts.FRAME_INTERVAL milissegundos    
    public void paint(Graphics gOld) {
        Graphics g = this.getBufferStrategy().getDrawGraphics();
        // Criamos um contexto gráfico
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
        // Desenha cenário
        for (int i = 0; i < res; i++) {
            for (int j = 0; j < res; j++) {
                try {
                    //Linha para alterar o background
                    String bg =  cControle.getFase().getBackground();
                    Image newImage = Toolkit.getDefaultToolkit().getImage(new java.io.File(".").getCanonicalPath() + Consts.PATH + bg); 
                    g2.drawImage(newImage,j*cell_side, i*cell_side, cell_side, cell_side, null);
                } catch (IOException ex) {
                    Logger.getLogger(Tela.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        
        //Aqui podem ser inseridos novos processamentos de controle
        if (!this.eElementos.isEmpty()) {
            this.cControle.desenhaTudo(eElementos);
            this.cControle.processaTudo(eElementos);
            this.cControle.heroMoveHabilitation(hHero); // checa se ele pode se mover
            this.cControle.checkLives(eElementos, save); // checa a vida do heroi
            this.cControle.nextFase(eElementos, save); // checa se pode ir para a próxima fase
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
                repaint(); // Executa o metodo paint
            }
        };        
        
        //Redesenha (executa o metodo paint) tudo a cada Consts.FRAME_INTERVAL milissegundos
        Timer timer = new Timer();
        timer.schedule(redesenhar, 0, Consts.FRAME_INTERVAL);
    }
    
    public void keyPressed(KeyEvent e) {
        kp.keyPressed(e);
    }
    
    public void mousePressed(MouseEvent e) {
         int x = e.getX()-8;
         int y = e.getY()-31;
         Posicao p = new Posicao((int) floor(y/Consts.CELL_SIDE), (int) floor(x/Consts.CELL_SIDE));
         if (e.getModifiers() == MouseEvent.BUTTON3_MASK && e.getClickCount() == 1) {
            for(int i = 1; i < eElementos.size(); i++){
                if(eElementos.get(i).getPosicao().estaNaMesmaPosicao(p)){
                    //Nao queremos que se possa substituir viloes ou itens pois isso quebra a logica do jogo
                    if(!(eElementos.get(i).getLabel().contains("vilao")) && !(eElementos.get(i).getLabel().contains("item"))) {
                        //Criacao do filechooser para escolher o objeto serializado e coloca-lo no lugar do selecionado
                        JFileChooser fc = new JFileChooser();
                        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.txt","txt");
                        fc.setFileFilter(filtro);

                        fc.setCurrentDirectory(new File("."+ File.separator + "objetos"));
                        int resp = fc.showOpenDialog(new JDialog());
                        File fObj = new File("");

                        if(resp == JFileChooser.APPROVE_OPTION){
                            fObj = fc.getSelectedFile();
                            Elemento obj = save.readFile(fObj);
                            obj.setPosicao(eElementos.get(i).getPosicao());
                            eElementos.set(i, obj);
                            break;
                        }
                        else if(resp == JFileChooser.CANCEL_OPTION){
                            JOptionPane.showMessageDialog(null, "Cancelado");
                        }
                    }
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    //@SuppressWarnings("unchecked")
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

    public void keyTyped(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }
    
    public Hero getHero() {
        return hHero;
    }

    public ArrayList<Elemento> getElementos() {
        return eElementos;
    }

    public ControleDeJogo getControle() {
        return cControle;
    }

    public Save getSave() {
        return save;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}