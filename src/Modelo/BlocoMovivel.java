package Modelo;

public class BlocoMovivel extends Elemento{

    public BlocoMovivel(String img, int linha, int coluna) {
        super(img);
        this.setPosicao(linha, coluna);
        this.bEmpurravel = true;
        this.bQuebravel = true;
    }

    
    
    public void autoDesenho() {
        super.autoDesenho();
    }


}

