package Modelo;


public class BlocoVermelho extends Bloco {
    
    public BlocoVermelho(int linha, int coluna) {
        super("blocovermelho.png",";vermelho");
        this.setPosicao(linha, coluna);
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}
