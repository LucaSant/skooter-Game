/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author lucas
 */
public abstract class Bloco extends Elemento{

    public Bloco(String sNomeImagePNG, String label) {
        super(sNomeImagePNG, "bloco"+label);
    }
   

    
    @Override
    public void autoDesenho() {
        super.autoDesenho();
    }
    
    
}
