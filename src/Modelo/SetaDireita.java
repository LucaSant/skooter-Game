package Modelo;



public class SetaDireita extends Seta{

    public SetaDireita(int linha, int coluna) {
        super(linha, coluna);
        this.orientation = 3;
        this.floor = "seta-direita.png";
    }
}