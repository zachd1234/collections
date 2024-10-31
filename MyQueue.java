//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
import java.util.NoSuchElementException;


/**
 * a queue implementation (first in first out)
 * @author Zach Derhake
* @version 10/30/24
 */
public class MyQueue<E> {
    
    private E[] arr;
    private int frontIndex;
    private int endIndex; 
    private int queueSize;
    
    /**
     * Initalizes an empty Queue with a max size
     * @param the max size of the Queue
     * 
     */
    public MyQueue(int maxSize) {
        arr = (E[]) new Object[maxSize];
        frontIndex = 0;
        endIndex = 0;
        queueSize = 0; 
    }
    
    /**
     * Initalizes an empty Queue with a size of 100 
     */
    public MyQueue() {
        arr = (E[]) new Object[100];
        frontIndex = 0; 
        endIndex = 0;
        queueSize = 0;
    }
    
    /**
     * Adds an element to the end of the Queue 
     * @param an element to be added to the end of the queue
     * @throws IllegalStateException if Queue is Full 
     */
    public void enqueue(E element) {
       if(isFull()) {
           throw new IllegalStateException();  
       }
       arr[endIndex] = element;
       //bumps index and wraps it back to zero if index is at the end
       endIndex = (endIndex + 1) % arr.length;       
       queueSize++;
    }
    
    /**
     * Removes the top element in the Queue and returns it 
     * @return the element value that was just dequeued
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E dequeue() {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        E temp = arr[frontIndex]; //holds the dequeue value 
        //bumps index and wraps it back to zero if index is at the end
        frontIndex = (frontIndex + 1) % arr.length; 
        queueSize--;
        return temp;
    }
    
    /**
     * Returns the top element in the queue  
     * @return the top element in the queue 
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E front() {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        return arr[frontIndex];
    }
    
    /**
     *  Returns whether the queue is empty 
     *  @return whether the queue is empty or not 
     */
    public boolean isEmpty() {
        if (queueSize == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     *  Returns whether the queue is full 
     *  @return whether the queue is full or not 
     */
    public boolean isFull() {
        if (queueSize == arr.length) {
            return true;
        }
        else {
            return false;
        }
    }
    
    /**
     * returns the amount of elements in the queue 
     * @returns the amount of elements in the queue  
     */
    public int size() {
        return queueSize;
    }
    
    /**
     * calls Arrays.ToString and returns it 
     * @return the Queue in a String format  
     */
    public String toString() {
        return Arrays.toString(arr);
    }
}