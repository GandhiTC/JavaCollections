package collectionTests;



import java.util.HashSet;
import java.util.Iterator;



//	HashSet TreeSet, LinkedHashSet - implement Set interface
//	Does not accept duplicate values
//	There is no guarantee elements stored in sequential order



public class HashSetExample
{
	public static void main(String[] args)
	{
		HashSet<String> hs = new HashSet<String>();
		hs.add("USA");
		hs.add("UK");
		hs.add("INDIA");
		hs.add("he");
		hs.add("she");
		hs.add("INDIA");
		System.out.println(hs + "\n");
		
		System.out.println(hs.remove("UK"));
		System.out.println(hs.isEmpty());
		System.out.println(hs.contains("she"));
		System.out.println(hs.size() + "\n");
		
		Iterator<String> i = hs.iterator();

		while(i.hasNext())
		{
			System.out.println(i.next());
		}
	}
}