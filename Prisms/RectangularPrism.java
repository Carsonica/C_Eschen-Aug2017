/* Carson Eschen
 * Feb 22, 2018
 * Prism subclass 
 */

public class RectangularPrism extends Prism{
	private double length;
	private double width;
	
	public RectangularPrism(double height, double length, double width) {
		super(height);
		this.length = length;
		this.width = width;
	}
	
	public double calcAreaOfBase() {
		return length * width;
	}
	
	public double calcPerimeter() {
		return 2 * length + 2 * width;
	}
}

