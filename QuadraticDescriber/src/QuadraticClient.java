/* Carson Eschen
 * September 27, 2017
 * 2nd period
 * Quadratic equation describer client that accepts input from the user, and gives the output after calling
 * the quadrDescriber method.
 */


import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		String repeat = "";
		Scanner userInput = new Scanner(System.in);
		do {
			System.out.println("Hello! Enter the coefficients of a quadratic equation in standard form as the ");
			System.out.println("prompts direct to find the direction, the vertex, and the intercepts.");
			System.out.print("Please enter the coefficient of the x^2 term: ");
			double a = userInput.nextDouble();
			System.out.print("Please enter the coefficient of the x term: ");
			double b = userInput.nextDouble();
			System.out.print("Please enter the constant: ");
			double c = userInput.nextDouble();
			System.out.println(Quadratic.quadrDescriber(a, b, c));
			System.out.print("Would you like to enter another equation? Enter y or n: ");
			repeat = userInput.next();
		} while(repeat.equals("y"));
	}

}
