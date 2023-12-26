/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aforcado;

/**
 * Esta clase implementa a palabra a adivi�ar coa que traballaremos no xogo, 
 * e resolver� todo o traballo de manter as letras acertadas, 
 * mostrar a palabra ocultando as letras non acertadas, 
 * e comprobar se unha letra forma parte da palabra.
 * 
 * @author Abel Iglesias Moure
 * @author Gabriel Julian �lvarez G�mez
 */
public class HiddenWord {
    
    //� un array de caracteres que almacena os caracteres da palabra.
    private char characters [];
    
    // � un array de booleans marcar�n con true aqueles caracteres da palabra 
    //que est�n acertados e con false os que a�nda non o est�n.
    private boolean hits [];

    /**
     * O construtor da clase que inicializa os dous arrays. 
     * @param word a palabra que imos adivi�ar.
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
     * marcando todas as aparici�ns dese caracter como acertadas.
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
     * Devolve a palabra substitu�ndo os caracteres non acertados por gui�ns.
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
     * Devolve a palabra completa, inclu�ndo os caracteres non acertados.
     * Este m�todo o usaremos para mostrar ao usuario ao final do xogo, 
     * se perde, cal era a palabra oculta.
     * @return a palabra que se deber�a adivi�ar.
     */
    public String showFullWord(){
        String word = "";
        
        for (int i = 0; i < characters.length; i++) {
            word+=characters[i];
        }
        
        return word;
        
    }

    /**
     * Indica se a palabra � totalmente visible, � dicir, 
     * se todos os caracteres est�n xa acertados.
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
