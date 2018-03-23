/* Carson Eschen
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
		//Split the command
		String[] splitCommand = command.split(" ", 3);
		//convert the part of the string that are not cell inputs to lowercase
		splitCommand[0] = splitCommand[0].toLowerCase();
		
		//Process which command to execute
		if(splitCommand.length == 1 && splitCommand[0].equals("clear")) {
			//Clear the entire sheet and return it
			for(int i = 0; i < cellArray.length; i++) {
				for(int j = 0; j < cellArray[0].length; j++) {
					cellArray[i][j] = new EmptyCell();
				}
			}
			return getGridText();
		}else if (splitCommand.length == 1) {
			//Cell inspection: return the value at that cell
			return cellArray[Integer.parseInt(splitCommand[0].substring(1)) - 1] [splitCommand[0].charAt(0) - 'a'].fullCellText();
		}else if(splitCommand[1].equals("=")){
			//Assign a value to a cell
			if(splitCommand[2].charAt(0) == '"') {
				//If it begins with quotation marks, assign it a text cell
				cellArray[Integer.parseInt(splitCommand[0].substring(1)) - 1] [splitCommand[0].charAt(0) - 'a'] = new TextCell(splitCommand[2]);
			}else if(splitCommand[2].charAt(0) == '(') {
				//If it begins with parantheses, assign it a formula cell
				cellArray[Integer.parseInt(splitCommand[0].substring(1)) - 1] [splitCommand[0].charAt(0) - 'a'] = new FormulaCell(splitCommand[2]);
			}else if(splitCommand[2].charAt(splitCommand[2].length() - 1) == '%') {
				//If it ends with a %, assign it a percent cell (minus the %)
				cellArray[Integer.parseInt(splitCommand[0].substring(1)) - 1] [splitCommand[0].charAt(0) - 'a'] = new PercentCell(splitCommand[2].substring(0, splitCommand[2].length() - 1));
			}else {
				//Otherwise, assign it a value cell
				cellArray[Integer.parseInt(splitCommand[0].substring(1)) - 1] [splitCommand[0].charAt(0) - 'a'] = new ValueCell(splitCommand[2]);
			}
			return getGridText();
		}else if(splitCommand[0].equals("clear")){
			//clear a particular cell and return the entire sheet
			//Change the cell location to be lowercase
			splitCommand[1] = splitCommand[1].toLowerCase();
			cellArray[Integer.parseInt(splitCommand[1].substring(1)) - 1] [splitCommand[1].charAt(0) - 'a'] = new EmptyCell();
			return getGridText();
		}else {
			return "That is not a valid command.";
		}
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
		for(int i = 0; i < cellArray[0].length; i++) {
			fullText += "|" + (char)(i + 'A') + "         ";
		}
		fullText += "|\n";
		//Create the full grid, printing each cell's first 10 characters
		for(int i = 1; i < cellArray.length + 1; i++) {
			fullText += i + " ";
			//Add an extra blank space for a single digit row number
			if(i < 10)
				fullText += " ";
			for(int j = 0; j < cellArray[0].length; j++) {
				//Create each cell with the pipe and cell text abbreviated to 10 characters
				fullText += "|" + cellArray[i - 1][j].abbreviatedCellText();
			}
			fullText += "|\n";
		}
		return fullText;
	}

}
