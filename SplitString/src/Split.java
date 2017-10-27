import java.util.Arrays;

/* Carson Eschen
 * October 27, 2017
 * SplitString
 */
public class Split {
	
	public static void main(String[] args) {
		part1();
		part2();
	}

	public static void part1() {
		System.out.println("This is part 1.");
		String ingredients = "bread tomato bread bread";
		String[] split = ingredients.split("bread");
		if(split.length < 2) {
			System.out.println("There is nothing between slices of bread!");
		}else {
			for(int i = 1; i < split.length - 2; i++) {
				System.out.print(split[i] + ", ");
			}
			System.out.println(split[split.length - 2]);
		}

	}
	
	public static void part2() {
		System.out.println("");
		System.out.println("This is part 2");
		String ingredients = "bread cheese bread bread cheese";
		String[] ingredientList = ingredients.split(" ");
		int firstBreadPlace = 0;
		int lastBreadPlace = ingredientList.length - 1;
		while(!ingredientList[firstBreadPlace].equals("bread") && firstBreadPlace < ingredientList.length) {
			firstBreadPlace++;
		}
		while(!ingredientList[lastBreadPlace].equals("bread") && lastBreadPlace > 0) {
			lastBreadPlace--;
		}
		if(lastBreadPlace <= firstBreadPlace + 1) {
			System.out.println("There is nothing between slices of bread!");
		} else {
			while(firstBreadPlace + 3 <= lastBreadPlace) {
				System.out.print(ingredientList[firstBreadPlace + 1] + ", ");
				firstBreadPlace++;
			}
			System.out.println(ingredientList[lastBreadPlace - 1]);
		}
	}

}