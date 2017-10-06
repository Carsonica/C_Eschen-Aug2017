/* Carson Eschen
 * September 27, 2017
 * 2nd period
 * Quadratic equation describer that calculates the intercepts, direction, and vertex of a quadratic
 * equation, given the coefficients.
 */

public class Quadratic {
	public static String quadrDescriber (double a, double b, double c) {
		//Check if the coefficients actually give a quadratic equation.
		if(a == 0) {
			throw new IllegalArgumentException("The coefficient of x^2 cannot be 0 for a quadratic equation.");
		}
		
		//Check if the graph opens up or down.
		String direction = "";
		if(a < 0) {
			direction = "The graph opens down.";
		} else {
			direction = "The graph opens up.";
		}
		//Find the axis of symmetry
		String axisOfSym = "The axis of symmetry is x = " + round2((-b / a / 2));
		
		//Find the vertex by using the completeTheSquare method.
		String vertex = completeTheSquare(a, b, c);
		
		//Find the roots using the quadForm method.
		String interceptsX = quadForm(a, b, c);
		
		//Find the y-intercept using the constant.
		String interceptY = "The y-intercept is (0.0, " + c + ").";
		
		return direction + "\n" + axisOfSym + "\n" + vertex + "\n" + interceptsX + "\n" + interceptY;
	}

	public static String quadForm(double a, double b, double c) {
		if(discriminant(a,b,c) < 0) {
			return "No x-intercepts";
		}else if(discriminant(a,b,c) == 0) {
			double root = (-b + sqrt(discriminant(a,b,c))) / 2;
			double roundedRoot = round2(root);
			return "The only x-intercept is (" + roundedRoot + ", 0.0).";
		}else {
			double root1 = (-b + sqrt(discriminant(a,b,c))) / (2 * a);
			double root2 = (-b - sqrt(discriminant(a,b,c))) / (2 * a);
			double roundedRoot1 = round2(root1);
			double roundedRoot2 = round2(root2);
			return "The x-intercepts are (" + roundedRoot1 + ", 0.0) and (" + roundedRoot2 + ", 0.0).";
		}
	}
		
	public static double discriminant(double operandA, double operandB, double operandC) {
		double value = (operandB * operandB) - (4 * operandA * operandC);
		return value;
	}
	
	public static double round2(double operand) {
		//Change the hundredths place to the ones place
		operand = operand * 100;
		//Check if you need to run up or down, do so, then cast to an int to remove the extra digits.
		//Finally, divide by 100.0 to change the decimal place back to where it should be.
		if(operand % 1 >= 0.5 && operand > 0) {
			return ((int) (1 + operand)) / 100.0;
		}else if(operand % 1 <= -0.5 && operand < 0) {
			return ((int) (operand - 1)) / 100.0;
		}
		else {
			return ((int) (operand)) / 100.0;
		}
	}
	
	public static double sqrt(double operand) {
		if(operand < 0) {
			throw new IllegalArgumentException("Cannot find the square root of a negative value");
		}
		double i;
		for(i = 0; (i * i) < operand; i++) {}
		while(i * i > operand) {
			i -= 0.1;
		}
		while(i * i < operand) {
			i += 0.01;
		}
		while(i * i > operand) {
			i -= 0.001;
		}
		i = round2(i);
		return i;
	}
	
	public static double min(double operand1, double operand2) {
		if(operand1 <= operand2) {
			return operand1;
		}else {
			return operand2;
		}
	}
	
	public static String completeTheSquare(double a, double b, double c) {
		double xCoordinate = round2(-b / a / 2);
		double yCoordinate = round2(c - ((xCoordinate * xCoordinate) * a));
		return "The vertex is at (" + xCoordinate + "," + yCoordinate + ").";
	}
}