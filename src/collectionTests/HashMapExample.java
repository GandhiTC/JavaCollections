package collectionTests;



import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;



//	HashMap, Hashtable, LinkedHashMap, TreeMap - implement Map interface
//	Element order not guaranteed
//	Can have 1 null key, multiple null values



public class HashMapExample
{
	public static void main(String[] args)
	{
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		hashMap.put(0, "hello");
		hashMap.put(1, "goodbye");
		hashMap.put(42, "morning");
		hashMap.put(3, "evening");
		
		System.out.println(hashMap.get(42) + "\n");
		
		hashMap.remove(42);
		System.out.println(hashMap.get(42) + "\n");
		
		Set<Map.Entry<Integer, String>>			setMap	= hashMap.entrySet();
		Iterator<Map.Entry<Integer, String>>	iter	= setMap.iterator();
		
		// Hashtable -pass table set collections
		while(iter.hasNext())
		{
			Map.Entry<Integer, String> entry = iter.next();
			System.out.println(entry.getKey() + " = " + entry.getValue());
		}
	}
}
