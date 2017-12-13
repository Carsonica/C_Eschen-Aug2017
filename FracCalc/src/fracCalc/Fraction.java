package fracCalc;

class Fraction {
	//Create fields for the numerator and denominator.
	private int numerator = 0;
	private int denominator = 1;
	
	//Create a constructor that will parse an input string and turn it into an improper fraction.
	Fraction(String fraction){
		//Create temporary storage for the whole number, with a default of 0.
		int whole = 0;
		//Find the index of the underscore and slash
		int underscorePlace = fraction.indexOf("_");
        int slashPlace = fraction.indexOf("/");
        //If there is an underscore...
        if(underscorePlace >= 0) {
        	//...set the variable for the whole equal to the number before the underscore...
        	whole = Integer.parseInt(fraction.substring(0, underscorePlace));
        	//...set the numerator equal to the number after the underscore and before the slash
        	numerator = Integer.parseInt(fraction.substring(underscorePlace + 1, slashPlace));
       		//...and set the denominator equal to the number after the slash
        		denominator = Integer.parseInt(fraction.substring(slashPlace + 1));
        } 
        
        //If there is only a slash...
        else if(slashPlace >= 0) {
        	//...set the numerator equal to the number before the slash...
        	numerator = Integer.parseInt(fraction.substring(0, slashPlace));
        	//...and set the denominator equal to the number after the slash.
    		denominator = Integer.parseInt(fraction.substring(slashPlace + 1, fraction.length()));
        } 
        
        //If there is no slash or underscore...
        else {
        	//...set the whole to the number put in.
        	whole = Integer.parseInt(fraction);
        
        }
        //Determine the numerator of the equivalent improper fraction
        if(whole < 0) {
        	numerator *= -1;
        }
        numerator += whole * denominator;
	}
	
	//Create a toString method that will put out the answer as a fully reduced mixed fraction.
	public String toString(){
		//Simplify the fraction
		//For each integer equal to or less than the denominator (but greater than 1), check to see if
    	//both the numerator and denominator are both divisible by it. If so, divide both by the number.
    	 for(int i = Math.abs(denominator); i > 1; i--) {
    		if(numerator % i == 0 && denominator % i == 0) {
    			numerator = numerator / i;
    			denominator = denominator / i;
    		}
    	}
		//Calculate the whole number
		int whole = numerator / denominator;
		//Use the remainder to find the new numerator
		numerator = numerator % denominator;
		//If the whole exists, set the numerator and denominator to their absolute value.
		if(whole != 0) {
    		numerator = Math.abs(numerator);
    		denominator = Math.abs(denominator);
    	} 
    	//Else, if the denominator is negative, change the numerator's sign.
    	else if(denominator < 0){
    		numerator *= -1;
    		denominator = Math.abs(denominator);
    	}
		//Check which values are 0 to return the simplified value without them.
        if(whole == 0) {
        	if(numerator == 0) {
        		//If the whole and numerator are 0, return 0.
        		return "0";
        	}else {
        		//If the whole is 0, but the numerator is not, return just the fraction
        		return numerator + "/" + denominator;
        	}
        }else if(numerator == 0) {
        	//If the numerator is 0, but the whole is not, return justs the whole
        	return "" + whole;
        }else {
        	//If none of the values are 0, return all the values
        	return whole + "_" + numerator + "/" + denominator;
        }
	}
	//Standard accessor and mutator methods for the numerator and denominator
	public int getNumerator() {
		return numerator;
	}
	public int getDenominator() {
		return denominator;
	}
	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}
	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	//Turn the fraction negative (or positive, if already negative)
	public void flipSign() {
		numerator *=-1;
	}
	
	//Set the fraction to its reciprocal
	public void setReciprocal() {
		int numerator = this.numerator;
		this.numerator = this.denominator;
		this.denominator = numerator;
	}
}