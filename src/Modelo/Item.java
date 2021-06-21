package Modelo;

public class Item extends Elemento{
    private int pontosEquiv;

    public Item(int linha, int coluna, int pontos) {
        super("fruta.png");
        this.setPosicao(linha, coluna);
        this.pontosEquiv = pontos;
        this.bItem = true;
        this.bTransponivel = true;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public int getPontosEquiv() {
        return pontosEquiv;
    }

    public void setPontosEquiv(int pontosEquiv) {
        this.pontosEquiv = pontosEquiv;
    }
}