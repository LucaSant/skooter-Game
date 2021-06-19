package Modelo;

public class Seta extends Elemento {

    protected int orientacion;
    protected String floor;
   
   
    protected Seta(int linha, int coluna) {
        super("transparente.png");
        this.setPosicao(linha, coluna);
        this.bSeta = true;
        this.bTransponivel = false;
    }

    public void autoDesenho() {
        super.autoDesenho();
    }

    public boolean isbSeta() {
        return bSeta;
    }

    public void setbSeta(boolean bSeta) {
        this.bSeta = bSeta;
    }

    public int getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(int orientacion) {
        this.orientacion = orientacion;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }


    
}
