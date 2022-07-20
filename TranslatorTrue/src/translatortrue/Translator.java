/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package translatortrue;

/**
 *
 * @author jorge
 */
public class Translator {
    String originalWord;   
    String spanishWord;
    
    public Translator(String w, String s){
        this.originalWord=w;
        this.spanishWord=s;
    }

    public String getOriginalWord() {
        return originalWord;
    }

    public void setOriginalWord(String originalWord) {
        this.originalWord = originalWord;
    }

    public String getSpanishWord() {
        return spanishWord;
    }

    public void setSpanishWord(String spanishWord) {
        this.spanishWord = spanishWord;
    }
    
}
