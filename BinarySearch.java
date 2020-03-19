package Recursion;

/**
 * This is the Binary Search class. A binary search is finding a value by
 * cutting an array in half and depending on which half the value is in, 
 * the binary search will disregard the half that the value doesn't have. 
 * This is repeated until the value is found.
 * 
 * The method search is an iterative search which will not use recursion.
 * The method recSearch is the recursive search.
 * 
 * @author: Sung Ho Park
 * Class: CSS 143 B
 * Assignment: Recursion
 *
 */
public class BinarySearch extends SearchAlgorithm
{

	@Override
	/**
	 * Preconditions: All the parameters exist and there are String values in
	 * the array, String target, int start, int end.
	 * 
	 * Postcondition: returns the index of where the String is.
	 * 
	 * @param String[] words
	 * @param String words to find
	 * 
	 * @return int index
	 */
	public int search(String[] words, String wordToFind)
								throws ItemNotFoundException 
	{
		//Local Variables for all array
		int lowIndex = 0;
		int highIndex = words.length - 1;
		int midIndex = 0;
		boolean found = false;
		
		//If lowIndex is than or equal to highIndex
		while(lowIndex <= highIndex)
		{
			//Get midIndex
			midIndex = (lowIndex + highIndex) / 2;
			
			//Return middle index if the target String is in the middle index
			if(wordToFind.equals(words[midIndex]))
			{
				//If it's found, then return true and return the midIndex
				found = true;
				return midIndex;
			}
			
			if(wordToFind.compareTo(words[midIndex]) < 0)
			{
				//If the target comes before the midIndex Lexicographically
				//then set the highIndex to the midIndex - 1.
				highIndex = midIndex - 1;
			}
			
			if(wordToFind.compareTo(words[midIndex]) > 0 )
			{
				//If the target comes after the midIndex Lexicographically
				//then set the lowIndex to the midIndex + 1.
				lowIndex = midIndex + 1;
			}
			incrementCount();
		}
		
		//If it's still not found then throw the exception
		if(found == false)
		{
			throw new ItemNotFoundException();
		}
		return midIndex;
	}

	@Override
	/**
	 * Preconditions: All the parameters exist and there are String values in
	 * the array, String target, int start, int end.
	 * 
	 * Postcondition: Using recursion, it returns the index of where the String 
	 * is.
	 * 
	 * @param String[] words
	 * @param String words to find
	 * @param int start
	 * @param int end
	 * 
	 * @return int index
	 */
	public int recSearch(String[] words, String wordToFind, int start, int end) 
									throws ItemNotFoundException 
									{
		//Local Variables
		int midIndex = (start + end) / 2;
		
		//If the start is greater than the end, meaning that the string doesn't
		//exist, then throw the exception.
		if(start > end)
		{
			throw new ItemNotFoundException();
		}
		else if(wordToFind.equals(words[midIndex]))
		{
			//Return middle index if the target String is in the middle index
			return midIndex;
		}
		
		else if(wordToFind.compareTo(words[midIndex]) < 0)
		{
			//If the target comes before the midIndex Lexicographically
			//then set the highIndex to the midIndex - 1.
			end = midIndex - 1;
		}
		
		else if(wordToFind.compareTo(words[midIndex]) > 0 )
		{
			//If the target comes after the midIndex Lexicographically
			//then set the lowIndex to the midIndex + 1.
			start = midIndex + 1;
		}
		//Increment each time it is compares.
		incrementCount();
		
		//Call the method again (recurse)
		return recSearch(words, wordToFind, start, end);
		
	}
}
