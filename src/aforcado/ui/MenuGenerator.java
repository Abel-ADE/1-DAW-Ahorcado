/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

import aforcado.model.HangMan;
import java.util.Scanner;

/**
 * Esta clase encárgase de mostrar os menús coas distintas opcións do xogo, e
 * recoller o que introduza o usuario.
 *
 * @author Abel Iglesias Moure
 */
public class MenuGenerator {

    // Un obxecto da clase HangMan que xestionará o funcionamento da partida actual.
    private HangMan hangMan;

    /**
     * Mostra o menú inicial que permite xerar a palabra a adiviñar.
     *
     * @return a palabra a adiviñar.
     */
    private String showInitMenu() throws GenerateWordException {
        Scanner scan = new Scanner(System.in);
        String word = "";

        System.out.println("Benvido ao Aforcado");
        System.out.println("Elixe unha opción:");
        System.out.println("1 - O programa xera a palabra a adiviñar");
        System.out.println("2 - O usuario introduce unha palabra por teclado");

        int option = scan.nextInt();

        switch (option) {
            case 1:
                ArrayWordGenerator arrayWordGenerator = new ArrayWordGenerator();
                word = arrayWordGenerator.generateWord();
                break;
            case 2:
                KeyboardWordGenerator keyboardWordGenerator = new KeyboardWordGenerator();
                word = keyboardWordGenerator.generateWord();
                break;
        }
        return word;
    }

    /**
     * Mostra a cabeceira do menú do xogo.
     */
    private void showHeadMenu() {
        System.out.println("---------------------------------------------------");
        System.out.println("Xogo do aforcado");
        System.out.println("Esta é a palabra que tes que adiviñar: " + hangMan.showHiddenWord());
        System.out.println("Número de intentos: " + (HangMan.MAX_FAILS - hangMan.getFails().size()));
        System.out.println("Letras falladas: " + hangMan.getStringFails());
        System.out.println("---------------------------------------------------");
        System.out.println("");
    }

    /**
     * Mostra o menú do xogo, que vai pedindo as letras e mostrando o avance de
     * fallos e acertos na palabra. O xogo remata cando se acertan todas as
     * letras da palabra ou se chega ao límite de fallos.
     */
    private void showGameMenu() {
        do {

            showHeadMenu();

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

        } while (!hangMan.isGameOver());

        if (hangMan.maxFailsExceeded()) {
            showHeadMenu();

            System.out.println("Perdiches...");
            System.out.println("A palabra a adiviñar era: " + hangMan.showFullWord());
            System.out.println("");
        } else if (hangMan.getHiddenWord().isVisible()) {
            showHeadMenu();

            System.out.println("Gañaches!!");
        }
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
            try {
                menuGenerator.hangMan = new HangMan(menuGenerator.showInitMenu());
            } catch (GenerateWordException e) {
                if (e.isVisible()) {
                    System.err.println(e.getMessage());
                }
            }
            menuGenerator.showGameMenu();
        } while (!menuGenerator.showExitMenu());

    }

}
