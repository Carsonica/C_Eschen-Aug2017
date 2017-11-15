package fracCalc;
import java.util.*;
import java.lang.String;

public class FracCalc {

    public static void main(String[] args) {
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
    			System.out.println(produceAnswer(input));
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
    public static String produceAnswer(String input) { 
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
    	//and set them to their default values. Also, find the index of the slash and underscore.
        int whole = 0;
        int numerator = 0;
        int denominator = 1;
        int underscorePlace = operand.indexOf("_");
        int slashPlace = operand.indexOf("/");
        //If there is an underscore...
        if(underscorePlace >= 0) {
        	//...set the variable for the whole equal to the number before it...
        	whole = Integer.parseInt(operand.substring(0, underscorePlace));
        	//...set the numerator equal to the number after the underscore and before the slash
        	numerator = Integer.parseInt(operand.substring(underscorePlace + 1, slashPlace));
       		//...and set the denominator equal to the number after the slash
        		denominator = Integer.parseInt(operand.substring(slashPlace + 1));
        } //If there is only a slash...
        else if(slashPlace >= 0) {
        	//...set the numerator equal to the number before the slash...
        	numerator = Integer.parseInt(operand.substring(0, slashPlace));
        	//...and set the denominator equal to the number after the slash.
    		denominator = Integer.parseInt(operand.substring(slashPlace + 1, operand.length()));
        } //If there is no slash or underscore...
        else {
        	//...set the whole to the number put in.
        	whole = Integer.parseInt(operand);
        }
        //Create and return an array of the newly parsed values
        int[] operandArray = {whole, numerator, denominator};
        return operandArray;
    }
    
}
