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
	public static int toImproperFraction(int wholeNumber, int numerator, int denominator) {
		int newNumerator = wholeNumber * denominator + numerator;
		return newNumerator;
	}
 
}