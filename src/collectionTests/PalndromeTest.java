package collectionTests;



public class PalndromeTest
{
	public static void main(String[] args)
	{
		String	oldString	= args == null || args.length == 0 ? "step on no pets" : args[0];
		String	newString	= "";

		for(int i = oldString.length() - 1; i >= 0; i--)
		{
			newString += oldString.charAt(i);
		}

		if(newString.equalsIgnoreCase(oldString))
			System.out.println("Congrats, \"" + oldString + "\" is a palindrome");
		else
			System.out.println("Sorry, \"" + oldString + "\" is not a palindrome");
	}
}