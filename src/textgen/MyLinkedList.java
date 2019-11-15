package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		size =0;
		head = new LLNode<E>(null);
		tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if (element == null) {
			throw new NullPointerException("The object is null");
		}
		else {
			LLNode<E> e = new LLNode<E>(element);
			e.next = tail;
			e.prev = tail.prev;
			tail.prev.next = e;
			tail.prev = e;
			size++;
			return true;
		}
			
		
	}

	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index) 
	{
		// TODO: Implement this method.
		if (size == 0 || index >= size || index < 0) {
			throw new IndexOutOfBoundsException("GET: Index is out of bound");
		}
		else {
			
			LLNode<E> current = head;
			for (int i =0; i<= index; i++) {
				current = current.next;
			}
			return current.getData();
		}
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("ADD: Index is out of bound");
		}
		else if (element == null) {
			throw new NullPointerException("Null object is added");
		}
		else {
			
			LLNode<E> current = head;
			for (int i =0; i<= index; i++) {
				current = current.next;
			}
			LLNode<E> new_node = new LLNode<E>(element);
			new_node.prev = current.prev;
			new_node.next = current;
			current.prev.next = new_node;
			current.prev = new_node;
			size++;
		}
		
	}


	/** Return the size of the list */
	public int size() 
	{
		// TODO: Implement this method
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index) 
	{
		// TODO: Implement this method
		if (size == 0 || index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Remove: Index is out of bound");
		}
		else {
			
			LLNode<E> current = head;
			for (int i =0; i<= index; i++) {
				current = current.next;
			}
			size--;
			LLNode<E> pre = current.prev;
			pre.next= current.next;
			current.next.prev = pre;
			
			current.next = null;
			current.prev = null;
			return current.data;
		}
		
		
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if (size != 0 && (index >= size || index < 0)) {
			throw new IndexOutOfBoundsException("Set: Index is out of bound");
		}
		else if(element == null) {
			throw new NullPointerException("Null object is set");
		}
		else {
			
			LLNode<E> current = head;
			for (int i =0; i<= index; i++) {
				current = current.next;
			}
			current.data = element;
			return current.data;
		}
		
		
	}   
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor

	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}
	
	public E getData() {
		return this.data;
	}

}
