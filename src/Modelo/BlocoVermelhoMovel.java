package Modelo;

public class BlocoVermelhoMovel extends BlocoVermelho {
    
    public BlocoVermelhoMovel(int linha, int coluna) {
        super(linha, coluna);
        this.setImage("blocovermelholosango.png");
        this.setLabel("bloco;vermelho;movel");
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}