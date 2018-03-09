/* Carson Eschen
 * March 7, 2018
 * Empty cell that implements the Cell interface
 */
package textExcel;

public class EmptyCell implements Cell {
	public String abbreviatedCellText() {
		return "";
		// text for spreadsheet cell display, must be exactly length 10
	}
	public String fullCellText() {
		// text for individual cell inspection, not truncated or padded
		return "";
	}
}
