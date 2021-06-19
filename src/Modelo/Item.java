package Modelo;

public class Item extends Elemento{

    public Item(int linha, int coluna) {
        super("fruta.png");
        this.setPosicao(linha, coluna);
        this.bItem = true;
        this.bTransponivel = true;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }
}