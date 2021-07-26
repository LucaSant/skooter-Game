package Modelo;

public class Item extends Elemento{
    private int setPontosEquiv;

    public Item(int linha, int coluna) {
        super("");
        this.setPosicao(linha, coluna);
        this.setLabel("item");
        this.bTransponivel = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

    public int getPontosEquiv() {
        return setPontosEquiv;
    }

    public void setPontosEquiv(int pontosEquiv) {
        this.setPontosEquiv = pontosEquiv;
    }

}