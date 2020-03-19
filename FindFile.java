package Recursion;
import java.io.File;

/**
 * This searches through a file recursively. It searches through a directory
 * and if the file is in that directory, then it'll recurse the search method
 * and keeps going until the file is found. 
 * 
 * @author Sung Ho Park
 * Class: CSS 143 B
 * Assignment: Recursion
 */
public class FindFile
{
	//Instance variables
	private int maxFiles;
	
	//Available to the entire class
	private static int count = 0;	
	
	//ObjectList is the Arraylist that I created.
	private ObjectList fileList = new ObjectList(); 
	
	/**
	 * Constructor of maxFiles
	 * @param maxFiles
	 */
	public FindFile(int maxFiles)
	{
		setMaxFiles(maxFiles);
	}
	/**
	 * Precondition: There is a value in maxFiles.
	 * 
	 * Postcondition: returns the maxFiles.
	 * @param maxFiles
	 */
	public int getMaxFiles()
	{
		return maxFiles;
	}
	
	/**
	 * Precondition: There is a value in maxFiles.
	 * 
	 * Postcondition: returns the set maxFiles.
	 * @param maxFiles
	 */
	public void setMaxFiles(int maxFiles)
	{
		this.maxFiles = maxFiles;
	}
	
	/**
	 * This will recurse every time the target is inside of the directory. It
	 * will do so until it reaches the target. 
	 * 
	 * Precondition: There is a value in each parameter
	 * 
	 * Postcondition: recurses until the target is found. Once it reaches the 
	 * base case, then it will stop the recursion and go to the exception.
	 * Once it is thrown, in the main, it should print out that exception.
	 * Which indicates that the file was found and print out where the file is. 
	 * 
	 * @param dir
	 * @param target
	 */
	public void directorySearch(File dir, String target)
	{
		if(!(dir.isDirectory()))
		{
			//If file is not a directory, throw the exception.
			throw new IllegalArgumentException();
		}
		if(count == maxFiles)
		{
			//If count is equal to maxFiles, throw the exception.
			//If it doesn't then this will act as a base case to
			//the recursion. 
			throw new IllegalArgumentException();
		}
		
		try
		{
			//Put all the sub directories in an array. 
			File[] file = dir.listFiles();
			
			//Print out the path and the file directory list 
			System.out.println(dir.getPath() + ": " + dir.listFiles());
			
			//Go through each of the file length
			for(int i = 0; i < file.length; i++)
			{
				//Get the file name 
				System.out.println(" -- " + file[i].getName());
				
				//If the file name is the target, then add it to the 
				//stack and return
				if(file[i].getName().equals(target))
				{
					//If the item inside the file is the target.
					count++;
					fileList.add(file[i].getPath());
					return;
				}
				//If its a directory, then recurse.
				if(file[i].isDirectory())
				{
					directorySearch(file[i], target);
				}	
			}
			
		}
		catch (NullPointerException e)
		{
			//If the File[] is null then catch this exception.
			return;
		}
	}

	/**
	 * Precondition: There is a value in count.
	 * 
	 * Postcondition: returns count.
	 * 
	 * @return count 
	 */
	public int getCount()
	{
		return count;
	}
	
	/**
	 * Precondition: There are files.
	 * 
	 * Postcondition: Finds the file at a location
	 */
	public void getFiles()
	{
		if(fileList.size() == 0)
		{
			System.out.println("There is no file or file not found");
		}
		for(int i = 0; i < fileList.size(); i++)
		{
			System.out.println("File is at: " + fileList.get(i));
		}
	}

}
