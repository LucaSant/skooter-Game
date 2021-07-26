package Modelo;

public class BlocoVerdeMovel extends BlocoVerde {
    
    public BlocoVerdeMovel(int linha, int coluna) {
        super(linha, coluna);
        this.setImage("blocoverdelosango.png");
        this.bEmpurravel = true;
    }
    
    public void autoDesenho() {
        super.autoDesenho();
    }
}