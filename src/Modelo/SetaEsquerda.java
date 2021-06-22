package Modelo;


public class SetaEsquerda extends Seta{

    public SetaEsquerda(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 2;
        this.floor = "seta-esquerda.png";
    }
}