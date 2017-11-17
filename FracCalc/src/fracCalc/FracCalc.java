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
    		System.out.println("Enter your equation, with mixed fractions in the form \"X_Y/Z\", or enter quit"); 
    		System.out.println("The valid operators are +, -, *, and /.");
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
        //Call parseInputs twice to parse each input, putting the int values into an array.
        //The order is: whole, numerator, denominator
        int[] parsedOperand1 = parseInputs(operand1);
        int[] parsedOperand2 = parseInputs(operand2);
        //Call toImproperFraction twice to convert each fraction to be improper
        toImproperFraction(parsedOperand1);
        toImproperFraction(parsedOperand2);
        //Create an array to hold the values for the final result
        int[] answer = new int[3];
        //Check which operation to use
        if(operator.equals("+")) {
        	answer = fracAddition(parsedOperand1, parsedOperand2);
        } else if(operator.equals("-")) {
        	//Make the second operator negative before calling addition
        	parsedOperand2[1] *= -1;
        	answer = fracAddition(parsedOperand1, parsedOperand2);
        } else if(operator.equals("*")) {
        	answer = fracMultiplication(parsedOperand1, parsedOperand2);
        } else if(operator.equals("/")) {
        	//Convert the second operator to its reciprocal before calling multiplication
        	int newDenominator = parsedOperand2[1];
        	parsedOperand2[1] = parsedOperand2[2];
        	parsedOperand2[2] = newDenominator;
        	answer = fracMultiplication(parsedOperand1, parsedOperand2);
        } else {
        	return "That is not a valid operator.";
        }
        reduceAndConvertToMixed(answer);
        return answer[0] + "_" + answer[1] + "/" + answer[2];
    }
    
    //Parse the input string to turn it into an array of ints
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
    
    //Convert the fractions to be improper
    public static void toImproperFraction(int[] operand) {
    	//If it's positive, add the the numerator to the product of the denominator and the whole.
    	//If it's negative, subtract it instead.
    	//If the whole is 0, do nothing.
    	if(operand[0] > 0) {
    		operand[1] += (operand[0] * operand[2]);
    	}else if(operand[0] < 0) {
    		operand[1] = operand[0] * operand[2] - operand[1];
    	}
    	//The whole is no longer needed, so change it to 0.
    	operand[0] = 0;
    }
    
    //Add the two input arrays, where each one represents a mixed number
    //Order: whole, numerator, denominator
    public static int[] fracAddition(int[] operand1, int[] operand2) {
    	int newDenominator = operand1[2] * operand2[2];
    	int newNumerator = operand1[1] * operand2[2] + operand1[2] * operand2[1];
    	int[] fracSum = {0, newNumerator, newDenominator};
    	return fracSum;
    }
    
    //Multiply the two input arrays, where each one represents a mixed number
    //Order: whole, numerator, denominator
    public static int[] fracMultiplication(int[] operand1, int[] operand2) {
    	int newNumerator = operand1[1] * operand2[1];
    	int newDenominator = operand1[2] * operand2[2];
    	int[] fracProduct = {0, newNumerator, newDenominator};
    	return fracProduct;
    }
    
    //First, reduce the number to its smallest value
    //Then, convert it to a mixed number
    public static void reduceAndConvertToMixed(int[] fraction) {
    	
    }
}
