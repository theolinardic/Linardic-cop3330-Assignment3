/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex46;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

    // The processFile function opens the input file an duses two different arraylists to keep track of the words that
    // have been found and how many times each word was found. It then outputs the findings to the console in the
    // correct format.
    public static void processFile(){

        ArrayList<String> allWords = new ArrayList<String>();
        ArrayList<Integer> wordCounts = new ArrayList<Integer>();

        try{
            File inputText = new File("src/txtfiles/exercise46_input.txt");
            Scanner inputScanner = new Scanner(inputText);

            while(inputScanner.hasNext()){
                String currentWord = inputScanner.next();

                int wordPosition = -1;

                for(int i = 0; i < allWords.size(); i++){
                    if(allWords.get(i).equals(currentWord)){
                         wordPosition = i;
                         wordCounts.set(i, wordCounts.get(i)+1);
                    }
                }

                if(wordPosition == -1){
                    allWords.add(currentWord);
                    wordCounts.add(1);
                }

            }
        }
        catch(FileNotFoundException e){
            System.out.println("Text file not found.");
        }

        ArrayList<Integer> printOrder = new ArrayList<Integer>();

        for(int i = 0; i < allWords.size(); i++){
            System.out.print(allWords.get(i) + ": ");
            for(int x = 0; x < wordCounts.get(i); x++){
                System.out.print("*");
            }
            System.out.print("\n");
        }

    }

    //Main function calls the processFile function.
    public static void main( String[] args )
        {
            processFile();
        }
}
