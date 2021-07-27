package Modelo;

public class SetaBaixo extends Seta {

    public SetaBaixo(int linha, int coluna) {
        super(linha, coluna,"baixo");
        this.orientation = 0;
    }

    @Override
    public void movimentoSeta(Hero h) {
        boolean f;
        if(this.isWaitedframe()){
            h.moveDown();
            h.setOrientation(0);
            f = false; 
        }else{
            f = true;
        }
         this.setWaitedframe(f);
       
    }
    
    
}