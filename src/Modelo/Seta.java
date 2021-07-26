package Modelo;


public abstract class Seta extends Elemento {

    protected int orientation;
    protected String floor;
    protected boolean waitedframe;
   
    protected Seta(int linha, int coluna, String label) {
        super("transparente.png");
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

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public boolean isWaitedframe() {
        return waitedframe;
    }

    public void setWaitedframe(boolean waitedframe) {
        this.waitedframe = waitedframe;
    }
}