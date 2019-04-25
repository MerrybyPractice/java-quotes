/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package java.quotes;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class renderQuotes {

    public Quotes[] parseQuotes(Path quotesPath) throws IOException {

        String quoteFile = "";

        try (BufferedReader readQuotes = Files.newBufferedReader(quotesPath)) {

            String currentLine = readQuotes.readLine();
            while (currentLine != null) {
                quoteFile += currentLine;
                currentLine = readQuotes.readLine();
            }
        } catch (IOException ex) {
            throw ex;
        }

        Gson quotesParserGson = new Gson();

        Quotes[] quotesArray = quotesParserGson.fromJson(quoteFile, Quotes[].class);

        return quotesArray;
    }
}
