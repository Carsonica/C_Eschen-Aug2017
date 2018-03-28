package textExcel;
import java.util.ArrayList;

public class FormulaCell extends RealCell {
	private Spreadsheet sourceSheet;
	
	public FormulaCell (String equation, Spreadsheet sourceSheet) {
		super(equation);
		this.sourceSheet = sourceSheet;
	}
	
	public String abbreviatedCellText() {
		//Return the first 10 characters of the decimal, adding spaces as needed to fill the cell
			String returnValue = "" + getDoubleValue();
			if(("" + getDoubleValue()).length() > 9) { 
				returnValue = ("" + getDoubleValue()).substring(0, 10);
			}
			while(returnValue.length() < 10) {
				returnValue += " ";
			}
			return returnValue;
		}
	
	public double getDoubleValue() {
		//Split the equation at the spaces
		String[] splitEquation = fullCellText().trim().split(" ");
		
		//Store the values in an arrayList so the unneeded values can be removed
		ArrayList<String> equationAsList = new ArrayList<String>();
		for(int i = 0; i < splitEquation.length; i++) {
			equationAsList.add(splitEquation[i]);
		}
		//Change all the letters in the equation to lowercase
		for(int i = 0; i < equationAsList.size(); i++) {
			equationAsList.set(i, equationAsList.get(i).toLowerCase());
		}
		//Parse for cell references, converting them to double values
		for(int i = 0; i < equationAsList.size(); i ++) {
			if(equationAsList.get(i).charAt(0) >= 'a' && equationAsList.get(i).charAt(0) <= 'l') {
				SpreadsheetLocation sLocation = new SpreadsheetLocation(equationAsList.get(i));
				if(sourceSheet.getCell(sLocation) instanceof RealCell) {
					RealCell rCell = (RealCell) sourceSheet.getCell(sLocation);
					equationAsList.set(i, rCell.getDoubleValue() + "");
				}
				
			}
		}
		//Parse for SUM and AVG first, from left to right
		for(int i = 1; i < equationAsList.size(); i++) {
			if(equationAsList.get(i).equals("SUM")) {
				double sum = sum(equationAsList.get(i + 1));
				equationAsList.set(i, sum + "");
				equationAsList.remove(i + 1);
			}
		}
		//Parse for multiplication and division from left to right, executing them where found
		for(int i = 1; i < equationAsList.size(); i ++) {
			if(equationAsList.get(i).equals("*") || equationAsList.get(i).equals("/") || equationAsList.get(i).equals("+") || equationAsList.get(i).equals("-")) {
				if(equationAsList.get(i).equals("*")) {
					equationAsList.set(i, Double.parseDouble(equationAsList.get(i - 1)) * Double.parseDouble(equationAsList.get(i + 1)) + "");
				}else if (equationAsList.get(i).equals("/")) {
					equationAsList.set(i, Double.parseDouble(equationAsList.get(i - 1)) / Double.parseDouble(equationAsList.get(i + 1)) + "");
				}else if (equationAsList.get(i).equals("+")) {
					equationAsList.set(i, Double.parseDouble(equationAsList.get(i - 1)) + Double.parseDouble(equationAsList.get(i + 1)) + "");
				}else if (equationAsList.get(i).equals("-")) {
					equationAsList.set(i, Double.parseDouble(equationAsList.get(i - 1)) - Double.parseDouble(equationAsList.get(i + 1)) + "");
				}
				equationAsList.remove(i + 1);
				equationAsList.remove(i - 1);
				i -= 3;
			}
		}
		//Parse for addition and subtraction from left to right, executing them where found
		/* for(int i = 1; i < splitEquation.length; i ++) {
			if(splitEquation[i].equals("+") || splitEquation[i].equals("-")) {
			
			}
		} 
		*/
		return Double.parseDouble(equationAsList.get(1));
	}
	private double sum(String range) {
		String lowestCell = range.substring(0, range.indexOf("-"));
		String highestCell = range.substring(range.indexOf("-"));
		double total = 0;
		
		return 3.3;
	}
}
