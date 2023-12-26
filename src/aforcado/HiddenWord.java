/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aforcado;

/**
 * Esta clase implementa a palabra a adiviñar coa que traballaremos no xogo, 
 * e resolverá todo o traballo de manter as letras acertadas, 
 * mostrar a palabra ocultando as letras non acertadas, 
 * e comprobar se unha letra forma parte da palabra.
 * 
 * @author Abel Iglesias Moure
 * @author Gabriel Julian Álvarez Gómez
 */
public class HiddenWord {
    
    //É un array de caracteres que almacena os caracteres da palabra.
    private char characters [];
    
    // É un array de booleans marcarán con true aqueles caracteres da palabra 
    //que están acertados e con false os que aínda non o están.
    private boolean hits [];

    /**
     * O construtor da clase que inicializa os dous arrays. 
     * @param word a palabra que imos adiviñar.
     */
    public HiddenWord(String word) {
        
        characters = word.toCharArray();
        hits = new boolean[word.length()];
        
        for (int i = 0; i < word.length(); i++) {
            hits[i]=false;
        }
    }
    
    /**
     * Comproba se un caracter aparece na lista de caracteres da palabra, 
     * marcando todas as aparicións dese caracter como acertadas.
     * @param c caracter a validar.
     * @return true se o caracter forma parte da palabra.
     */
    public boolean checkChar(char c){
        
        boolean foundCharacter = false;
                
        for (int i = 0; i < characters.length; i++) {
            
            if (Character.toUpperCase(characters[i])==c) {  
                hits[i]=true;
                foundCharacter=true;
            }
        }
    
        return foundCharacter;
    }
    
    /**
     * Devolve a palabra substituíndo os caracteres non acertados por guións.
     * @return a palabra, mostrando os caracteres da palabra acertados.
     */
    public String show(){
        String word = "";        
        
        for (int i = 0; i < characters.length; i++) {
            if (hits[i]) {
                word+=characters[i];
            }else{
                word+="-";
            }
        }
        
        return word;
        
    }
    
    /**
     * Devolve a palabra completa, incluíndo os caracteres non acertados.
     * Este método o usaremos para mostrar ao usuario ao final do xogo, 
     * se perde, cal era a palabra oculta.
     * @return a palabra que se debería adiviñar.
     */
    public String showFullWord(){
        String word = "";
        
        for (int i = 0; i < characters.length; i++) {
            word+=characters[i];
        }
        
        return word;
        
    }

    /**
     * Indica se a palabra é totalmente visible, é dicir, 
     * se todos os caracteres están xa acertados.
     * @return true se o usuario acertou a palabra e false en caso contrario.
     */
    public boolean isVisible(){
        boolean rightWord = true;
        
        for (int i = 0; i < hits.length; i++) {
            if (!hits[i]) {
                rightWord = false;
            }
        }
        
        return rightWord;
        
    }
    
}
