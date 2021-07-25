package Modelo;

public class BlocoVerde extends Bloco {
    
    public BlocoVerde(int linha, int coluna) {
        super("blocoverde.png", ";verde");
        this.setPosicao(linha, coluna);
        this.bQuebravel = true;
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
}