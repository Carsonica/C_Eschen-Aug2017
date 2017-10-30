/* Carson Eschen
 * October 30, 2017
 * Array Mini-lab
 */
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
	}
	
	public static void changeMe(int x, String str, int[] arr) {
		x = 8;
		str = str + " is cool";
		for(int i = 0; i < arr.length; i++) {
			arr[i]++;
		}		
	}
}

