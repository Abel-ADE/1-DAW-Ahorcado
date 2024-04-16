/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aforcado.ui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Clase que genera unha palabra aleatoria que carga dunha base de datos.
 *
 * @author abel.iglesiasmoure
 */
public class DBWordGenerator implements WordGenerator {

    /**
     * URL da conexi�n coa base de datos.
     */
    private static final String URL_DB = "jdbc:sqlite:DBWordGenerator.db";

    /**
     * A instancia da conexi�n coa base de datos.
     */
    private static Connection c = null;

    /**
     * M�todo que obten a conexi�n coa base de datos.
     * @return a conexi�n coa base de datos
     */
    public static Connection getConnection() throws GenerateWordException {
        if (c == null) {
            try {
                //Obten a conexi�n coa base de datos
                c = DriverManager.getConnection(URL_DB);
                //Crea a taboa se non existe
                DBWordGenerator.createTable();
                //A�ade as palabras se non existen
                DBWordGenerator.addWordsToDB();
            } catch (SQLException ex) {
                 throw new GenerateWordException(true, "Problema ao establecer a conexi�n coa base de datos");
            }
        }

        return c;
    }

    /**
     * M�todo para crear a taboa da base de datos se non existe.
     */
    private static void createTable() throws GenerateWordException {
        String sql = "CREATE TABLE IF NOT EXISTS words (word VARCHAR(200) PRIMARY KEY);";

        try (Statement st = DBWordGenerator.getConnection().createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new GenerateWordException(true, "Problema ao crear a tabla words da base de datos");
        }
    }

    /**
     * M�todo para insertar palabras na base de datos.
     */
    private static void addWordsToDB() throws GenerateWordException {
        String sql = "REPLACE INTO words VALUES ('JavaScript'), ('Java'), ('HTML'), ('CSS'), ('PHP'), ('TypeScript');";

        try (Statement st = DBWordGenerator.getConnection().createStatement()) {
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            throw new GenerateWordException(true, "Problema ao engadir as palabras a base de datos");
        }
    }

    /**
     * M�todo para obter o n�mero de palabras que conten a base de datos.
     * @return o n�mero de palabras que conten a base de datos.
     */
    private int getNumberWords() throws GenerateWordException {
        String sql = "SELECT COUNT(word) FROM words;";

        Statement st;
        ResultSet rst;

        int words = Integer.MIN_VALUE;
        try {
            st = DBWordGenerator.getConnection().createStatement();
            rst = st.executeQuery(sql);

            if (rst.next()) {
                words = rst.getInt(1);
            }
            
            rst.close();
            st.close();
        } catch (SQLException e) {
            throw new GenerateWordException(true, "Problema ao contar as palabras da base de datos");
        }

        return words;
    }
    
    /**
     * M�todo que devolve as palabras da base de datos.
     * @return as palabras da base de datos.
     */
    private ArrayList<String> getWords() throws GenerateWordException{
        String sql = "SELECT word FROM words;";

        Statement st;
        ResultSet rst;

        ArrayList<String> words = new ArrayList<>();
        
        try {
            st = DBWordGenerator.getConnection().createStatement();
            rst = st.executeQuery(sql);

            while (rst.next()) {
                words.add(rst.getString(1));
            }
            
            rst.close();
            st.close();
        } catch (SQLException e) {
            throw new GenerateWordException(true, "Problema ao recuperar as palabras da base de datos");
        }

        return words;
    }

    /**
     * M�todo que genera unha palabra a partir da base de datos.
     * @return unha palabra.
     * @throws GenerateWordException unha excepci�n.
     */
    @Override
    public String generateWord() throws GenerateWordException {
        
        int numberWords = getNumberWords();
        
        int randomNumber = new java.util.Random().nextInt(numberWords);
        
        ArrayList<String> words = getWords();
        
        return words.get(randomNumber);
    }

}
