/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

/**
 * Clase para o manexo de excepcións a hora de xerar unha palabra para adiviñar.
 * @author Abel Iglesias Moure
 */
public class GenerateWordException extends Exception {
    
    /**
     * Usaremos para saber se hai que facer visible a mensaxe da excepción ao usuario.
     */
    private boolean visible;

    /**
     * Devolve se hai que facer visible a mensaxe da excepción.
     * @return se hai que facer visible a mensaxe da excepción.
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     * Sobrescribe se hai que facer visible a mensaxe da excepción.
     * @param visible se hai que facer visible a mensaxe da excepción.
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * O constructor da clase.
     * @param visible se hai que facer visible a mensaxe da excepción.
     * @param message a mensaxe da excepción.
     */
    public GenerateWordException(boolean visible, String message) {
        super(message);
        this.visible = visible;
    }
    
    
    
}
