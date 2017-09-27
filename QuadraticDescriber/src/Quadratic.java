
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
		
		//Find the vertex by using the completeTheSquare method.
		String vertex = completeTheSquare(a, b, c);
		
		//Find the roots using the quadForm method.
		String interceptsX = quadForm(a, b, c);
		
		//Find the y-intercept using the constant.
		String interceptY = "The y-intercept is " + c;
		
			return direction + "\n" + vertex + "\n" + interceptsX + "\n" + interceptY;
	}

	public static String quadForm(double a, double b, double c) {
		if(discriminant(a,b,c) < 0) {
			return "No x-intercepts";
		}else if(discriminant(a,b,c) == 0) {
			double root = (-b + sqrt(discriminant(a,b,c))) / 2;
			double roundedRoot = round2(root);
			return "" + roundedRoot;
		}else {
			double root1 = (-b + sqrt(discriminant(a,b,c))) / (2 * a);
			double root2 = (-b - sqrt(discriminant(a,b,c))) / (2 * a);
			double roundedRoot1 = round2(root1);
			double roundedRoot2 = round2(root2);
			return "The x-intercepts are " + roundedRoot1 + " and " + roundedRoot2;
		}
	}
		
	public static double discriminant(double operandA, double operandB, double operandC) {
		double value = (operandB * operandB) - (4 * operandA * operandC);
		return value;
	}
	
	public static double round2(double operand) {
		if(operand % 0.01 > 0.00499999999){
			return (0.01 + operand - (operand % 0.01));
		}else if(operand % 0.01 < -0.004999999999 && operand < 0) {
			return (operand - (operand % 0.01) - 0.01);
		}
		else {
			return (operand - (operand % 0.01));
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
		double xCoordinate = -b / a / 2;
		double yCoordinate = c - ((xCoordinate * xCoordinate) * a);
		return "The vertex is at (" + xCoordinate + "," + yCoordinate + ").";
	}
}