package Recursion;
/**
 * Linear and Binary Search Homework 5 Driver
 * CSS 143
 * 
 * Note that nothing in this class needs to be changed except for your FILE_AND_PATH variable
 * 
 * Implement the Binary Search using both the iterative and recursive techniques covered
 * in class
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinSearchDriver 
{
	public final static String FILE_AND_PATH = "c:\\longwords.txt";
	/* 
	 * TODO: Be sure to change the FILE_AND_PATH to point to your local 
	 * copy of longwords.txt or a FileNotFoundException will result
	 */	
	
	
	//Note how we deal with Java's Catch-or-Declare rule here by declaring the exceptions we might throw
	public static void main(String[] args) throws FileNotFoundException 
	{
		
		Scanner input = new Scanner(new File("longwords.txt"));
		int wordCount = 0;
		ArrayList<String> theWords = new ArrayList<String>();
		
		//read in words, count them
		while(input.hasNext())  
		{
			theWords.add(input.next());
			wordCount++;
		}

		//make a standard array from an ArrayList
		String[] wordsToSearch = new String[theWords.size()];
		theWords.toArray(wordsToSearch);
		
		//start with the linear searches
		tryLinearSearch(wordsToSearch, "DISCIPLINES");
		tryLinearSearch(wordsToSearch, "TRANSURANIUM");
		tryLinearSearch(wordsToSearch, "HEURISTICALLY");
		tryLinearSearch(wordsToSearch, "FOO");
		
		System.out.println();
		//and compare these results to the binary searches
		tryBinarySearch(wordsToSearch, "DISCIPLINES");
		tryBinarySearch(wordsToSearch, "TRANSURANIUM");
		tryBinarySearch(wordsToSearch, "HEURISTICALLY");
		tryBinarySearch(wordsToSearch, "FOO");
		
	}

	/**
	 * Method tryBinarySearch
	 * precondition: wordsToSearch is a nonempty array of Strings, and target 
	 * is a non-null string to search for in our collection of strings
	 * 
	 * postcondition: Uses a BinarySearch object (which implements this style 
	 * of search) to try to find the target string
	 */
	private static void tryBinarySearch(String[] wordsToSearch, String target) 
	{
		//Todo: Build a LinearSearch class that inherits from SearchAlgorithm, 
		//and put it in the same directory as this class to successfully compile
		
		SearchAlgorithm bs = new BinarySearch();
		
		//Recursive Binary
		try 
		{
			System.out.print( target + " found at index: " +
								bs.recSearch(wordsToSearch, target, 0, 
													wordsToSearch.length - 1));
			
			System.out.println( " taking " + bs.getCount() + " comparisons.");
		} 
		catch(ItemNotFoundException e) 
		{
			System.out.println( target + ": " + e.getMessage());
		}
		
		//Iterative Binary. Pretty much the same, its just that it is coded 
		//differently
//		try 
//		{
//			System.out.print( target + " found at index: " +
//											bs.search(wordsToSearch, target));
//
//			System.out.println( " taking " + bs.getCount() + " comparisons.");
//		} 
//		catch(ItemNotFoundException e) 
//		{
//			System.out.println( target + ": " + e.getMessage());
//		}	
	}

	/**
	 * Method tryLinearSearch
	 * precondition: wordsToSearch is a nonempty array of Strings, and target is a non-null string to search for 
	 * 				 in our collection of strings
	 * postcondition: Uses a LinearSearch object to try to find the target string
	 */
	private static void tryLinearSearch(String[] wordsToSearch, String target) 
	{
		//Todo: Build a LinearSearch class that inherits from SearchAlgorithm, 
		//and put it in the same directory as this class to successfully
		//compile
		SearchAlgorithm bs = new LinearSearch();
		
		//Recursive Linear doesn't work because when doing a recursive linear,
		//It has a limited amount of space that it can store in the stack
		//resulting in stack overflow.
		
		//Iterative Linear
		try
		{
			System.out.print( target + " found at index: " +
										bs.search(wordsToSearch,target));
			System.out.println( " taking " + bs.getCount() + " comparisons.");
			
		} 
		catch( ItemNotFoundException e ) 
		{
			System.out.println( target + ": " + e.getMessage());
		}
	}
	
	
	

}
