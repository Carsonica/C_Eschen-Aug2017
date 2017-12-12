/*Carson Eschen
 * December 11, 2017
 * Rewrite fracCalc using objects
 */

package fracCalc;

import java.util.Scanner;

class Fraction {
	//Create fields for the whole, numerator, denominator, and positive/negative sign.
	private int sign = 1;
	private int whole = 0;
	private int numerator = 0;
	private int denominator = 1;
	Fraction(String fraction){
		//Find the index of the underscore and slash
		int underscorePlace = fraction.indexOf("_");
        int slashPlace = fraction.indexOf("/");
        //If there is an underscore...
        if(underscorePlace >= 0) {
        	//...set the variable for the whole equal to the number before the underscore...
        	whole = Integer.parseInt(fraction.substring(0, underscorePlace));
        	//...set the numerator equal to the number after the underscore and before the slash
        	numerator = Integer.parseInt(fraction.substring(underscorePlace + 1, slashPlace));
       		//...and set the denominator equal to the number after the slash
        		denominator = Integer.parseInt(fraction.substring(slashPlace + 1));
        } 
        
        //If there is only a slash...
        else if(slashPlace >= 0) {
        	//...set the numerator equal to the number before the slash...
        	numerator = Integer.parseInt(fraction.substring(0, slashPlace));
        	//...and set the denominator equal to the number after the slash.
    		denominator = Integer.parseInt(fraction.substring(slashPlace + 1, fraction.length()));
        } 
        
        //If there is no slash or underscore...
        else {
        	//...set the whole to the number put in.
        	whole = Integer.parseInt(fraction);
        
        }
        sign = whole / Math.abs(whole);
        whole = Math.abs(whole);
	}
}

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
    public static String produceAnswer(String input)
    { 
    	//Split the input into parts
        String[] splitInput = input.trim().split(" ");
      //Check to see if the sum of operators and s is odd. If not, return an error
        if(splitInput.length % 2 == 0) {
        	return "ERROR: The number of operators and s is invalid.";
        }
        return "";
    }

    // TODO: Fill in the space below with any helper methods that you think you will need
    
}
