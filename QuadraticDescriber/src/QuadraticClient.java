import java.util.*;

public class QuadraticClient {

	public static void main(String[] args) {
		Scanner userInput = new Scanner(System.in);
		System.out.println("Hello! Enter the coefficients of a quadratic equation in standard form as the ");
		System.out.println("prompts direct to find the direction, the vertex, and the intercepts.");
		System.out.print("Please enter the coefficient of the x^2 term");
		double a = userInput.nextDouble();
		System.out.print("Please enter the coefficient of the x term");
		double b = userInput.nextDouble();
		System.out.print("Please enter the constant");
		double c = userInput.nextDouble();
		Quadratic.quadrDescriber(a, b, c);
	}

}
