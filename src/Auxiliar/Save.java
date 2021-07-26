package Auxiliar;

import Modelo.Elemento;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Save implements Serializable{
    
    public void SaveGame(ArrayList<Elemento> elem){
        try {
            File fAux = new File("saves/jogo-save.txt");
            if (fAux.exists()) {
                fAux.delete();
                fAux.createNewFile();
            }

            FileOutputStream pipeOut = new FileOutputStream(fAux);
            ObjectOutputStream serializador = new ObjectOutputStream(pipeOut);

            serializador.writeObject(elem);

            serializador.close();
            pipeOut.close();
            
        } catch (IOException exc) {
        }
    }
    
    public ArrayList<Elemento> readSave(){
        ArrayList<Elemento> elem = new ArrayList<Elemento>();
        try {
            File fAux = new File("saves/jogo-save.txt");
            if(fAux.exists()){
            
                FileInputStream pipeIn = new FileInputStream(fAux);
                ObjectInputStream deserializador = new ObjectInputStream(pipeIn);
                
                try {
                elem = (ArrayList<Elemento>) deserializador.readObject();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Save.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                pipeIn.close();
                deserializador.close();
            }
        }catch (IOException exc) {
            exc.printStackTrace();
        }
       return(elem);
    }
    
    public void deleteSave(){
        File fAux = new File("saves/jogo-save.txt");
            if (fAux.exists()) {
                fAux.delete();
            }
    }
    
    public boolean  saveExists(){
        File fAux = new File("saves/jogo-save.txt");
        return fAux.exists();
    }
}