/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

import java.util.ArrayList;

/**
 * Esta clase implementa todo o estado dunha partida ao aforcado. Manter� unha
 * referencia a un obxecto da clase HiddenWord coa palabra oculta a adivi�ar, e
 * tam�n ir� almacenando as letras introducidas polo usuario que non estean na
 * palabra, para irllas mostrando e que non as introduza de novo.
 *
 * @author Abel Iglesias Moure
 */
public class HangMan {

    /**
     * O n�mero m�ximo de fallos que pode cometer o xogador.
     */
    public static final int MAX_FAILS = 6;
    
    // Obxecto da clase HiddenWord coa palabra a adivi�ar no xogo.
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
     * Obt�n a lista de caracteres fallados acumulados na partida.
     * @return a lista de caracteres fallados da partida.
     */
    public ArrayList<Character> getFails(){
        return fails;
    }

    /**
     * O construtor da clase. 
     * @param word a palabra a adivi�ar.
     */
    public HangMan(String word) {
        hiddenWord = new HiddenWord(word);
        fails = new ArrayList<>();
    }

    /**
     * Obt�n un String coa lista de caracteres fallados acumulados, 
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
     * Devolve a palabra oculta pero po�endo un gui�n nas letras non acertadas.
     * @return a palabra oculta con un gui�n nas letras non acertadas.
     */
    public String showHiddenWord(){
        
        return hiddenWord.show();
        
    }
    
    /**
     * Devolve a palabra oculta mostrando todas as s�as letras.
     * @return a palabra oculta mostrando todas as s�as letras.
     */
    public String showFullWord(){
        
        return hiddenWord.showFullWord();
        
    }
    
    /**
     * Proba a ver se o caracter indicado forma parte da palabra oculta.
     * Se est�, m�rcanse todas as s�as aparici�ns como letras acertadas; 
     * se non est�  eng�dese o caracter na lista de fallos acumulados na partida.
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
     * ben porque se chegou ao l�mite de fallos 
     * ou ben porque se adivi�ou toda a palabra oculta.
     * 
     * @return true se a partida terminou.
     */
    public boolean isGameOver(){
        
        return maxFailsExceeded() || hiddenWord.isVisible();
        
    }
    
    /**
     * Comproba se se chegou ao l�mite de fallos permitidos.
     * @return true se o usuario chegou ao l�mite de fallos permitidos.
     */
    public boolean maxFailsExceeded(){
        
        return fails.size() == MAX_FAILS;
        
    }

}
