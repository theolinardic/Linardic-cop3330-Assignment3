/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex41;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class app {

    // The readfile function opens the text file 'exercise41_input.txt' and adds all the names found
    // to an arraylist called all names. Then it returns the arraylist.
    public static ArrayList<String> readFile(){

        ArrayList<String> allNames = new ArrayList<String>();
        try{
            File inputText = new File("src/txtfiles/exercise41_input.txt");
            Scanner inputScanner = new Scanner(inputText);

            while(inputScanner.hasNextLine()){
                String currentName = inputScanner.nextLine();
                allNames.add(currentName);
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Text file not found.");
        }

        return allNames;

    }

    // The function sortList takes in an arraylist of strings and uses the built in collections.sort
    // function in order to alphabetically sort the arraylist. It then returns the newly sorted arraylist.
    public static ArrayList<String> sortList(ArrayList<String> allNames){

        Collections.sort(allNames);

        return allNames;
    }

    // The function printList takes in an arraylist of strings and prints every item in the arrayList.
    public static void printList(ArrayList<String> allNames){
        int length = allNames.size();

        for(int i = 0; i < length; i++){
            System.out.println(allNames.get(i));
        }
    }

    // The function saveListToFile takes in an arraylist of strings, creates a new text file for the output,
    // and writes the names with a header to the textfile.
    public static void saveListToFile(ArrayList<String> allNames){
        File outputFile = new File("src/txtfiles/exercise41_output.txt");

        try{
            FileWriter outputWriter = new FileWriter("src/txtfiles/exercise41_output.txt");
            outputWriter.write("Total of " + allNames.size() + " Names\n-------------------------------\n");

            for(int i = 0; i < allNames.size(); i++){
                outputWriter.write(allNames.get(i) + "\n");
            }
            outputWriter.close();
        }

        catch(IOException e){
            System.out.println("Error writing to file.");
        }

    }


    // The main function just contains all of the calls to other functions.
    public static void main( String[] args )
        {
            ArrayList<String> allNames = readFile();
            printList(allNames);
            allNames = sortList(allNames);
            System.out.println("\n");
            printList(allNames);
            saveListToFile(allNames);
        }
}
