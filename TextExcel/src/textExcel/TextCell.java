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
		if(cellText.length() > 10){
			return cellText.substring(0, 9);
		}else {
			return cellText;
		}
	}

	@Override
	public String fullCellText() {
		return "\"" + cellText + "\"";
	}

	
}
