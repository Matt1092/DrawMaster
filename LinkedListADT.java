/**
 * LinkedListADT.java
 *
 * This interface defines the abstract data type for a singly linked list.
 * It specifies the standard operations that can be performed on a linked list,
 * such as adding elements to the front, removing elements from the front, 
 * checking if the list is empty, clearing the list, checking if the list 
 * contains a certain element, getting the size of the list, and converting 
 * the list to a string representation.
 *
 * @param <T> the type of elements in this linked list
 * 
 * Created by: Matthew Moga
 * Date: January 2, 2025
 */

public interface LinkedListADT<T> {
    
    // Returns true if the linked list has no nodes, or false otherwise.
    public boolean isEmpty();
    
    // Deletes all of the nodes in the linked list.
    public void clear();
    
    // Returns the number of nodes in the linked list
    public int size();
    
    // Adds a node to the front of the linked list.
    public void addFirst( T element );
    
    // Returns a reference to the data in the first node, or null if the list is empty.
    public T peekFirst();
    
    // Removes a node from the front of the linked list (if there is one).
    // Returns a reference to the data in the first node, or null if the list is empty.
    public T removeFirst();
    
    // Returns true if the linked list contains a certain element, or false otherwise.
    public boolean contains( T key );
    
    // Return String representation of the linked list.
    public String toString();
}
