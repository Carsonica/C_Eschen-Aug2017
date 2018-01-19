//Carson Eschen
//Generate attack rolls for testing purposes

import java.util.Random;

public class DamageTester {

	
	public static void main(String[] args) {
		
		Random rand = new Random();
		int sampleSize = 100;
		int numberOfDice = 1;
		int diceSize = 12;
		int totalSum = 0;
		
		for(int j = 0; j < sampleSize; j++) {
			int oneAttackSum = 0;
			for(int i = 0; i < numberOfDice; i++) {
				oneAttackSum += rand.nextInt(diceSize) + 1;
			}
		}

	}

}
