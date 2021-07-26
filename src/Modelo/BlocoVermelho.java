package Modelo;

public class BlocoVermelho extends Elemento {
    
    public BlocoVermelho(int linha, int coluna) {
        super("blocovermelho.png");
        this.setPosicao(linha, coluna);
        this.setLabel("bloco;vermelho");
        this.bTransponivel = false;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}