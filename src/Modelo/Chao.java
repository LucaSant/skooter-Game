package Modelo;

public class Chao extends Tapete{

    protected Chao(int linha, int coluna) {
        super("transparente.png", "");
        this.setPosicao(linha, coluna);
        this.bSeta = true;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

    @Override
    public void action(Hero hHero) {
        System.out.println("Passou pelo tapete");
    }
}
