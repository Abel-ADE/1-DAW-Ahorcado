/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

import java.util.Scanner;

/**
 * Esta clase enc�rgase de mostrar os men�s coas distintas opci�ns do xogo, e
 * recoller o que introduza o usuario.
 *
 * @author Abel Iglesias Moure
 * @author Gabriel Julian �lvarez G�mez
 */
public class MenuGenerator {

    // Un obxecto da clase HangMan que xestionar� o funcionamento da partida actual.
    private HangMan hangMan;

    /**
     * Mostra o men� inicial que permite xerar a palabra a adivi�ar.
     *
     * @return a palabra a adivi�ar.
     */
    private String showInitMenu() {
        WordGenerator newWordGenerator = new WordGenerator();
        return newWordGenerator.generateWord();

    }

    /**
     * Mostra o men� do xogo, que vai pedindo as letras e mostrando o avance de
     * fallos e acertos na palabra. O xogo remata cando se acertan todas as
     * letras da palabra ou se chega ao l�mite de fallos.
     */
    private void showGameMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("Benvido ao Xogo do aforcado");
        System.out.println("Esta � a palabra que tes que adivi�ar: " + hangMan.showHiddenWord());
        System.out.println("N�mero m�ximo de intentos: " + HangMan.MAX_FAILS);
        System.out.println("---------------------------------------------------");
        do {

            String line;
            
            do {
                Scanner scan = new Scanner(System.in);
                System.out.print("Introduce unha letra: ");
                line = scan.nextLine();
                
                if (line.isEmpty()) {
                    System.out.println("Debes introducir unha letra!");
                }
                
            } while (line.isEmpty());

            hangMan.tryChar(Character.toUpperCase(line.charAt(0)));

            System.out.println("");
            System.out.println("Palabra a adivi�ar: " + hangMan.showHiddenWord());
            System.out.println("Letras falladas: " + hangMan.getStringFails());

            if (hangMan.maxFailsExceeded()) {
                System.out.println("");
                System.out.println("Perdiches...");
                System.out.println("A palabra a adivi�ar era: " + hangMan.showFullWord());
            }

        } while (!hangMan.isGameOver());
    }

    /**
     * Pregunta ao usuario se quere xogar outra partida ou sa�r da aplicaci�n.
     *
     * @return true se o usuario quere sa�r da aplicaci�n.
     */
    private boolean showExitMenu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("�Queres sa�r da aplicaci�n? - (true/false)");
        return scan.nextBoolean();

    }

    /**
     * Nesta clase incluiremos o m�todo principal que executa o programa.
     *
     * @param args the command line arguments.
     */
    public static void main(String[] args) {
        MenuGenerator menuGenerator = new MenuGenerator();

        do {
            menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            menuGenerator.showGameMenu();
        } while (!menuGenerator.showExitMenu());

    }

}
