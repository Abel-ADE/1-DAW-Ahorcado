/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Imos implementar un novo modo de xogo para un xogador que xere a palabra
 * oculta consultando un ficheiro de texto.
 *
 * @author abel
 */
public class FileWordGenerator implements WordGenerator {

    /**
     * Genera a palabra oculta consultando un ficheiro de texto.
     */
    @Override
    public String generateWord() throws GenerateWordException {
        // Declaramos o scanner
        Scanner in = null;

        //Declaramos o ArrayList
        ArrayList<String> words = new ArrayList<>();

        //Ruta do ficheiro
        String sourceFilePath = FileWordGenerator.class.getClassLoader().getResource("aforcado/ui/words.hangman").getPath();

        try {
            // Abrimos o scanner sobre un reader con buffer
            in = new Scanner(new BufferedReader(new FileReader(sourceFilePath)));

            //Lemos as palabras e as gardamos nun arrayList
            while (in.hasNext()) {
                words.add(in.next());
            }
        } catch (FileNotFoundException ex) {
            throw new GenerateWordException(true, "Error co ficheiro");
        } finally {
            // pechamos o scanner se está aberto
            if (in != null) {
                in.close();
            }
        }

        //Generamos un número aleatorio
        int random = new java.util.Random().nextInt(words.size());

        //Devolvemos a palabra aleatoria
        return words.get(random);
    }
}
