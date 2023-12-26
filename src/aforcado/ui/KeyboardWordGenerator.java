/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

import java.util.Scanner;

/**
 * Pedirá a palabra a adiviñar por teclado.
 * @author Abel Iglesias Moure
 */
public class KeyboardWordGenerator implements WordGenerator {

    @Override
    public String generateWord() throws GenerateWordException {
        Scanner scan = new Scanner(System.in);
        System.out.println("");
        System.out.println("Introduce a palabra a adiviñar:");
        return scan.nextLine();
        
        //return (String.valueOf(System.console().readPassword(scan.nextLine())));
    }
    
}
