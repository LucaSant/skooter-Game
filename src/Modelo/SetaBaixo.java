package Modelo;

public class SetaBaixo extends TapeteDecorator {

    public SetaBaixo(Tapete tap) {
        super(tap);
        t.floor = "seta-abaixo.png";
        t.setLabel(t.getLabel()+";seta;baixo");   
    }
    
    @Override
    public void action(Hero h) {
       if(t.isWaitedframe()){
            h.moveDown();
            h.setOrientation(0);
            t.setWaitedframe(false);
       }
       t.setWaitedframe(true);
       t.action(h);
    }
}