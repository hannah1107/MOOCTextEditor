/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH =10; 

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
	    shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++)
		{
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);
		
	}

	
	/** Test if the get method is working correctly.
	 */
	/*You should not need to add much to this method.
	 * We provide it as an example of a thorough test. */
	@Test
	public void testGet()
	{
		//test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
			
		}
		
		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));
		
		try {
			shortList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		// test longer list contents
		for(int i = 0; i<LONG_LIST_LENGTH; i++ ) {
			assertEquals("Check "+i+ " element", (Integer)i, longerList.get(i));
		}
		
		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		
		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		}
		catch (IndexOutOfBoundsException e) {
		}
		
	}
	
	
	/** Test removing an element from the list.
	 * We've included the example from the concept challenge.
	 * You will want to add more tests.  */
	@Test
	public void testRemove()
	{
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer)21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		
		try {
			emptyList.remove(0);
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		// TODO: Add more tests here
		try {
			shortList.remove(10);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.remove(-1);
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test adding an element into the end of the list, specifically
	 *  public boolean add(E element)
	 * */
	@Test
	public void testAddEnd()
	{
        // TODO: implement this test
		try {
			emptyList.add(null);
			fail("Check NullPointer");
		}
		catch(NullPointerException n) {
		}
		
		try {
			shortList.add(null);
			fail("Check NullPointer");
		}
		catch (NullPointerException e) {
		}
		
		int a = 77;
		emptyList.add(a);
		assertEquals("Add: checking add a is correct",(Integer) 77, emptyList.tail.prev.data);
	    
		longerList.add(55);
		assertEquals("Add: checnking add a", (Integer) 55, longerList.tail.prev.data);
	}

	
	/** Test the size of the list */
	@Test
	public void testSize()
	{
		// TODO: implement this test
		assertEquals("Test current size empty list", 0, emptyList.size );
		assertEquals("Test current size of long list", LONG_LIST_LENGTH, longerList.size);
	}

	
	
	/** Test adding an element into the list at a specified index,
	 * specifically:
	 * public void add(int index, E element)
	 * */
	@Test
	public void testAddAtIndex()
	{
        // TODO: implement this test
		longerList.add(2,5);
		assertEquals("TestAddAtIndex: Check size is corret",LONG_LIST_LENGTH + 1,longerList.size );
		assertEquals("TestAddAtIndex: Check add at corret index", longerList.get(2), (Integer)5);
		assertEquals("TestAddAtIndex:Check value the next node", longerList.get(3),(Integer) 2);
		assertEquals("TestAddAtIndex: Check value of previous node", longerList.get(1), (Integer)1);
		
		
		emptyList.add(5);
		assertEquals("TestAddAtIndex: check value on empty list",(Integer) 5,emptyList.get(0));
		
		try {
			longerList.add(3, null);
		    fail("Check null object");
		}
		catch(NullPointerException e) {
			
		}
		
		try {
			shortList.add(10, "C");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.add(-1, "C");
			fail("Check out of bounds");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
	}
	
	/** Test setting an element in the list */
	@Test
	public void testSet()
	{
	    // TODO: implement this test
		shortList.set(1, "C");
		assertEquals("TestSet: Check value set in shortList at first position",shortList.get(1),"C" );
	    
		try {
			shortList.set(10, "C");
			fail("Check out of bound");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
		try {
			shortList.set(1, null);
			fail("Check null pointer");
		}
		catch (NullPointerException e) {
			
		}
		try {
			shortList.add(-1, "C");
			fail("Check out of bound");
		}
		catch(IndexOutOfBoundsException e) {
			
		}
		
	}
	
	
	// TODO: Optionally add more test methods.
	
}
