/* Carson Eshcne
 * March 9, 2018
 * A class that implements the Grid interface
 */
package textExcel;

// Update this file with your own code.

public class Spreadsheet implements Grid
{

	private Cell[][] cellArray;
	
	public Spreadsheet() {
		cellArray = new Cell[20][12];
		for(int i = 0; i < cellArray.length; i++) {
			for(int j = 0; j < cellArray[0].length; j++) {
				cellArray[i][j] = new EmptyCell();
			}
		}
	}
	@Override
	public String processCommand(String command)
	{
		// TODO Auto-generated method stub
		return "";
	}

	@Override
	public int getRows()
	{
		return cellArray.length;
	}

	@Override
	public int getCols()
	{
		return cellArray[0].length;
	}

	@Override
	public Cell getCell(Location loc)
	{
		return cellArray[loc.getRow()][loc.getCol()];
	}

	@Override
	public String getGridText()
	{
		String fullText = "   ";
		//Create the line of column headers
		for(int i = 0; i < cellArray.length; i++) {
			fullText += "|" + (i + 'A') + "        ";
		}
		fullText += "|\n";
		//Create the full grid, printing each cell's first 10 characters
		for(int i = 0; i < cellArray.length; i++) {
			fullText += i + " ";
			//Add an extra blank space for a single digit row number
			if(i < 10)
				fullText += " ";
			for(int j = 0; j < cellArray[0].length; j++) {
				//Create each cell with the pipe and cell text abbreviated to 10 characters
				fullText += "|" + cellArray[i][j].abbreviatedCellText();
				//Add blank space to fill the rest of the cell
				for(int k = 0; k < (10 - cellArray[i][j].abbreviatedCellText().length()); k++)
					fullText += " ";
			}
			fullText += "|\n";
		}
		return null;
	}

}
