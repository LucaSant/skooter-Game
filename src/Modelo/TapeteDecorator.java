package Modelo;

public abstract class TapeteDecorator extends Tapete {
    protected Tapete t;
    protected boolean waitedframe;
    
    public TapeteDecorator(Tapete tapete){
        this.t = tapete;
    }

    @Override
    public abstract void action(Hero hHero);
}
