/* Carson Eschen
 * March 9 2017
 * A class that implements the Location interface
 */

package textExcel;
//Update this file with your own code.

public class SpreadsheetLocation implements Location
{
	private int row;
	private int column;
    @Override
    public int getRow()
    {
        // TODO Auto-generated method stub
        return row;
    }

    @Override
    public int getCol()
    {
        // TODO Auto-generated method stub
        return column;
    }
    
    public SpreadsheetLocation(String cellName)
    {
        row = Integer.parseInt(cellName.substring(1)) - 1;
        column = cellName.charAt(0) - 'a';
    }

}
