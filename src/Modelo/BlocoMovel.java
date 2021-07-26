package Modelo;

public class BlocoMovel extends Elemento{

    public BlocoMovel(String img, int linha, int coluna) {
        super(img);
        this.setPosicao(linha, coluna);
        this.bEmpurravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}