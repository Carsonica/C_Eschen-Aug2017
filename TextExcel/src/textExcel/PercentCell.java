package textExcel;

public class PercentCell extends RealCell {
	
	public PercentCell(String value) {
		//Store the percent as a decimal equivalent
		super("" + Double.parseDouble(value) / 100);
	}
	
	public String abbreviatedCellText() {
		//Convert the stored decimal back to its percent and truncate
		String returnValue = ((int) (Double.parseDouble(getValue()) * 100) + "%").substring(0, 9);
		//Add empty spaces to fill the rest of the cell
		for(int k = 0; k < (10 - returnValue.length()); k++) {
			returnValue += " ";
		}
		return returnValue;
	}
}
