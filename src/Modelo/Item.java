package Modelo;

public class Item extends Elemento{
    private int pontosEquiv;

    public Item(int linha, int coluna, int tipo) {
        super("fruta.png");
        this.selecionaTipo(tipo);
        this.setPosicao(linha, coluna);
        this.bItem = true;
        this.bTransponivel = true;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public int getPontosEquiv() {
        return pontosEquiv;
    }
   
    public void selecionaTipo(int tipo){
        switch(tipo){
            case 1:
                this.pontosEquiv = 100;
                this.setImage("fita2.png");
                break;

            case 2:
                this.pontosEquiv = 150;
                this.setImage("rainbow.png");
                break;

            case 3:
                this.pontosEquiv = 200;
                this.setImage("magiccub.png");
                break;

            case 4:
                this.pontosEquiv = 250;
                this.setImage("gameboy.png");
                break;

            case 5: 
                this.pontosEquiv = 100;
                this.setImage("disquete.png");
                break;

            case 6: 
                this.pontosEquiv = 150;
                this.setImage("fita1.png");
                break;

            case 7: 
                this.pontosEquiv = 200;
                this.setImage("oculos3d.png");
                break;
            case 8:
                this.pontosEquiv = 300;
                this.setImage("som.png");
                break;
            
            case 9:
                this.pontosEquiv = 500;
                this.setImage("pacman.png");
                break;
            case 10:
                this.pontosEquiv = 0;
                this.setImage("transparente.png");
            default:
                this.pontosEquiv = 150;
                super.setImage("fruta.png");
                break;

        }
        
    }

}