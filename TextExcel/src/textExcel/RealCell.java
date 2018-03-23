package textExcel;

public abstract class RealCell implements Cell {
	
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
}
