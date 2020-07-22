package collectionTests;



import java.util.*;



//	In order to guarantee serial access, 
//	it is critical that all access to the backing set (set) 
//	is accomplished through the returned set (synset)

//	https://www.geeksforgeeks.org/collections-synchronizedset-method-in-java-with-examples/



public class synchronizedSetExample
{
	public static void main(String[] argv) throws Exception
	{
		try
		{
			Set<String> set = new HashSet<String>();
			set.add("1");
			set.add("2");
			set.add("3");
			System.out.println("Set : " + set);
			
			Set<String> synset = Collections.synchronizedSet(set);
			System.out.println("Synchronized set is : " + synset);
			
			synset.add("Added To Synchronized Set");
			System.out.println("Set : " + set);
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Exception thrown : " + e);
		}
	}
}