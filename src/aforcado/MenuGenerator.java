/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado;

import java.util.Scanner;

/**
 * Esta clase encárgase de mostrar os menús coas distintas opcións do xogo, e
 * recoller o que introduza o usuario.
 *
 * @author Abel Iglesias Moure
 * @author Gabriel Julian Álvarez Gómez
 */
public class MenuGenerator {

    // Un obxecto da clase HangMan que xestionará o funcionamento da partida actual.
    private HangMan hangMan;

    /**
     * Mostra o menú inicial que permite xerar a palabra a adiviñar.
     *
     * @return a palabra a adiviñar.
     */
    private String showInitMenu() {
        WordGenerator newWordGenerator = new WordGenerator();
        return newWordGenerator.generateWord();

    }

    /**
     * Mostra o menú do xogo, que vai pedindo as letras e mostrando o avance de
     * fallos e acertos na palabra. O xogo remata cando se acertan todas as
     * letras da palabra ou se chega ao límite de fallos.
     */
    private void showGameMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("Benvido ao Xogo do aforcado");
        System.out.println("Esta é a palabra que tes que adiviñar: " + hangMan.showHiddenWord());
        System.out.println("Número máximo de intentos: " + HangMan.MAX_FAILS);
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
            System.out.println("Palabra a adiviñar: " + hangMan.showHiddenWord());
            System.out.println("Letras falladas: " + hangMan.getStringFails());

            if (hangMan.maxFailsExceeded()) {
                System.out.println("");
                System.out.println("Perdiches...");
                System.out.println("A palabra a adiviñar era: " + hangMan.showFullWord());
            }

        } while (!hangMan.isGameOver());
    }

    /**
     * Pregunta ao usuario se quere xogar outra partida ou saír da aplicación.
     *
     * @return true se o usuario quere saír da aplicación.
     */
    private boolean showExitMenu() {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("¿Queres saír da aplicación? - (true/false)");
        return scan.nextBoolean();

    }

    /**
     * Nesta clase incluiremos o método principal que executa o programa.
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
