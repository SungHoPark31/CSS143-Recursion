package Recursion;

public class ItemNotFoundException extends Exception
{
	public ItemNotFoundException()
	{
		super("Item is not found.");
	}
	public ItemNotFoundException(String message)
	{
		super(message);
	}
}
