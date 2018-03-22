package textExcel;

public class ValueCell extends RealCell {
	
	public ValueCell(String value) {
		super(value);
	}
	
	public String abbreviatedCellText() {
		//Return the first 10 characters of the decimal, adding spaces as needed
		String returnValue = getValue().substring(0, 9);
		for(int k = 0; k < (10 - returnValue.length()); k++) {
			returnValue += " ";
		}
		return returnValue;
	}
}
