package textExcel;

public class FormulaCell extends RealCell {
	public FormulaCell (String equation) {
		super(equation);
	}
	
	public String abbreviatedCellText() {
		return "IAmFormula";
	}
	
	public double getDoubleValue() {
		return 3.14;
	}
}
