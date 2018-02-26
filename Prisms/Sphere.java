//Carson Eschen

public class Sphere extends ThreeDShape {
	private double radius;
	
	public Sphere(double radius) {
		this.radius = radius;
	}
	
	public double calcVolume() {
		return calcSA() * radius / 3;
	}

	public double calcSA() {
		return 4 * Math.PI * radius * radius;
	}
}
