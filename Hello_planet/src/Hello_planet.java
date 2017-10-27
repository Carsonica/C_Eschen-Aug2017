
public class Hello_planet {

	public static void main(String[] args) {
		String word = "ABRACADABRA";
		String newWord = "";
		int place = 0;
		while(place < word.length()) {
			if(place + 1 == word.length()) {
				newWord += word.charAt(place);
				place++;
			} else if(word.charAt(place) == 'A' && word.charAt(place + 1) != 'A') {
				newWord += word.charAt(place + 1); 
				newWord += word.charAt(place);
				place += 2;
			} else {
				newWord += word.charAt(place);
				place++;
			}
		}
		System.out.print(newWord);
	}

}
