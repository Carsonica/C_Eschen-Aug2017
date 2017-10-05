/* Carson Eschen
 * October 4, 2017
 * Write a collaborative program that accepts input, finds the maximum and minimum values,
 * sums all the even numbers, and prints the largest number
 */

import java.util.*; 

public class Collab {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		//Initialize all the necessary variables.
		double max = 0;
		double min = 0;
		double sumEven = 0;
		double evenMax = 0;
		//Create a boolean to ensure minimum and maximum will be set equal to at least one valid input.
		boolean firstTime = true;
		//Create a boolean to ensure the even maximum will be set equal to at least one valid input.
		boolean firstEven = true;
		//Create a boolean that will allow the user to decide when the program should stop
		boolean doneYet = false;
		do {
			System.out.print("Enter the next number: ");
			double number = input.nextDouble();
			//Check if the number is smaller than the previous smallest, or the first number entered
			if(number < min || firstTime) {
				min = number;
			}
			//Check if the number is larger than the previous largest, or the first number entered
			if(number > max || firstTime) {
				max = number;
			}
			//Check if the number is even
			if(number % 2 == 0) {
				//Add to the running total of evens.
				sumEven += number;
				if(number > evenMax || firstEven) {
					evenMax = number;
				}
				firstEven = false;
			}
			//Determine whether the user is done entering numbers.
			System.out.print("Would you like to input another number? Type yes or no: ");
			String repeat = input.next();
			if(repeat.equals("no")) {
				doneYet = true;
			}
			firstTime = false;
		} while(!doneYet);	
		System.out.println("The largest number entered is: " + max);
		System.out.println("The smallest number entered is: " + min);
		System.out.println("The sum of all the even numbers entered is: " + sumEven);
		System.out.println("The largest even number entered is: " + evenMax);

	}

}
