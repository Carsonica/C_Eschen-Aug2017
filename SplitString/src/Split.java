import java.util.Arrays;

/* Carson Eschen
 * October 27, 2017
 * SplitString
 */
public class Split {

	public static void main(String[] args) {
		String ingredients = "bread";
		String[] split = ingredients.split("bread");
		if(split.length < 2) {
			System.out.println("Nothing is between slices of bread");
		}else {
			for(int i = 1; i < split.length - 2; i++) {
				System.out.print(split[i] + ", ");
			}
			System.out.print(split[split.length - 2]);
		}

	}

}
