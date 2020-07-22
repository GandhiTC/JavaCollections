package collectionTests;



import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



//	In order to guarantee serial access,
//	it is critical that all access to the backing map (map)
//	is accomplished through the returned map (synmap)

//	https://www.geeksforgeeks.org/collections-synchronizedmap-method-in-java-with-examples/



public class synchronizedMapExample
{
	public static void main(String[] args)
	{
		try
		{
			Map<String, String> map = new HashMap<String, String>();
			map.put("Value1", "20");
			map.put("Value2", "30");
			map.put("Value3", "40");
			System.out.println("Map : " + map +"\r\n");
			
			//	synmap based on map
			Map<String, String> synmap = Collections.synchronizedMap(map);
			System.out.println("Synchronized map is : " + synmap + "\r\n");
			
			//	adding to synmap
			synmap.put("synmap Value","Added To Synchronized Map");
			
			//	change reflected in map
			System.out.println("Map : " + map + "\r\n");
		}
		catch(IllegalArgumentException e)
		{
			System.out.println("Exception thrown : " + e);
		}
	}
}