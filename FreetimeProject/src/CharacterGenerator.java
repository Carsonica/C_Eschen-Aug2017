//Carson Eschen's Character Generator

import java.util.*;
public class CharacterGenerator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in); 
		System.out.println("This method will randomly generate a party of any number of characters.");
		System.out.print("How large a party do you want to create?");
		int partySize = console.nextInt();
		for(int i = 0; i < partySize; i++) {
			System.out.print(createCharacter());
		}
	}
	public static String createCharacter() {
		
	}
}
