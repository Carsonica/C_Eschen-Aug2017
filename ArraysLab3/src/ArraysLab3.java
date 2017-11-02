/*Carson Eschen
 * November 2, 2017
 * ArraysLab3 - create a variety of methods that modify arrays
 */

import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		//Declare the arrays and variables
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		//Print the results
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		//Create a new array of equal length to the original two.
		int[] arraySum = new int[arr1.length];
		//Create a loop that adds the numbers at each index together.
		for(int i = 0; i < arr1.length; i++) {
			arraySum[i] = arr1[i] + arr2[i];
		}
		return arraySum;
	}
	
	public static int[] append(int[] arr, int num) {
		//Create a new array of length one greater than the original
		int[] appendedArray = new int[arr.length + 1]; 
		//Set every index in the new array equal to the number in the same index of the old array
		for(int i = 0; i < arr.length; i++) {
			appendedArray[i] = arr[i];
		}
		//Set the final value of the new array equal to the number
		appendedArray[appendedArray.length - 1] = num;
		return appendedArray;
	}
	
	public static int[] remove(int[] arr, int idx) {
		//Create a new array of length one shorter than the original
		int[] removedArray = new int[arr.length - 1];
		//Create a loop to transfer every index less than the removed index to the new array.
		for(int i = 0; i < idx; i++) {
			removedArray[i] = arr[i];
		}
		//Create a loop to transfer every index greater than the removed index to the new array.
		for(int i = idx + 1; i < removedArray.length + 1; i++) {
			removedArray[i - 1] = arr[i];
		}
		return removedArray;
	}
	
	public static int sumEven(int[] arr) {
		int runningTotal = 0;
		//Make a loop that goes through every even, adding it to a running total.
		for (int i = 0; i < arr.length; i += 2) {
			runningTotal += arr[i];
		}
		return runningTotal;
	}
	
	public static void rotateRight(int[] arr) {
		//Save the final value of the array in a variable
		int lastNum = arr[arr.length - 1];
		//Use a decrementing loop to assign each index except the first number the value at the one 
		//to the left of it. 
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[ i - 1];
		}
		//Assign the previous final value to the new index 0.
		arr[0] = lastNum;
	}
}
