package Modelo;


public class BlocoVerdeMovivel extends BlocoMovivel {
    
    public BlocoVerdeMovivel(int linha, int coluna) {
        super("blocoverdelosango.png", linha, coluna);
        this.bQuebravel = true;

    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}