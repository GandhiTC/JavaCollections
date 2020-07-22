package collectionTests;



import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;



//	LinkedHashMap and TreeMap are excluded as they are non-synchronous



/**
 * @author	Crunchify.com
 * @see		https://crunchify.com/hashmap-vs-concurrenthashmap-vs-synchronizedmap-how-a-hashmap-can-be-synchronized-in-java/
 *			and
 *			https://dzone.com/articles/random-number-generation-in-java
 */
public class CrunchifyMaps
{
	public			static 	int						numOfEntries						= 250000;
	public			static 	int						numOfRuns							= 5;
	public			static	long					awaitTime							= 5L;
	public			static	TimeUnit				awaitUnit							= TimeUnit.SECONDS;
	public final 	static 	int						THREAD_POOL_SIZE					= 5;
	public 			static 	Map<String, Integer>	crunchifyHashTableObject			= null;
	public 			static 	Map<String, Integer>	crunchifySynchronizedMapObject		= null;
	public 			static 	Map<String, Integer>	crunchifyConcurrentHashMapObject	= null;


	public static void main(String[] args) throws InterruptedException
	{
		// Test with Hashtable Object
		crunchifyHashTableObject = new Hashtable<String, Integer>();
		crunchifyPerformTest(crunchifyHashTableObject);
		
		// Test with synchronizedMap Object
		crunchifySynchronizedMapObject = Collections.synchronizedMap(new HashMap<String, Integer>());
		crunchifyPerformTest(crunchifySynchronizedMapObject);
		
		// Test with ConcurrentHashMap Object
		crunchifyConcurrentHashMapObject = new ConcurrentHashMap<String, Integer>();
		crunchifyPerformTest(crunchifyConcurrentHashMapObject);
	}


	public static void crunchifyPerformTest(final Map<String, Integer> crunchifyThreads) throws InterruptedException
	{
		System.out.println("Test started for: " + crunchifyThreads.getClass());
		long averageTime = 0;

		for(int i = 0; i < numOfRuns; i++)
		{
			long			startTime			= System.nanoTime();
			ExecutorService	crunchifyExServer	= Executors.newFixedThreadPool(THREAD_POOL_SIZE);

			for(int j = 0; j < THREAD_POOL_SIZE; j++)
			{
				crunchifyExServer.execute(new Runnable()
				{
					@SuppressWarnings("unused")
					@Override
					public void run()
					{
						for(int i = 0; i < numOfEntries; i++)
						{
//							Integer	crunchifyRandomNumber	= (int)Math.ceil(Math.random() * 550000);
							Integer crunchifyRandomNumber	= (int)(Math.random() * ((numOfEntries + 1) + 1)) + 1;
															//	in the form of: (int)(Math.random()*((max-min)+1))+min;
															//	where max is not included in (max-min), that is why I added 1 inside parentheses
							
							// Retrieve value. We are not using it anywhere
							Integer	crunchifyValue			= crunchifyThreads.get(String.valueOf(crunchifyRandomNumber));
							
							// Put value
							crunchifyThreads.put(String.valueOf(crunchifyRandomNumber), crunchifyRandomNumber);
						}
					}
				});
			}

			// Initiates an orderly shutdown in which previously submitted tasks are
			// executed, but no new tasks will be accepted. Invocation
			// has no additional effect if already shut down.
			// This method does not wait for previously submitted tasks to complete
			// execution. Use awaitTermination to do that.
			crunchifyExServer.shutdown();
			
			// Blocks until all tasks have completed execution after a shutdown request,
			// or the timeout occurs, or the current thread is interrupted,
			// whichever happens first.
//			crunchifyExServer.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
			crunchifyExServer.awaitTermination(awaitTime, awaitUnit);
			
			long	entTime		 = System.nanoTime();
			long	totalTime	 = (entTime - startTime) / 1000000L;
					averageTime += totalTime;
			
			System.out.println("500K entried added/retrieved in " + totalTime + " ms");
		}

		System.out.println("For " + crunchifyThreads.getClass() + " the average time is " + averageTime / numOfRuns + " ms\n");
	}
}