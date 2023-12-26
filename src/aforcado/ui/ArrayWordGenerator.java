/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

/**
 * Esta clase encárgase de xerar a palabra a adiviñar. Polo momento, 
 * simplemente mantén unha lista de palabras nun array e escolle unha aleatoriamente. 
 * Máis adiante estenderemos esta clase para permitir distintos modos de xogo, 
 * que xerarán a palabra de diferentes maneiras.
 * 
 * @author Abel Iglesias Moure
 */
public class ArrayWordGenerator implements WordGenerator{
    
    /**
     * A lista de palabras posibles entre as que escoller a palabra oculta.
     */
    public static final String WORDLIST[] = {"Java", "PHP", "JavaScript", "HTML", "CSS"};
    
    /**
     * Devolve a palabra a adiviñar.
     * @return a palabra a adiviñar.
     */
    @Override
    public String generateWord(){
        
        int index = new java.util.Random().nextInt(WORDLIST.length-1);
        
        return WORDLIST[index];
        
    }
    
    
    
}
