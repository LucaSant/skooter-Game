package Modelo;


public class BlocoVermelhoMovivel extends BlocoMovivel {
    
    public BlocoVermelhoMovivel(int linha, int coluna) {
        super("blocovermelholosango.png", linha, coluna);
        this.bTransponivel = false;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}