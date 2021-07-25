package Modelo;

public class SetaDireita extends TapeteDecorator{

    public SetaDireita(Tapete tap) {
        super(tap);
        t.floor = "seta-direita.png";
        t.setLabel(t.getLabel()+";seta;direita");
    }
    
    @Override
    public void action(Hero h) {
       if(t.isWaitedframe()){
            h.moveRight();
            h.setOrientation(3);
            t.setWaitedframe(false);
       }
       t.setWaitedframe(true);
       t.action(h);
    } 
    
}