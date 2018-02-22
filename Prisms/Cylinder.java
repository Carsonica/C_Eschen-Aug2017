/* Carson Eschen
 * Feb 22, 2018
 * Prism subclass 
 */

public class Cylinder extends Prism {
	private double radius;
	
	public Cylinder(double radius, double height) {
		super(height);
		this.radius = radius;
	}
	
	public double calcAreaOfBase() {
		return radius * radius * Math.PI;
	}
	
	public double calcPerimeter() {
		return radius * 2 * Math.PI;
	}
}
