//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)-
  
  */ 
public class MyStack<E>
{
    private E[] arr;
    private int topIndex; //the next available index to push an element to. 1 + top of stack. 
    
    public MyStack (int maxSize) {
        if (maxSize < 0) {
            throw new IllegalArgumentException("Stack needs to be positive.");
        }
        arr = (E[]) new Object[maxSize];
        topIndex = 0;
    }
    
    public MyStack() {
        arr = (E[]) new Object[100];
        topIndex = 0;
    }
    
     public boolean isEmpty() {
        if (topIndex == 0) {
            return true;
        }
        else {
            return false; 
        }
    }
    
    public boolean isFull() {
        if (topIndex >= arr.length) {
            return true;
        }
        else {
            return false; 
        }
    }

    /**
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
     * @throws EmptyStackException if stack is Empty 
     */
    public E top() {
        if (isEmpty()){
            throw new EmptyStackException();
        }
        return arr[topIndex-1];
    }
    
    public int size() {
        return topIndex;
    }
    
    public String toString() {
        return Arrays.toString(arr);
    }
}
