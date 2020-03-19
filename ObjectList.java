package Recursion;

/**
 * This is the ObjectList class. This is a general class that
 * will be used in future assignments. It acts as an ArrayList
 * and has the same functionality. Only difference is is that 
 * it has a fixed number of elements.
 * 
 * @author Sung Ho Park
 * Class: CSS 143 B
 * Assignment (for now): Recursion
 *
 */
public class ObjectList 
{
	//Makes an instance array
	private Object[] data = new Object[100];
	private int numElements = 0;

	/**
	 * When the object parameter is passed in, the array will
	 * fill in the parameter at numElements. After it is stored,
	 * it will then increment numElements
	 * @param n
	 */
	public void add(Object n)
	{
		this.data[numElements] = n;
		this.numElements++;
	}
	
	/**
	 * This will get the value with the given index of the 
	 * ObjectList array
	 * @param index
	 * @return data[index]
	 */
	public Object get(int index)
	{
		return data[index];
	}
	
	/**
	 * This will return the index of the value/target that the user
	 * wants
	 * @param target
	 * @return the index of the targeted value
	 */
	public int indexOf(Object target)
	{
		for (int i = 0; i < data.length; i++)
		{
			if(data[i].equals(target))
			{
				return i;
			}
			
		}
		return -1;
	}

	@Override
	/**
	 * Since the object is an object, the toString enables the program 
	 * print out the value as a string. If you print out an object, you 
	 * will only print out the address of the array. Which is why we 
	 * need this toString.
	 */
	public String toString() 
	{
		String retVal = "";
		for (int i = 0; i < this.data.length; i++) 
		{
			retVal = this.data[i] + "";
		}
		return retVal;
	}

	/*
	 * This will return the size of the ObjectList data array.
	 */
	public int size() 
	{
		return numElements;
	}
}
