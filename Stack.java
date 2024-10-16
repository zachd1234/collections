//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Stack
{
    private int[] arr;
    private int topIndex; //the next available index to push an element to. 1 + top of stack. 
    
    public Stack (int size) {
        arr = new int[size];
        topIndex = 0;
    }
    
    public Stack() {
        arr = new int[10000];
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
    public void push(int newVal) {
        if(isFull()) {
           throw new IllegalStateException("Stack is full. Can't push.");  
       }
        arr[topIndex] = newVal;
        topIndex++;
    }
    
    
    /**
     * @throws EmptyStackException if stack is Empty 
     */
    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException(); 
        }
        
        topIndex--;
        return arr[topIndex];
    }
    
     /**
     * @throws EmptyStackException if stack is Empty 
     */
    public int top() {
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
