package Modelo;

public abstract class Bloco extends Elemento{

    public Bloco(String sNomeImagePNG, String label) {
        super(sNomeImagePNG, "bloco"+label);
    }
   
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
    
    
}
