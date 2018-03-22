package textExcel;

public abstract class RealCell implements Cell {
	
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
	
	public String getValue() {
		return value;
	}
}
