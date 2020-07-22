package collectionTests;



import java.util.*;



//	https://beginnersbook.com/2013/12/linkedlist-in-java-with-example/



public class LinkedListExample
{
	public static void main(String args[])
	{
		LinkedList<String> linkedlist = new LinkedList<String>();
		linkedlist.add("Item1");
		linkedlist.add("Item5");
		linkedlist.add("Item3");
		linkedlist.add("Item6");
		linkedlist.add("Item2");
		System.out.println("Linked List Content: " + linkedlist + "\n");
		
		/* Add new values to first and last positions */
		linkedlist.addFirst("First Item");
		linkedlist.addLast("Last Item");
		System.out.println("LinkedList Content after addition: " + linkedlist + "\n");
		
		/* Get Value */
		Object firstvar = linkedlist.get(0);
		System.out.println("First element: " + firstvar + "\n");
		
		/* Set Value */
		linkedlist.set(0, "Changed first item");
		Object firstvar2 = linkedlist.get(0);
		System.out.println("First element after update by set method: " + firstvar2 + "\n");
		
		/* Remove first and last element */
		linkedlist.removeFirst();
		linkedlist.removeLast();
		System.out.println("LinkedList after deletion of first and last element: " + linkedlist + "\n");
		
		/* Add to a Position and remove from a position */
		linkedlist.add(0, "Newly added item");
		linkedlist.remove(2);
		System.out.println("Final Content: " + linkedlist + "\n");
		
		/* Add a collection to your list */
		ArrayList<String> arraylist = new ArrayList<String>();
		arraylist.add("String1");
		arraylist.add("String2");
		
		linkedlist.addAll(arraylist);
		System.out.println("LinkedList Content after addition: " + linkedlist + "\n");
		
		/* Add a collection to your list, starting at a given index in your list */
		arraylist.add("String3");
		arraylist.add("String4");
		arraylist.add("String5");
		
		linkedlist.addAll(1, arraylist);
		System.out.println("LinkedList Content after addition: " + linkedlist + "\n");
		
		/* Get size of list */
		System.out.println("Total elements: " + linkedlist.size() + "\n");
	}
}