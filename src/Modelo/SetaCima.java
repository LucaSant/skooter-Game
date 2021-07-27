package Modelo;


public class SetaCima extends Seta {

    public SetaCima(int linha, int coluna) {
        super(linha, coluna,"cima");
        this.orientation = 1;
    }
    
    
    @Override
    public void movimentoSeta(Hero h) {
       boolean f;
       if(this.isWaitedframe()){
            h.moveUp();
            h.setOrientation(1);
            this.setWaitedframe(false);
            f = false; 
        }else{
            f = true;
        }
         this.setWaitedframe(f);
       
    }
}