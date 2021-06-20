/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex45;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Scanner;

public class app {

    // The processFile function takes in an input text file and replaces every instance of the word utilize with the word
    // use. It then creates a new text file (with the name supplied by user) and saves the output to that file.
    public static void processFile(String newFileName){
        String textFileContent = "";
        try{
            File inputText = new File("src/txtfiles/exercise45_input.txt");
            Scanner inputScanner = new Scanner(inputText);


            while(inputScanner.hasNextLine()){
                textFileContent += inputScanner.nextLine();
                textFileContent += "\n";
            }

            while(textFileContent.indexOf("utilize") != -1){
                int utilizePosition = textFileContent.indexOf("utilize");

                textFileContent = textFileContent.substring(0, utilizePosition) + "use" + textFileContent.substring(utilizePosition+7, textFileContent.length());
            }


        }
        catch(FileNotFoundException e){
            System.out.println("Text file not found.");
        }

        File outputFile = new File("src/txtfiles/" + newFileName + ".txt");

        try{
            FileWriter outputWriter = new FileWriter("src/txtfiles/" + newFileName + ".txt");
            outputWriter.write(textFileContent);

            outputWriter.close();
        }

        catch(IOException e){
            System.out.println("Error writing to file.");
        }

    }


    // Main function will ask for users input on the new fil ename and call the process file function.
    public static void main( String[] args )
        {
            Scanner userInputScanner = new Scanner(System.in);

            System.out.println("What is the name of the new file?");
            String newFileName = userInputScanner.nextLine();
            processFile(newFileName);


        }
}
