
package Modelo;

/**
 *
 * @author lucas
 */
public abstract class BlocoDecorator extends Bloco{
    protected Bloco b;

    public BlocoDecorator(Bloco bloco) {
        this.b = bloco;
    }

    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
   
    
}
