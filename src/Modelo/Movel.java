package Modelo;

public class Movel extends BlocoDecorator{

    public Movel(Bloco b) {
        b.setLabel(b.getLabel()+";movel");
        b.bEmpurravel = true;
    }
    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
    
}

