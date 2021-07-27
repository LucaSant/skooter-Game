package Modelo;


public abstract class Seta extends Elemento {

    protected int orientation;
    protected boolean waitedframe;
   
    protected Seta(int linha, int coluna, String label) {
        super("seta-"+label+".png");
        this.setPosicao(linha, coluna);
        this.setLabel("seta;"+label);
        this.bTransponivel = false;
        this.waitedframe = false;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }

    public abstract void movimentoSeta(Hero h);

    public int getOrientation() {
        return orientation;
    }

    public void setOrientation(int orientation) {
        this.orientation = orientation;
    }

    public boolean isWaitedframe() {
        return waitedframe;
    }

    public void setWaitedframe(boolean waitedframe) {
        this.waitedframe = waitedframe;
    }
}