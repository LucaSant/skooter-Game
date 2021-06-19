package Modelo;


public class BlocoVerde extends Elemento {
    
    public BlocoVerde(int linha, int coluna) {
        super("blocoverde.png");
        this.setPosicao(linha, coluna);
        this.bQuebravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}