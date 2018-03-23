package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String value) {
		//Store the percent as a decimal equivalent (subtracting the percent symbol)
		super("" + Double.parseDouble(value) / 100);
	}
	
	public String abbreviatedCellText() {
		//Convert the stored decimal back to its percent
		String returnValue = ((int) (getDoubleValue() * 100) + "%");
		//If the string is too long for the cell, truncate
		if(returnValue.length() > 10) {
			returnValue = returnValue.substring(0, returnValue.length());
		}
		//Add empty spaces to fill the rest of the cell
		while(returnValue.length() < 10) {
			returnValue += " ";
		}
		return returnValue;
	}
}
