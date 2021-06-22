package Modelo;



public class SetaAbaixo extends Seta {

    public SetaAbaixo(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 0;
        this.floor = "seta-abaixo.png";
    }
}