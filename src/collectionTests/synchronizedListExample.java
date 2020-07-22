package collectionTests;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



//	A synchronized list only synchronizes the methods of the list.
//	A thread won't be able to modify the list while another thread is currently running a method from the list.
//	The object is locked while its processing a method.

//	If you want to use an iterator on the synchronized list
//	it should be in a synchronized block.

//	https://beginnersbook.com/2013/12/difference-between-arraylist-and-vector-in-java/
//	https://stackoverflow.com/questions/40930861/what-is-the-use-of-collections-synchronizedlist-method-it-doesnt-seem-to-syn



public class synchronizedListExample
{
	public static void main(String args[])
	{
		List<String> syncList 	= Collections.synchronizedList(new ArrayList<String>());
		List<String> listA		= Arrays.asList("A1", "A2", "A3");
		List<String> listB		= Arrays.asList("B1", "B2", "B3");
		
		syncList.addAll(listA);
		syncList.addAll(listB);
		
		//	We manually manufacture separate threads to iterate the synchronizedList.
		//	By design one of the threads should be locked out while the other is working.
		//	As a result, one of the threads should finish iterating completely before the other thread starts.
		//	We should not see intermingling of thread processes in the console output. 
		//	Notice in the console output that listA items are always listed first.
		//	That is because syncList.addAll() is a method of a synchronizedList, 
		//	each time you call any synchronizedList's methods, 
		//	it will lock the synchronizedList object while it is working.
		Thread t1 = new Thread(new Runnable()
		{
	        @Override
	        public void run()
	        {
	        	synchronized(syncList)
	        	{
	        		Iterator<String> iterator = syncList.iterator();
	        		
	        		while (iterator.hasNext())
	        		{
	        			System.out.println("Thread 1 : " + iterator.next());
	        		}
	        		
	        		System.out.println(" ");
	        	}
	        }
	    });
		
		Thread t2 = new Thread(new Runnable()
		{
	        @Override
	        public void run()
	        {
	        	synchronized(syncList)
	        	{
		        	Iterator<String> iterator = syncList.iterator();
	        		
	        		while (iterator.hasNext())
	        		{
	        			System.out.println("Thread 2 : " + iterator.next());
	        		}
	        		
	        		System.out.println(" ");
	        	}
	        }
	    });
		
		t1.start();
		t2.start();
		
		/*
		 * EXPECTED RESULT: 
		 * 
		 * Thread 1 : A1 
		 * Thread 1 : A2 
		 * Thread 1 : A3 
		 * Thread 1 : B1
		 * Thread 1 : B2 
		 * Thread 1 : B3
		 * 
		 * Thread 2 : A1 
		 * Thread 2 : A2 
		 * Thread 2 : A3 
		 * Thread 2 : B1 
		 * Thread 2 : B2 
		 * Thread 2 : B3
		 */
	}
}