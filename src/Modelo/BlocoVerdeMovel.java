package Modelo;

public class BlocoVerdeMovel extends BlocoMovel {
    
    public BlocoVerdeMovel(int linha, int coluna) {
        super("blocoverdelosango.png", linha, coluna);
        this.bQuebravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}