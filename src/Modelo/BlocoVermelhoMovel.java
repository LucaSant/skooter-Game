package Modelo;

public class BlocoVermelhoMovel extends BlocoVermelho {
    
    public BlocoVermelhoMovel(int linha, int coluna) {
        super(linha, coluna);
        this.setImage("blocovermelholosango.png");
        this.bEmpurravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}