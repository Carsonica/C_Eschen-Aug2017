import java.util.Arrays;

public class ArraysLab3 {

	public static void main(String[] args) {
		int[] a1 = {5, 10, 15, 20, 25, 30, 35, 40};
		int[] a2 = {7, 14, 21, 28, 35, 42, 49, 56};
		int[] sumArr = sum(a1, a2);
		int appendNum = 200;
		int[] appendArr = append(a1, appendNum);
		int removeIdx = 5;
		int[] removeArr = remove(a2, removeIdx);
		int sumOfEvens = sumEven(appendArr);
		rotateRight(a1);
		System.out.println(Arrays.toString(sumArr));
		System.out.println(Arrays.toString(appendArr));
		System.out.println(Arrays.toString(removeArr));
		System.out.println(sumOfEvens);
		System.out.println(Arrays.toString(a1));
	}
	
	public static int[] sum(int[] arr1, int[] arr2) {
		int[] arraySum = new int[arr1.length];
		for(int i = 0; i < arr1.length; i++) {
			arraySum[i] = arr1[i] + arr2[i];
		}
		return arraySum;
	}
	
	public static int[] append(int[] arr, int num) {
		int[] appendedArray = new int[arr.length + 1]; 
		for(int i = 0; i < arr.length; i++) {
			appendedArray[i] = arr[i];
		}
		appendedArray[appendedArray.length - 1] = num;
		return appendedArray;
	}
	
	public static int[] remove(int[] arr, int idx) {
		int[] removedArray = new int[arr.length - 1];
		for(int i = 0; i < idx; i++) {
			removedArray[i] = arr[i];
		}
		for(int i = idx + 1; i < removedArray.length + 1; i++) {
			removedArray[i - 1] = arr[i];
		}
		return removedArray;
	}
	
	public static int sumEven(int[] arr) {
		int runningTotal = 0;
		for (int i = 0; i < arr.length; i += 2) {
			runningTotal += arr[i];
		}
		return runningTotal;
	}
	
	public static void rotateRight(int[] arr) {
		int lastNum = arr[arr.length - 1];
		for(int i = arr.length - 1; i > 0; i--) {
			arr[i] = arr[i-1];
		}
		arr[0] = lastNum;
	}
}
