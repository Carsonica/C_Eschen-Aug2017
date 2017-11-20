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
        String returnValue = answer[0] + "_" + answer[1] + "/" + answer[2];
        //Check which values are 0 to return the simplified value
        if(answer[0] == 0) {
        	if(answer[1] == 0) {
        		//If the whole and numerator are 0
        		return "0";
        	}else {
        		//If the whole is 0, but the numerator is not
        		return answer[1] + "/" + answer[2];
        	}
        }else if(answer[1] == 0) {
        	//If the numerator is 0, but the whole is not
        	return "" + answer[0];
        }else {
        	//If none of the values are 0
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
        	//...set the variable for the whole equal to the number before it...
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
    	for(int i = fraction[2]; i > 1; i--) {
    		if(fraction[1] % i == 0 && fraction[2] % i == 0) {
    			fraction[1] = fraction[1] / i;
    			fraction[2] = fraction[2] / i;
    		}
    	}
    	//To eliminate any improper fractions, divide the top by the bottom to get the whole.
    	fraction[0] = fraction[1] / fraction[2];
    	//Then, find the remainder to make the new numerator.
    	fraction[1] = fraction[1] % fraction[2];
    	//Since the positive/negative sign is now represented by the whole, make the numerators and 
    	//denominators positive.
    	fraction[1] = Math.abs(fraction[1]);
    	fraction[2] = Math.abs(fraction[2]);
    }
}
