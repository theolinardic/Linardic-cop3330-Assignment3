/*
 *  UCF COP3330 Summer 2021 Assignment 3 Solution
 *  Copyright 2021 Theodore Linardic
 */

package ex44;

import java.io.*;
import java.util.Scanner;
import org.json.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class app {

    //The checkforProduct function simply takes in a product name and checks if it exists in the suppleied json file.
    // If it does, it will return false (stopping the input loop) and print out the quanitty and price of the item.
    public static boolean checkForProduct(String product){

        try{
            Object inputJsonFile = new JSONParser().parse(new FileReader("src/txtfiles/exercise44_input.json"));

            JSONObject jsonInputObject = (JSONObject) inputJsonFile;

            JSONArray products = (JSONArray) jsonInputObject.get("products");

            for(int i = 0; i < product.length()-1; i++){
                try{
                    int nameStart = products.get(i).toString().indexOf("name");
                    String productName = products.get(i).toString().substring(nameStart+7, products.get(i).toString().length()-2);
                    if(productName.equals(product)){
                        System.out.println("Name: " + productName);

                        int priceStart = products.get(i).toString().indexOf("price");
                        String productPrice = products.get(i).toString().substring(priceStart+7, nameStart-2);

                        String productQuantity = products.get(i).toString().substring(12, priceStart-2);

                        System.out.println("Price: " + productPrice + "\nQuantity: " + productQuantity);
                        return true;
                    }
                }
                catch(Exception e){

                }

            }
        }
        catch(IOException e){
            System.out.println("IOEXception");
        }
        catch (ParseException x) {
            System.out.println("Parse exception");
        }


        return false;
    }

    // Main will run a while loop constantly checking for the users product name and calling checkIfProductExist in order
    // to check if a product is real.
    public static void main( String[] args )
        {
            Scanner userInputScanner = new Scanner(System.in);

            while(true){
                System.out.print("What is the product name? ");
                String product = userInputScanner.nextLine();

                boolean checkIfProductExist = checkForProduct(product);
                if(checkIfProductExist == false){
                    System.out.println("Sorry, that product was not found in our inventory.");
                }
                else{
                    break;
                }
            }

        }
}
