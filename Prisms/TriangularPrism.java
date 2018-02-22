/* Carson Eschen
 * Feb 22, 2018
 * Prism subclass 
 */

public class TriangularPrism extends Prism {
	private double sideA;
	private double sideB;
	private double sideC;
	
	public TriangularPrism (double sideA, double sideB, double sideC, double height) {
		super(height);
		this.sideA = sideA;
		this.sideB = sideB;
		this.sideC = sideC;
	}
	
	public double calcAreaOfBase() {
		//Find half the perimeter
		double s = calcPerimeter() / 2;
		//Use it to find the area using Heron's Formula
		return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
	}
	
	public double calcPerimeter() {
		//Add all sides together to get the perimeter
		return sideA + sideB + sideC;
	}
	
}
