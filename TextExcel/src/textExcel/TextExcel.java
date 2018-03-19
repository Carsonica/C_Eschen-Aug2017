/* Carson Eschen
 * March 9, 2018
 * A class the constructs a Spreadsheet and implements the command loop.
 */
package textExcel;

import java.io.FileNotFoundException;
import java.util.Scanner;

// Update this file with your own code.

public class TextExcel
{

	public static void main(String[] args)
	{
	    Scanner input = new Scanner(System.in);
	    boolean runAgain = true;
	    Spreadsheet sheet = new Spreadsheet();
	    
	    TestsALL.Helper th = new TestsALL.Helper();
	    System.out.println(th.getText());
	    
	    while(runAgain) {
	    	System.out.println("Please enter a command: ");
	    	String command = input.nextLine();
	    	if(command.equals("quit")) {
	    		runAgain = false;
	    	}else {
	    		System.out.println(sheet.processCommand(command));
	    	}
	    }
	}
}
