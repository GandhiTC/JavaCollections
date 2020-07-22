package collectionTests;



import java.util.LinkedHashMap;
import java.util.Set;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Optional;



//	https://docs.oracle.com/javase/tutorial/java/data/numberformat.html



public class LinkedHashMapExample
{
	public static void main(String args[])
	{
		//	Create new LinkedHashMap and populate it
		LinkedHashMap<Integer, String> lhmap = new LinkedHashMap<Integer, String>();
		lhmap.put(22, "Abey");
		lhmap.put(33, "Dawn");
		lhmap.put(1, "Sherry");
		lhmap.put(-10000, "Jim");
		lhmap.put(2, "Dave");
		lhmap.put(2, "Karon");		//  Reusing a key, only unique keys are allowed, this entry's value will replace the previous value associated with this key
		lhmap.put(3, "Karon");		//  Reusing a value, this is ok in maps
		lhmap.put(null, "Tom");		//	HashMaps allow a single null key and multiple null values, Hashtables do not allow either
		lhmap.put(null, null);		//	Reusing a key again, this entry's value will replace the value already associated with a null key in lhmap
		lhmap.put(4, null);			//	Values can be the same in HashMaps, including nulls
		
		
		//	Print the LinkedHashMap
		System.out.println(lhmap + "\r\n");
		
		
		//	Create an iterator for the keys in lhmap
		Iterator<Integer>	keyIter 	= lhmap.keySet().iterator();
		
		
		//	Create temporary numbers to start with
		int					max	  		= Integer.MIN_VALUE;
		int					min			= Integer.MAX_VALUE;
		boolean				hasNulls	= false;
		
		
		//	Find the biggest and smallest keys in lhmap
		while(keyIter.hasNext())
		{
			//	int cant be null but Optional can contain nulls
			Optional<Integer> nextKey = Optional.ofNullable(keyIter.next());
			
			//	If value for the Optional is not present, it is null
			if(nextKey.isPresent())
			{
				max = Math.max(max, nextKey.get());
				min = Math.min(min, nextKey.get());
			}
			else
			{
				hasNulls = true;
			}
		}
		
		
		//	Get the number of characters in max and min
		int					maxCount	= Integer.toString(max).length();
		int					minCount	= Integer.toString(min).length();
		
		//	The word "null" has 4 characters
		int					charsInNull	= hasNulls ? 4 : 0;
		
		//	Get max number of characters between max value, min value, and "null"
		int					charCount	= Math.max(Math.max(maxCount, minCount), charsInNull);
		
		//	Get the proper string format based on the maximum number of characters
		String				format		= "%0" + Integer.toString(charCount) + "d";
		
		
		//	Extract all unique entries from lhmap
		Set<Entry<Integer, String>>			set			= lhmap.entrySet();
		
		
		//	Create an iterator for the new Set
		Iterator<Entry<Integer, String>>	iterator	= set.iterator();

		
		//	Iterate through the new Set and print out each Entry
		while(iterator.hasNext())
		{
			Entry<Integer, String> entry = iterator.next();
			System.out.println("Key is: " + String.format(format, entry.getKey()) + " & Value is: " + entry.getValue());
		}
	}
}
