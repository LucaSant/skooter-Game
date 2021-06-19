package Modelo;


public class BlocoVermelhoMovivel extends Elemento {
    
    public BlocoVermelhoMovivel(int linha, int coluna) {
        super("blocovermelholosango.png");
        this.setPosicao(linha, coluna);
        this.bTransponivel = false;
        this.bEmpurravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}