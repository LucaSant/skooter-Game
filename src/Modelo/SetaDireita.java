package Modelo;



public class SetaDireita extends Seta{

    public SetaDireita(int linha, int coluna) {
        super(linha, coluna,"direita");
        this.orientation = 3;
        this.floor = "seta-direita.png";
    }
    
     @Override
    public void movimentoSeta(Hero h) {
        boolean f;
        if(this.isWaitedframe()){
            h.moveRight();
            h.setOrientation(3);
            this.setWaitedframe(false);
            f = false; 
        }else{
            f = true;
        }
        this.setWaitedframe(f);

    }
}