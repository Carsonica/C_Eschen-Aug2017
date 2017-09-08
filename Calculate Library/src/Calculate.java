  /* Carson Eschen
 * September 6, 2017
 * Self-written math library. Contains a series of methods to do basic math
 * functions.
 */

public class Calculate {

	//Square the input
	public static int square(int operand) {
		return (operand * operand);
	}
	//Cube the input
	public static int cube(int operand) {
		return (operand * operand * operand);
	}
	//Average the two inputs
	public static double average(double operand1, double operand2) {
		double sum = operand1 + operand2;
		return sum / 2;
	}
	//Average the three inputs
	public static double average(double operand1, double operand2, double operand3) {
		double sum = operand1 + operand2 + operand3;
		return sum / 3;
	}
	//Convert radians to degrees
	public static double toDegrees(double operand) {
		return operand * 180 / 3.14159;
	}
	//Convert degrees to radians
	public static double toRadians(double operand) {
		return operand * 3.14159 / 180;
	}
	//Return the value of the discriminant
	public static double discriminant(double operandA, double operandB, double operandC) {
		double value = (operandB * operandB) - (4 * operandA * operandC);
		return value;
	}
	//Convert a mixed number to an improper fraction
	public static String toImproperFrac(int wholeNumber, int numerator, int denominator) {
		int newNumerator = wholeNumber * denominator + numerator;
		String newFraction = newNumerator + "/" + denominator;
		return newFraction;
	}
	//Convert an improper fraction to a mixed number
	public static String toMixedNum(int numerator, int denominator) {
		int wholeNum = numerator / denominator;
		int newNumerator = numerator % denominator;
		return wholeNum + "_" + newNumerator + "/" + denominator;
	}
	//FOIL out a binomial to create a quadratic equation
	public static String foil(int operand1, int operand2, int operand3, int operand4) {
		int coefficient1 = operand1 * operand3;
		int coefficient2 = operand1 * operand4 + operand2 * operand3;
		int constant = operand2 * operand4;
		return coefficient1 + "n^2 + " + coefficient2 + "n + " + constant;
	}
	//Determine whether the first number is evenly divisible by the second
	public static boolean isDivisibleBy(int dividend, int divisor) {
		return dividend % divisor == 0;
	}
	//Return the absolute value of a number
	public static double absValue(double operand) {
		if(operand<0) {
			operand = operand * -1;
		}
		return operand;
	}
	//Return the larger of two numbers
	public static double max(double operand1, double operand2) {
		if(operand1 >= operand2) {
			return operand1;
		}else {
			return operand2;
		}
	}
	//Return the largest of three numbers
	public static double max(double operand1, double operand2, double operand3) {
		double largerNum;
		if(operand1 >= operand2) {
			largerNum = operand1;
		}else {
			largerNum = operand2;
		}
		if(operand3 > largerNum) {
			return operand3;
		}else {
			return largerNum;
		}
	}
	//Return the smaller of two integers
	public static double min(double operand1, double operand2) {
		if(operand1 <= operand2) {
			return operand1;
		}else {
			return operand2;
		}
	}
	//Round a number to two decimal places
	public static double round2(double operand) {
		if((operand * 1000) % 10 < 5) {
			return(operand - (operand % 0.01));
		}
	}
}