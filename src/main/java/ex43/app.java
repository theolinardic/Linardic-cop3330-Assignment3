/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex43;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class app {

    //The generateContent function takes in all of the requried information and generates the needed content based on the input.
    public static void generateContent(String siteName, String author, String javaScript, String cssFolder){
        File siteNameFile = new File("./website/" + siteName);

        if(!siteNameFile.exists()){
            siteNameFile.mkdirs();
        }
        System.out.println("Created ./website/"+siteName);


        File outputFile = new File("./website/" +siteName+"/index.html");
        try {
            FileWriter outputWriter = new FileWriter("./website/" +siteName+"/index.html");

            outputWriter.write("<!DOCTYPE html>\n<html>\n<head>\n <title>" + siteName + "</title>\n" +
                    "<meta charset=\"UTF-8\">\n" +
                    "  <meta name=\"Author\" content=\"" + author + "\">\n</head>\n</body>\n</html>");

            outputWriter.close();

            System.out.println("Created " + "./website/" +siteName+"/index.html");
        }

        catch(IOException e){
            System.out.println("Error writing to file");
        }

        if(javaScript.toLowerCase().equals("y")){
            File javaFile = new File("./website/js");

            if(!javaFile.exists()){
                javaFile.mkdirs();
            }
            System.out.println("Created ./website/js/");
        }

        if(cssFolder.toLowerCase().equals("y")){
            File cssFile = new File("./website/css");

            if(!cssFile.exists()){
                cssFile.mkdirs();
            }
            System.out.println("Created ./website/css/");
        }


    }

    //The get userinput function gets all of the users input for what kind of content should be created and then
    // calls the genereateContent function to actualy create the content.
    public static void getUserInput(){
        Scanner userInputScanner = new Scanner(System.in);

        System.out.print("Site Name: ");
        String siteName = userInputScanner.nextLine();
        System.out.print("Author: ");
        String author = userInputScanner.nextLine();
        System.out.print("Do you want a folder for java script? (y/n): ");
        String javaScript = userInputScanner.nextLine();
        System.out.print("Do you want a folder for CSS? (y/n): ");
        String cssFolder = userInputScanner.nextLine();

        generateContent(siteName,author,javaScript,cssFolder);

    }

    //Main just calls the userInput Function.
    public static void main( String[] args )
        {
            getUserInput();
        }
}
