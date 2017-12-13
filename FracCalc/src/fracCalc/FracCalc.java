/*Carson Eschen
 * December 11, 2017
 * Rewrite fracCalc using objects
 */

package fracCalc;

import java.util.Scanner;

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
	
    public static String produceAnswer(String input)
    { 
    	//Split the input into parts
        String[] splitInput = input.trim().split(" ");
      //Check to see if the sum of operators and operands is odd. If not, return an error
        if(splitInput.length % 2 == 0) {
        	return "ERROR: The number of operators and operands is invalid.";
        }
        //Create an object with the values from the leftmost fraction
        Fraction firstOperand = new Fraction(splitInput[0]);
        //Create a loop to repeat all the steps a number of times equal to half the number of inputs,
        //rounded down, in order to account for the number of operators.
        for(int i = 0; i * 2 + 1 < splitInput.length; i++) {
        	//Create an object with the values from the second leftmost fraction
        	Fraction secondOperand = new Fraction(splitInput[2]);
        	//Check which operator was put in to determine which method to use.
        	if(splitInput[1].equals("+")) {
        		fracAddition(firstOperand, secondOperand);
        	} else if(splitInput[1].equals("-")) {
        		//Make the second operator negative before calling addition
        		secondOperand.flipSign();
        		fracAddition(firstOperand, secondOperand);
        	} else if(splitInput[1].equals("*")) {
        		fracMultiplication(firstOperand, secondOperand);
        	} else if(splitInput[1].equals("/")) {
        		secondOperand.setReciprocal();
        		fracMultiplication(firstOperand, secondOperand);
        	} else {
        		return "ERROR: Invalid operator or format.";
        	}
        	//Shift every value except the first two spaces to the left to allow multiple operations.
        	for(int j = 1; j < splitInput.length - 2; j++) {
	        	splitInput[j] = splitInput[j + 2];
	        }
        }
        return firstOperand.toString();
       
    }
    
    //Add the two fraction objects, where each one represents a fraction
    //Order: whole, numerator, denominator
    public static void fracAddition(Fraction firstOperand, Fraction secondOperand) {
    	//Get the numerators and denominators of each fraction object
    	int numerator1 = firstOperand.getNumerator();
    	int denominator1 = firstOperand.getDenominator();
    	int numerator2 = secondOperand.getNumerator();
    	int denominator2 = secondOperand.getDenominator();
    	//Collapse the resulting sum into the leftmost fraction object:
    	//Find a common denominator using the denominators of each object
    	firstOperand.setDenominator(denominator1 * denominator2);
    	//Find the numerator of the sum
    	firstOperand.setNumerator(numerator1 * denominator2 + denominator1 * numerator2);
    	

    }
    
    //Multiply the two input arrays, where each one represents a mixed number
    //Order: whole, numerator, denominator
    public static void fracMultiplication(Fraction firstOperand, Fraction secondOperand) {
    	//Multiply the numerators and the denominators individually, collapsing the result into
    	//the leftmost fraction object.
    	firstOperand.setNumerator(firstOperand.getNumerator() * secondOperand.getNumerator());
    	firstOperand.setDenominator(firstOperand.getDenominator() * secondOperand.getDenominator());
    }
    
}
