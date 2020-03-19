package Recursion;

import java.io.File;

/**
 * This is the main driver for the FindFile class. This will recursively 
 * search through the files in the computer. Since this was done in a MacBook,
 * the path is different than the path in Windows Computers. After the target
 * is found, it will tell you where the file is.
 * 
 * Known Bugs: None. 
 * 
 * Note: The code works and it compiles and runs properly, but since the code
 * is done by searching in a MacBook, the path way is different. On top of that
 * the code searches on a specific computer. 
 * 
 * Apple Pathway: "/User/nameofcomputer/Desktop"
 * Windows: "C:\\" 
 * 
 * I also used the 48 hour extension on this hw. 
 * 
 * @author Sung Ho Park
 * Class: CSS 143 B
 * Assignment: Recursion
 */
public class FindFileDriver
{
	/**
	 * This is the main driver for the FindFile class.
	 * @param arg
	 */
	public static void main(String[] arg)
	{
		//Searching for just one file and if there are multiple, 
		//print where both of them are. 
		FindFile file = new FindFile(2);
		try
		{
			//I have a MacBook, so I have to use "/Users/sunghopark/Desktop"
			//in order to search through the files on anything Apple related
			//But I understand that if I have a windows computer or another 
			//computer that is not Apple, then it'd be "C:\\"
			file.directorySearch(new File("/Users/sunghopark/Desktop"), 
					"fractions.txt");
			//Print out the files
			file.getFiles();
		}
		catch(IllegalArgumentException e)
		{
			//This will give you an exception, but it will tell you where 
			//the file is if it is found. If not then it'll print something
			//else
			
			//I also have 2 fractions.txt files in my computer so it shouldn't 
			//throw this exception.
			System.out.println("\nIllegalArgumentException");
			file.getFiles();
		}
	}
}
