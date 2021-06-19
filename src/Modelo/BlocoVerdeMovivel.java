package Modelo;


public class BlocoVerdeMovivel extends Elemento {
    
    public BlocoVerdeMovivel(int linha, int coluna) {
        super("blocoverdelosango.png");
        this.setPosicao(linha, coluna);
        this.bEmpurravel = true;
        this.bQuebravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}