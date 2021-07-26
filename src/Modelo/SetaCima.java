package Modelo;


public class SetaCima extends Seta {

    public SetaCima(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 1;
        this.floor = "seta-acima.png";
    }
}