
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.trim().length() == 0) {
			response = "Hello darkness my old friend, I've come to talk with you again.";
		} else if (statement.indexOf("I'm") >= 0) {
			if(statement.charAt(statement.length() - 1) == '.' 
			|| statement.charAt(statement.length() - 1) == '?' 
			|| statement.charAt(statement.length() - 1) == '!') {
				response = "Hi " + statement.substring(statement.indexOf("I'm") + 4, statement.length() - 1) + ", I'm dad";
			} else {
				response = "Hi " + statement.substring(statement.indexOf("I'm") + 4, statement.length()) + ", I'm dad";
			}
		} else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} else if (statement.indexOf("Ms.") >= 0) {
			response = "She sounds like a good teacher.";
		} else if (statement.indexOf("Mr.") >= 0) {
			response = "He sounds like a good teacher.";
		} else if (statement.indexOf("Who you gonna call?") >= 0) {
			response = "Ghostbusters!";
		} else if (statement.indexOf("Antidisestablishmentarianism") >= 0) {
			response = "Wow, look at you with your fancy vocabulary.";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "But what about the droid attack on the Wookies?";
		} else if (whichResponse == 5) {
			response = "*yawn*";
		}

		return response;
	}
}
