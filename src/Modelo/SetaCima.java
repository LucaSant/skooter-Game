package Modelo;

public class SetaCima extends TapeteDecorator {

    public SetaCima(Tapete tap) {
        super(tap);
        t.floor = "seta-acima.png";
        t.setLabel(t.getLabel()+";seta;cima");
    }

    @Override
    public void action(Hero h) {
       if(t.isWaitedframe()){
            h.moveUp();
            h.setOrientation(1);
            t.setWaitedframe(false);
       }
       t.setWaitedframe(true);
       t.action(h);
    }
}

