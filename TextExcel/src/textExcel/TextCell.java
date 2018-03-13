/* Carson Eschen
 * March 13, 2018
 * TextCell Class that implements the Cell interface and stores string values
 */

package textExcel;

public class TextCell implements Cell {

	private String cellText;
	
	public TextCell(String text) {
		cellText = text;
	}
	
	@Override
	public String abbreviatedCellText() {
		return cellText.substring(0, 9);
	}

	@Override
	public String fullCellText() {
		return "\"" + cellText + "\"";
	}

	
}
