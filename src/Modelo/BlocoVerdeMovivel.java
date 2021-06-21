package Modelo;


public class BlocoVerdeMovivel extends BlocoMovivel {
    
    public BlocoVerdeMovivel(int linha, int coluna) {
        super("blocoverdelosango.png", linha, coluna);
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}