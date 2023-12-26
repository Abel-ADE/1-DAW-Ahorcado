/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package aforcado.ui;

/**
 *Esta interfaz define o m�todo que se encarga de xerar a palabra a adivi�ar.
 * @author Abel Iglesias Moure
 */
public interface WordGenerator{
    
    /**
     * Devolve a palabra a adivi�ar.
     * @return a palabra a adivi�ar.
     * @throws aforcado.ui.GenerateWordException
     */
    public String generateWord() throws GenerateWordException;
}
