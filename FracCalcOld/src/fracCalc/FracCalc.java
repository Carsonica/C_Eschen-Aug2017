/* Carson Eschen
 * November 28, 2017
 * FracCalc: A program to complete an operation on two or more fractions
 * input as a string by the user.
 */

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
    
    public static String produceAnswer(String input) { 
    	//Split the input into parts
        String[] splitInput = input.trim().split(" ");
        //Create an array to hold the answer
        int[] answer = new int[3];
        //Check to see if the sum of operators and operands is odd. If not, return an error
        if(splitInput.length % 2 == 0) {
        	return "ERROR: The number of operators and operands is invalid.";
        }
        //Create a loop to repeat all the steps a number of times equal to half the number of inputs,
        //rounded down, in order to account for the number of operators.
        for(int i = 0; i * 2 + 1 < splitInput.length; i++) {
	        //Call parseInputs twice to parse each input, putting the int values into an array.
	        //The order is: whole, numerator, denominator
	        int[] parsedOperand1 = parseInputs(splitInput[0]);
	        int[] parsedOperand2 = parseInputs(splitInput[2]);
	        //Check if either of the denominators is 0, indicating a non-existant fraction
	        if(parsedOperand1[2] == 0 || parsedOperand2[2] == 0) {
	        	return "ERROR: Fractions cannot have a denominator of 0.";
	        }
	        //Call toImproperFraction twice to convert each fraction to be improper
	        toImproperFraction(parsedOperand1);
	        toImproperFraction(parsedOperand2);
	        //Check which operation to use
	        if(splitInput[1].equals("+")) {
	        	answer = fracAddition(parsedOperand1, parsedOperand2);
	        } else if(splitInput[1].equals("-")) {
	        	//Make the second operator negative before calling addition
	        	parsedOperand2[1] *= -1;
	        	answer = fracAddition(parsedOperand1, parsedOperand2);
	        } else if(splitInput[1].equals("*")) {
	        	answer = fracMultiplication(parsedOperand1, parsedOperand2);
	        } else if(splitInput[1].equals("/")) {
	        	//Convert the second operator to its reciprocal before calling multiplication
	        	int newDenominator = parsedOperand2[1];
	        	parsedOperand2[1] = parsedOperand2[2];
	        	parsedOperand2[2] = newDenominator;
	        	answer = fracMultiplication(parsedOperand1, parsedOperand2);
	        } else {
	        	return "ERROR: Invalid operator or format.";
	        }
	        //Put the subtotal in the first place of splitInput, than move the remaining values
	        //two places to the left
	        String subtotal = answer[0] + "_" + answer[1] + "/" + answer[2];
	        splitInput[0] = subtotal;
	        for(int j = 1; j < splitInput.length - 2; j++) {
	        	splitInput[j] = splitInput[j + 2];
	        }      
        }
        //Reduce and convert the final answer to a mixed number
        reduceAndConvertToMixed(answer);
        //Check which values are 0 to return the simplified value without them.
        if(answer[0] == 0) {
        	if(answer[1] == 0) {
        		//If the whole and numerator are 0, return 0.
        		return "0";
        	}else {
        		//If the whole is 0, but the numerator is not, return just the fraction
        		return answer[1] + "/" + answer[2];
        	}
        }else if(answer[1] == 0) {
        	//If the numerator is 0, but the whole is not, return justs the whole
        	return "" + answer[0];
        }else {
        	//If none of the values are 0, return all the values
        	return answer[0] + "_" + answer[1] + "/" + answer[2];
        }
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
        	//...set the variable for the whole equal to the number before the underscore...
        	whole = Integer.parseInt(operand.substring(0, underscorePlace));
        	//...set the numerator equal to the number after the underscore and before the slash
        	numerator = Integer.parseInt(operand.substring(underscorePlace + 1, slashPlace));
       		//...and set the denominator equal to the number after the slash
        		denominator = Integer.parseInt(operand.substring(slashPlace + 1));
        } 
        
        //If there is only a slash...
        else if(slashPlace >= 0) {
        	//...set the numerator equal to the number before the slash...
        	numerator = Integer.parseInt(operand.substring(0, slashPlace));
        	//...and set the denominator equal to the number after the slash.
    		denominator = Integer.parseInt(operand.substring(slashPlace + 1, operand.length()));
        } 
        
        //If there is no slash or underscore...
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
    	//If the number is positive, add the the numerator to the product of the denominator and the whole.
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
    	//Find the common denominator
    	int newDenominator = operand1[2] * operand2[2];
    	//Find the numerator of the sum
    	int newNumerator = operand1[1] * operand2[2] + operand1[2] * operand2[1];
    	int[] fracSum = {0, newNumerator, newDenominator};
    	return fracSum;
    }
    
    //Multiply the two input arrays, where each one represents a mixed number
    //Order: whole, numerator, denominator
    public static int[] fracMultiplication(int[] operand1, int[] operand2) {
    	//Multiply the top and the bottom individually.
    	int newNumerator = operand1[1] * operand2[1];
    	int newDenominator = operand1[2] * operand2[2];
    	int[] fracProduct = {0, newNumerator, newDenominator};
    	return fracProduct;
    }
    
    //First, reduce the number to its smallest value
    //Then, convert it to a mixed number
    public static void reduceAndConvertToMixed(int[] fraction) {
    	//For each integer equal to or less than the denominator (but greater than 1), check to see if
    	//both the numerator and denominator are both divisible by it. If so, divide both by the number.
    	for(int i = Math.abs(fraction[2]); i > 1; i--) {
    		if(fraction[1] % i == 0 && fraction[2] % i == 0) {
    			fraction[1] = fraction[1] / i;
    			fraction[2] = fraction[2] / i;
    		}
    	}
    	//To eliminate any improper fractions, divide the top by the bottom to get the whole.
    	fraction[0] = fraction[1] / fraction[2];
    	//Then, find the remainder to make the new numerator.
    	fraction[1] = fraction[1] % fraction[2];
    	//If the positive/negative sign is now represented by the whole, make the numerators and 
    	//denominators positive.
    	if(fraction[0] != 0) {
    		fraction[1] = Math.abs(fraction[1]);
    		fraction[2] = Math.abs(fraction[2]);
    	} 
    	//If the denominator is negative, change the numerator's sign.
    	else if(fraction[2] < 0){
    		fraction[1] *= -1;
    		fraction[2] = Math.abs(fraction[2]);
    	}
    }
}
