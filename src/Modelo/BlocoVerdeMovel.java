package Modelo;

public class BlocoVerdeMovel extends BlocoVerde {
    
    public BlocoVerdeMovel(int linha, int coluna) {
        super(linha, coluna);
        this.setImage("blocoverdelosango.png");
        this.setLabel("bloco;verde;movel");
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}