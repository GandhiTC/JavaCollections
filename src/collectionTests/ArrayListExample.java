package collectionTests;



import java.util.ArrayList;



/*
	can accept duplicate values
	ArrayList, LinkedList, Vector - implement List interface
	arrays have fixed size where as ArrayLists can grow dynamically
	you can access and insert any value in any index
*/



public class ArrayListExample
{
	private static int i = 5;


	public static void main(String[] args)
	{
		ArrayList<String> a = new ArrayList<String>();
		a.add("rahul");
		a.add("java");
		a.add("java");
		System.out.println(a + "\n");
		
		a.add(0, "student");
		System.out.println(a + "\n");
		
		a.remove(1);
		a.remove("java");				//	Removes first matching item
		System.out.println(a + "\n");
		
		System.out.println(a.get(1));	//	index 2 should get us IndexOutOfBoundsException
		System.out.println(a.contains("java"));
		System.out.println(a.indexOf("rahul"));
		System.out.println(a.isEmpty());
		System.out.println(a.size());
		
		i -= a.size();
		
		abc();
	}


	protected static void abc()
	{
		System.out.println("hello " + i);
	}
}