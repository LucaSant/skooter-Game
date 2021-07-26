package Auxiliar;

import Modelo.Elemento;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import static java.lang.Integer.parseInt;
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
    
    
    public int readFile(String s){
        int segundos = 60;
         try
        {
            File f = new File(s);
            if(!f.exists()){
                f.createNewFile();
            }
            FileInputStream inToFile = new FileInputStream(f);
            InputStreamReader in = new InputStreamReader(inToFile);
            BufferedReader bIn = new BufferedReader(in);
            
            String line = bIn.readLine();
            segundos = parseInt(line);
            
            inToFile.close();
            in.close();
            bIn.close();
        }catch (IOException ex)
            {
            ex.printStackTrace();
        }
         
         return segundos;
    }
}