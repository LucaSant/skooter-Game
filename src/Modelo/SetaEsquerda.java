package Modelo;


public class SetaEsquerda extends Seta{

    public SetaEsquerda(int linha, int coluna) {
        super(linha, coluna, "esquerda");
        this.orientation = 2;
    }
    
    @Override
    public void movimentoSeta(Hero h) {
        boolean f;
        if(this.isWaitedframe()){
            h.moveLeft();
            h.setOrientation(2);
            this.setWaitedframe(false);
            f = false; 
        }else{
            f = true;
        }
        this.setWaitedframe(f);
       
    }
}