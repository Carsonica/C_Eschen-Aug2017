/* Carson Eschen
 * October 30, 2017
 * Array Mini-lab
 */

import java.util.Arrays;
public class LotsOfCopies {
	public static void main(String[] args) {
		int num = 7;
		String strMain = "APCS";
		int[] arrMain = {1, 2, 3, 4, 5};
		changeMe(num, strMain, arrMain);
		System.out.println(num + strMain);
		for(int i = 0; i < arrMain.length; i++) {
			System.out.print(arrMain[i] + " ");
		}
		int a = num;
		num = 8;
		System.out.println(a);
		String newString = strMain;
		strMain += " is supercool";
		System.out.println(newString);
		int[] newArray = arrMain;
		for(int i = 0; i < arrMain.length; i++) {
			arrMain[i] *= 2;
		}
		System.out.println(Arrays.toString(newArray));
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x = 8;
		str = str + " is cool";
		for(int i = 0; i < arr.length; i++) {
			arr[i]++;
		}		
	}
}

