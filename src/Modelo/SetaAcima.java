package Modelo;


public class SetaAcima extends Seta {

    public SetaAcima(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 1;
        this.floor = "seta-acima.png";
    }
}