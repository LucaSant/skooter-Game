package Modelo;

public class SetaBaixo extends Seta {

    public SetaBaixo(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 0;
        this.floor = "seta-abaixo.png";
    }
}