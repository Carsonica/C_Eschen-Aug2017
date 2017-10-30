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
		String ingredients = "olive bread tomato lettuce bread";
		String[] split = ingredients.split("bread");
		if(split.length < 2) {
			System.out.println("There is nothing between slices of bread!");
		}else {
			for(int i = 1; i < split.length - 1; i++) {
				System.out.print(split[i] + ", ");
			}
			System.out.println(split[split.length - 1]);
		}

	}
	
	public static void part2() {
		System.out.println("");
		System.out.println("This is part 2");
		String ingredients = "bread cheese bread tomato chicken bread cheese";
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
				if(!ingredientList[firstBreadPlace + 1].equals("bread")) {
					System.out.print(ingredientList[firstBreadPlace + 1] + ", ");
				}
				firstBreadPlace++;
			}
			if(!ingredientList[firstBreadPlace + 1].equals("bread")) {
				System.out.println(ingredientList[lastBreadPlace - 1]);
			}
		}
	}

}