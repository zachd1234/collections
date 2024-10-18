//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Write a description of class MyQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue<E>
{
    private E[] arr;
    private int frontIndex;
    private int endIndex; 
    private int queueSize;
    
    public MyQueue (int size) {
        arr = (E[]) new Object[size];
        frontIndex = 0;
        endIndex = 0;
        queueSize = 0; 
    }
    
    public MyQueue() {
        arr = (E[]) new Object[100];
        frontIndex = 0; 
        endIndex = 0;
        queueSize = 0;
    }
    
    public boolean isEmpty() {
        if (queueSize == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isFull() {
        if (queueSize == arr.length) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public int size() {
        return queueSize;
    }
    
     /**
     * @throws IllegalStateException if Queue is Full 
     */
    public void enqueue(E element) {
       if(isFull()) {
           throw new IllegalStateException();  
       }
       arr[endIndex] = element;
       endIndex = (endIndex + 1) % arr.length; 
       //bumps index and wraps it back to zero if index is at the end
       
       queueSize++;
    }
    
    /**
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E dequeue()
    {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        E temp = arr[frontIndex]; //holds the dequeue value 
        frontIndex = (frontIndex + 1) % arr.length; 
        //bumps index and wraps it back to zero if index is at the end
        
        queueSize--;
        return temp;
    }
    
    /**
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E front() {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        return arr[frontIndex];
    }
    
     public String toString() {
        return Arrays.toString(arr);
    }
}