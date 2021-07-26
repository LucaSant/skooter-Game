package Modelo;

public class BlocoVermelhoMovel extends BlocoMovel {
    
    public BlocoVermelhoMovel(int linha, int coluna) {
        super("blocovermelholosango.png", linha, coluna);
        this.bTransponivel = false;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}