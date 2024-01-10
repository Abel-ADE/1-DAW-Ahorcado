/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

/**
 * Pedirá a palabra a adiviñar por teclado.
 * @author Abel Iglesias Moure
 */
public class KeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        System.out.println("");
        System.out.println("Introduce a palabra a adiviñar:");
        
        return String.valueOf(System.console().readPassword());
    }
    
}
