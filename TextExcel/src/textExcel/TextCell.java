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
		if(cellText.length() > 12){
			return cellText.substring(1, 11);
		}else {
			return cellText.substring(1, cellText.length() - 1);
		}
	}

	@Override
	public String fullCellText() {
		return cellText;
	}

	
}
