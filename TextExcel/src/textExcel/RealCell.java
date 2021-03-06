package textExcel;

public abstract class RealCell implements Cell, Comparable {
	
	//Hold a string for the value
	private String value;
	
	public RealCell(String value) {
		this.value = value;
	}
	
	@Override
	public abstract String abbreviatedCellText();

	@Override
	public String fullCellText() {
		return value;
	}
	
	//Return the value of the cell as a double
	public double getDoubleValue() {
		return Double.parseDouble(value);
	}
	
	//Compare the value of this cell to another RealCell, returning 1 if this cell is greater, 
	//-1 if the parameter cell is greater, or 0 if they are the same
	public int compareTo(Object cell) {
		
	}
}
