/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatortrue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jorge
 */
public class TranslatorTrue {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String s=""; 
        
        //DATA BASE 
        
        Translator tired=new Translator("tired", "cansado");
        Translator really=new Translator("really", "demasiado");
        Translator I=new Translator("I", "Yo");
        Translator am=new Translator("am", "estoy");
        
        
        ArrayList<String[]> textToTranslate=new ArrayList<>();
        ArrayList<Translator> translations=new ArrayList<>();
        translations.add(tired);
        translations.add(really);
        translations.add(I);
        translations.add(am);
        
        System.out.println("Which word do you want to translate?");
        
        try {
            System.out.println("Insert the text you want to translate");
            s=br.readLine();
            String[] line=s.split(" ");
            int c=0;
            
            for(int i=0; i<translations.size(); i++){              
                if(line[c].equals(translations.get(i).getOriginalWord()))
                    System.out.print(translations.get(i).getSpanishWord()+" ");
                    c++;                    
                }
                
            
            
            
            
            
            
            
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(TranslatorTrue.class.getName()).log(Level.SEVERE, null, ex);
        }
         
        
        
        
        
        
    }           
}
