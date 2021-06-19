package Modelo;

public class Vilao extends Elemento {
    
    public Vilao(int linha, int coluna) {
        super("vilao.png");
        this.setPosicao(linha, coluna);
        this.bMortal = true;
        this.bTransponivel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}