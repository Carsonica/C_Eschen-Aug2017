/* Carson Eschen
 * September 6, 2017
 * This is the runner for the calculate library.
 * It is  used to test the methods in Calculate.
 */

public class DoMath {

	public static void main(String[] args) {
		//System.out.println(Calculate.square(5));
		//System.out.println(Calculate.cube(5));
		//System.out.println(Calculate.average(3.4, 4.8));
		//System.out.println(Calculate.average(2.3, 4.0, 3.5));
		//System.out.println(Calculate.toDegrees(3.14159));
		System.out.println(Calculate.toRadians(180.0));
		System.out.println(Calculate.discriminant(3, 6, -8));
		System.out.println(Calculate.toImproperFraction(3, 1, 4));
	}

}
