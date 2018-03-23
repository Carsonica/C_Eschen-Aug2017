package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value) {
		super(value);
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
}
