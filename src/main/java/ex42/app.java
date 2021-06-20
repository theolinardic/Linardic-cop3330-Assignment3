/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex42;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class app {

    // The function readFile opens the needed text file and saves all the names from the text file
    // to an arraylist and returns that arraylist.
    public static ArrayList<String> readFile(){

        ArrayList<String> allNames = new ArrayList<String>();
        try{
            File inputText = new File("src/txtfiles/exercise42_input.txt");
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

    // The function processList takes in an arrayList of names, formats the information in the list to pull out
    // what is needed and outputs it to the console.
    public static void processList(ArrayList<String> allNames){
        ArrayList<String> firstNames = new ArrayList<String>();
        ArrayList<String> lastNames = new ArrayList<String>();
        ArrayList<String> salaries = new ArrayList<String>();

        for(int i = 0; i < allNames.size(); i++){
            int firstComma = -1, secondComma = -1;
            for(int x = 0; x < allNames.get(i).length(); x++){
                if(allNames.get(i).charAt(x) == ','){
                    if(firstComma == -1){
                        firstComma = x;
                    }
                    else{
                        secondComma = x;
                    }

                }
            }

            firstNames.add(allNames.get(i).substring(0, firstComma));
            lastNames.add(allNames.get(i).substring(firstComma+1, secondComma));
            salaries.add(allNames.get(i).substring(secondComma+1, allNames.get(i).length()));
        }

        System.out.print("Last          First         Salary\n---------------------------------------\n");

        for(int i = 0; i < firstNames.size(); i++){
            System.out.printf("%-13s %-13s %-13s\n", firstNames.get(i), lastNames.get(i), salaries.get(i));
        }
    }

    //The main function calls both required functions.
    public static void main( String[] args )
        {
            ArrayList<String> allNames = readFile();

            processList(allNames);
        }
}
