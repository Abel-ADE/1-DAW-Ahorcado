/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

/**
 * Pide por pantalla unha palabra a adiviñar
 * @author Abel Iglesias Moure
 */
public class GUIKeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {

        String[] options = new String[]{"Aceptar", "Cancelar"};
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Introduce a palabra secreta:");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);

        String word = null;
        
        do {
            int option = JOptionPane.showOptionDialog(null, panel, "Palabra secreta",
                    JOptionPane.NO_OPTION, JOptionPane.QUESTION_MESSAGE,
                    null, options, options[0]);
            
            if (option == 0) {
                
                if (isValid(String.valueOf(pass.getPassword()))) {
                    word = String.valueOf(pass.getPassword());
                } else {
                    JOptionPane.showMessageDialog(null, "A palabra só pode conter letras minúsculas da 'a' a 'z'", "Palabra incorrecta", JOptionPane.INFORMATION_MESSAGE);
                }
            }else{
                throw new GenerateWordException(false, "Non se puido xerar a palabra");
            }
        } while (!isValid(String.valueOf(pass.getPassword())));
        
        return word;
    }
    
    private boolean isValid(String word){
        return word.matches("^[\\p{L}\\p{IsLatin}]+$");              
    }

}
