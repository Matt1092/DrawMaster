/**
 * ListNode.java
 *
 * This class represents a node in a singly linked list. Each node contains data and a reference to the next node in the list.
 * It provides constructors to create a node with or without a reference to the next node, as well as accessor and mutator methods
 * to get and set the node's data and the reference to the next node.
 *
 * @param <T> the type of elements in this node
 * 
 * Created by: Matthew Moga
 * Date: January 2, 2025
 */

public class ListNode<T> {
    private T data;
    private ListNode next;
    
    // Constructor: No reference to next node provided so make it null 
    public ListNode( T nodeData ) {
        this( nodeData, null);
    }
    
    // Constructor: Set data and reference to next node.
    public ListNode( T nodeData, ListNode nodeNext ) {
        data = nodeData;
        next = nodeNext;
    }
    
    // Accessor: Return the data for current ListNode object
    public T getData() {
        return data;
    }
    
    // Accessor: Return reference to next ListNode object
    public ListNode getNext() {
        return next;
    }
    
    // Mutator: Set new data for current ListNode object
    public void setData( T newData ) {
        data = newData;
    } 
    
    // Mutator: Set new reference to the next node object
    public void setNext( ListNode newNext ) {
        next = newNext;
    }
}
