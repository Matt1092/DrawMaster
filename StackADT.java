/**
 * StackADT.java
 *
 * This interface defines the abstract data type for a stack. A stack is a collection that follows the Last-In-First-Out (LIFO) principle.
 * This interface provides standard stack operations such as push, pop, peek, isEmpty, size, clear, and toString.
 *
 * @param <T> the type of elements in this stack
 * 
 * Created by: Matthew Moga
 * Date: January 2, 2025
 */

public interface StackADT<T> {
    // Adds one element to the top of the stack.
    public void push(T element);
    
    // Removes and returns a reference to the top element from the stack.
    public T pop();
    
    // Returns a reference to the top element, without removing it from the stack.
    public T peek();
    
    // Returns true if the stack contains no elements, false otherwise.
    public boolean isEmpty();
    
    // Returns the number of elements in the stack.
    public int size();
    
    // Clears all elements from the stack
    public void clear();
    
    // Returns a String representation of this stack.
    public String toString();
}
