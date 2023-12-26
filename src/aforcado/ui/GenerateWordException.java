/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

/**
 * Clase para o manexo de excepci�ns a hora de xerar unha palabra para adivi�ar.
 * @author Abel Iglesias Moure
 */
public class GenerateWordException extends Exception {
    
    /**
     * Usaremos para saber se hai que facer visible a mensaxe da excepci�n ao usuario.
     */
    private boolean visible;

    /**
     * Devolve se hai que facer visible a mensaxe da excepci�n.
     * @return se hai que facer visible a mensaxe da excepci�n.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sobrescribe se hai que facer visible a mensaxe da excepci�n.
     * @param visible se hai que facer visible a mensaxe da excepci�n.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * O constructor da clase.
     * @param visible se hai que facer visible a mensaxe da excepci�n.
     * @param message a mensaxe da excepci�n.
     */
    public GenerateWordException(boolean visible, String message) {
        super(message);
        this.visible = visible;
    }
    
    
    
}
