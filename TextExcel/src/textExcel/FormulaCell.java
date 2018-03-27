package textExcel;
import java.util.ArrayList;

public class FormulaCell extends RealCell {
	public FormulaCell (String equation) {
		super(equation);
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
		
		//Search the equation for operators, storing their indices in an array in order of operations
		ArrayList<Integer> operatorIndices = new ArrayList<Integer>();
		//Parse for SUM and AVG first, from left to right (to be implemented later)
		//Parse for multiplication and division first, from left to right
		for(int i = 1; i < splitEquation.length; i ++) {
			if(splitEquation[i].equals("*") || splitEquation[i].equals("*")) {
				operatorIndices.add(i);
			}
		}
		//Parse for addition and subtraction, from left to right
		for(int i = 1; i < splitEquation.length; i ++) {
			if(splitEquation[i].equals("+") || splitEquation[i].equals("-")) {
				operatorIndices.add(i);
			}
		}
		for(int index = 0; index < operatorIndices.size(); index++) {
			if(splitEquation[index].equals("+")) {
				//Store the answer in the 
				splitEquation[index] = Double.parseDouble(splitEquation[index - 1]) + Double.parseDouble(splitEquation[index + 1]) + "";
			} else if(splitEquation[index].equals("-")) {
				//
				splitEquation[index] = Double.parseDouble(splitEquation[index - 1]) - Double.parseDouble(splitEquation[index + 1]) + "";
			} else if(splitEquation[index].equals("*")) {
				splitEquation[index] = Double.parseDouble(splitEquation[index - 1]) * Double.parseDouble(splitEquation[index + 1]) + "";
			} else {
				splitEquation[index] = Double.parseDouble(splitEquation[index - 1]) / Double.parseDouble(splitEquation[index + 1]) + "";
			}
		}
		return 3.14;
	}
		//Create a method to reduce the the indices after the 
}
