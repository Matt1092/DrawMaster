/**
 * This class implements a singly linked list data structure. It provides
 * methods to perform standard operations such as adding elements to the front
 * or back of the list, removing elements from the front, checking if the list
 * is empty, clearing the list, checking if the list contains a certain element,
 * getting the size of the list, and converting the list to a string representation.
 *
 * @param <T> the type of elements in this linked list
 * 
 * @author Matthew Moga
 * @version April 26, 2024
 */

class LinkedList<T> implements LinkedListADT<T> {
    private ListNode<T> front = null;
    private ListNode<T> back = null;
    private int numberOfNodes = 0;
    
    // Returns true if the linked list has no nodes, or false otherwise.
    @Override
    public boolean isEmpty() {
        return (front == null);
    }
    
    // Deletes all of the nodes in the linked list.
    // Note: ListNode objects will be automatically garbage collected by JVM.
    @Override
    public void clear() {
        front = null;
        numberOfNodes = 0;
    }
    
    // Returns the number of nodes in the linked list
    @Override
    public int size() {
        return numberOfNodes;
    }
    
    // Adds a node to the front of the linked list.
    @Override
    public void addFirst( T element ) {
        front = new ListNode<T>( element, front );
        numberOfNodes++;
    }
    
    // Add an element to the end of the linked list
    @SuppressWarnings("unchecked")
    public void addLast( T element ) {
        ListNode<T> node = new ListNode<T>(element);
        if ( isEmpty() ) {
            addFirst(element);
            front = back = node;
            numberOfNodes++;
        }
        else {
            ListNode<T>temp = front;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(node);
            back = node;
            numberOfNodes++;
        }
    }
    
    
    // Returns a reference to the data in the first node, or null if the list is empty.
    @Override
    public T peekFirst() {
        if ( isEmpty() )
            return null;
        
        return front.getData();
    }
    
    // Removes a node from the front of the linked list (if there is one).
    // Returns a reference to the data in the first node, or null if the list is empty.
    @Override
    @SuppressWarnings("unchecked")
    public T removeFirst() {
        T tempData;
        
        if ( isEmpty() )
            return null;
        
        tempData = front.getData();
        front = front.getNext();
        numberOfNodes--;
        return tempData;
    }
    
    // Returns true if the linked list contains a certain element, or false otherwise.
    @Override
    @SuppressWarnings("unchecked")
    public boolean contains( T key ) {
        ListNode<T> searchNode;
        searchNode = front;
        while ( ( searchNode != null ) && ( !key.equals( searchNode.getData() ) ) ) {
            searchNode = searchNode.getNext();
        }
        return ( searchNode != null );
    }
    
    // Return String representation of the linked list.
    @Override
    @SuppressWarnings("unchecked")
    public String toString() {
        ListNode<T> node;
        String linkedList = "FRONT ==> ";
        
        node = front;
        while (node != null) {
            linkedList += "[ " + node.getData() + " ] ==> ";
            node = node.getNext();
        }
        
        return linkedList + "NULL";
    }
}
