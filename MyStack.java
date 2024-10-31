//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * a stack implementation (last in first out) .
 *
 * @author Zach Derhake
 * @version 10/30/24
  */ 
public class MyStack<E> {
    
    private E[] arr;
    private int topIndex; //the next available index to push an element to. 1 + top of stack. 
    
    /**
     * initalizes the stack and sets the max size to the parameter
     * @param the max size of the stack 
     * @throws if the stack is negative 
     */
    public MyStack(int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("Stack needs to be positive.");
        }
        arr = (E[]) new Object[maxSize];
        topIndex = 0;
    }
    
    /**
     * initalizes the stack and sets the max size to 100
     */
    public MyStack() {
        arr = (E[]) new Object[100];
        topIndex = 0;
    }

    /** adds an element to the end of the stack 
     * @param the element to be added to the end of the stack 
     * @throws IllegalStateException if stack is full 
     */
    public void push(E element) {
        if(isFull()) {
           throw new IllegalStateException("Stack is full. Can't push.");  
       }
       arr[topIndex] = element;
       topIndex++;
    }
    
    
    /**
     * removes the element at the top of the stack and returns it 
     * @return the element that was removed at the top of the stack 
     * @throws EmptyStackException if stack is Empty
     */
    public E pop() {
        if(isEmpty()) {
            throw new EmptyStackException(); 
        }
        
        topIndex--;
        E poppedElement = arr[topIndex];
        arr[topIndex] = null;
        return poppedElement;
    }
    
     /**
     * returns the top element on the stack 
     * @return the top element on the stack  
     * @throws EmptyStackException if stack is Empty 
     */
    public E top() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return arr[topIndex-1];
    }
    
    /**
     *  Returns whether the stack is empty 
     *  @return whether the stack is empty or not 
     */
    public boolean isEmpty() {
        if (topIndex == 0) {
            return true;
        }
        else {
            return false; 
        }
    }
    
     /**
     *  Returns whether the stack is full 
     *  @return whether the stack is full or not 
     */
    public boolean isFull() {
        if (topIndex >= arr.length) {
            return true;
        }
        else {
            return false; 
        }
    }
    
    /**
     * returns the amount of elements in the stack 
     * @returns the amount of elements in the stack  
     */
    public int size() {
        return topIndex;
    }
    
    /**
     * calls Arrays.ToString and returns it 
     * @return the Stack in a String format  
     */
    public String toString() {
        return Arrays.toString(arr);
    }
}
