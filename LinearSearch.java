package Recursion;
/**
 * This is the Linear Search class. A linear search is looking through
 * each of the values in the array individually and comparing that value 
 * to the target value.
 * 
 * The method search is an iterative search which will not use recursion.
 * The method recSearch is the recursive search.
 * 
 * Note: Recursion doesn't work because recursion uses a stack to store
 * values. And that stack has a certain limit. Doing a linear search, 
 * where it looks through each and every value, will eventually result
 * in a stack overflow exception.
 * 
 * @author: Sung Ho Park
 * Class: CSS 143 B
 * Assignment: Recursion
 *
 */
public class LinearSearch extends SearchAlgorithm 
{
	@Override
	/**
	 * 
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
		//Initialize found
		boolean found = false;
		//Go through each of the words in the array
		for(int i = 0; i < words.length - 1; i++)
		{
			//Increment each time it compares.
			incrementCount();
			//If a word in the array matches the target
			
			if(words[i].equals(wordToFind))
			{
				//return i;
				found = true;
				return i;
			}
		}
		//If not found, then throw the exception.
		if(found == false)
		{
			throw new ItemNotFoundException();
		}
		return 0;
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
	public int recSearch(String[] words, String wordToFind, 
			int start, int end) throws ItemNotFoundException 
	{
		//If there is no found string, then throw the exception
		if(start > end)
		{
			throw new ItemNotFoundException();
		}
		//If the target and the string value is equal, then return 
		//the index.
		if(wordToFind.equals(words[end]))
		{
			return end;
		}
		else
		{
			//recurse but subtract 1 to the end so that 
			return recSearch(words, wordToFind, start, end - 1);
		}
	}
}
