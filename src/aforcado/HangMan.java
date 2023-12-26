/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

import java.util.ArrayList;

/**
 * Esta clase implementa todo o estado dunha partida ao aforcado. Manterá unha
 * referencia a un obxecto da clase HiddenWord coa palabra oculta a adiviñar, e
 * tamén irá almacenando as letras introducidas polo usuario que non estean na
 * palabra, para irllas mostrando e que non as introduza de novo.
 *
 * @author Abel Iglesias Moure
 */
public class HangMan {

    /**
     * O número máximo de fallos que pode cometer o xogador.
     */
    public static final int MAX_FAILS = 6;
    
    // Obxecto da clase HiddenWord coa palabra a adiviñar no xogo.
    private HiddenWord hiddenWord;
    
    // ArrayList de caracteres no que se van almacenando as letras introducidas polo usuario
    private ArrayList<Character> fails;

    public HiddenWord getHiddenWord() {
        return hiddenWord;
    }

    public void setHiddenWord(HiddenWord hiddenWord) {
        this.hiddenWord = hiddenWord;
    }
    
    /**
     * Obtén a lista de caracteres fallados acumulados na partida.
     * @return a lista de caracteres fallados da partida.
     */
    public ArrayList<Character> getFails(){
        return fails;
    }

    /**
     * O construtor da clase. 
     * @param word a palabra a adiviñar.
     */
    public HangMan(String word) {
        hiddenWord = new HiddenWord(word);
        fails = new ArrayList<>();
    }

    /**
     * Obtén un String coa lista de caracteres fallados acumulados, 
     * separados por espazos en branco.
     * @return a lista de caracteres fallados, separados por espazos en branco.
     */
    public String getStringFails(){
        
        String word = "";        
        
        for (int i = 0; i < fails.size(); i++) {
                word+=fails.get(i) + " ";
        }
        
        return word;        
    }
    
    /**
     * Devolve a palabra oculta pero poñendo un guión nas letras non acertadas.
     * @return a palabra oculta con un guión nas letras non acertadas.
     */
    public String showHiddenWord(){
        
        return hiddenWord.show();
        
    }
    
    /**
     * Devolve a palabra oculta mostrando todas as súas letras.
     * @return a palabra oculta mostrando todas as súas letras.
     */
    public String showFullWord(){
        
        return hiddenWord.showFullWord();
        
    }
    
    /**
     * Proba a ver se o caracter indicado forma parte da palabra oculta.
     * Se está, márcanse todas as súas aparicións como letras acertadas; 
     * se non está  engádese o caracter na lista de fallos acumulados na partida.
     * 
     * @param c o caracter a validar.
     */
    public void tryChar(char c){
        if (!hiddenWord.checkChar(c)) {
            fails.add(c);
        }
    }
    
    /**
     * Comproba se rematou a partida, 
     * ben porque se chegou ao límite de fallos 
     * ou ben porque se adiviñou toda a palabra oculta.
     * 
     * @return true se a partida terminou.
     */
    public boolean isGameOver(){
        
        return maxFailsExceeded() || hiddenWord.isVisible();
        
    }
    
    /**
     * Comproba se se chegou ao límite de fallos permitidos.
     * @return true se o usuario chegou ao límite de fallos permitidos.
     */
    public boolean maxFailsExceeded(){
        
        return fails.size() == MAX_FAILS;
        
    }

}
