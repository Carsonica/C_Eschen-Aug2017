package fracCalc;
import java.util.*;
import java.lang.String;

public class FracCalc {

    public static void main(String[] args) 
    {
        //Read the input from the user and call produceAnswer with an equation. Print the result.
    	//Repeat until the user types "quit"
    	Scanner console = new Scanner(System.in);
    	boolean notDoneYet = true;
    	while(notDoneYet) {
    		System.out.print("Enter your equation, with mixed fractions in the form \"X_Y/Z\", or enter quit"); 	
    		String input = console.nextLine();
    		if(input.equals("quit")) {
    			notDoneYet = false;
    		} else {
    			System.out.print(produceAnswer(input));
    		}
    	}
    }
    
    // ** IMPORTANT ** DO NOT DELETE THIS FUNCTION.  This function will be used to test your code
    // This function takes a String 'input' and produces the result
    //
    // input is a fraction string that needs to be evaluated.  For your program, this will be the user input.
    //      e.g. input ==> "1/2 + 3/4"
    //        
    // The function should return the result of the fraction after it has been calculated
    //      e.g. return ==> "1_1/4"
    public static String produceAnswer(String input)
    { 
        // TODO: Implement this function to produce the solution to the input
    	//Split the input into 3 parts, with a variable for each
        String[] splitInput = input.trim().split(" ");
        String operand1 = splitInput[0];
        String operand2 = splitInput[2];
        String operator = splitInput[1];
        //Call parseInputs twice to parse each input
        int[] parsedOperand1 = parseInputs(operand1);
        int[] parsedOperand2 = parseInputs(operand2);
        return "whole:" + parsedOperand2[0] + " numerator:" + parsedOperand2[1] + " denominator:" + parsedOperand2[2];
    }
    public static int[] parseInputs(String operand) {
    	//Declare integer variables for the whole number, numerator, and denominator 
    	//and set them to their default values.
        int whole = 0;
        int numerator = 0;
        int denominator = 1;
        if(operand.indexOf("_") >= 0) {
        	whole = Integer.parseInt(operand.substring(0, operand.indexOf("_")));
        	if(operand.indexOf("/") >= 0) {
        		numerator = Integer.parseInt(operand.substring(operand.indexOf("_"), operand.indexOf("/")));
        		denominator = Integer.parseInt(operand.substring(operand.indexOf("/")), operand.length());
        	}
        } else if(operand.indexOf("/") >= 0) {
        	numerator = Integer.parseInt(operand.substring(0, operand.indexOf("/")));
    		denominator = Integer.parseInt(operand.substring(operand.indexOf("/")), operand.length());
        }
        int[] operandArray = {whole, numerator, denominator};
        return operandArray;
    }
    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
