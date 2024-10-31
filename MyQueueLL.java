//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.NoSuchElementException;


/**
 *  a queue implementation (first in first out) based around a linked list 
 * @author Zach Derhake
* @version 10/30/24
 */
public class MyQueueLL<E> {
    
    //head is front
    private MyLinkedList<E> queue;
    
    
    /**
     * creates a new queue through a Linked List
     */
    public MyQueueLL() {
        queue = new MyLinkedList<E>();
    }
    
    /**
     * Adds an element to the end of the Queue 
     * @param an element to be added to the end of the queue
     */
    public void enqueue(E element) {
        queue.addTail(element);
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
        return queue.removeHead();
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
        return queue.getHead();
     }
    
     /**
     *  Returns whether the queue is empty 
     *  @return whether the queue is empty or not 
     */
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    /**
     * returns the amount of elements in the queue  
     * @returns the amount of elements in the queue  
     */
    public int size() {
        return queue.size();
    }

    /**
     * calls Arrays.ToString and returns it 
     * @return the Queue in a String format  
     */
    public String toString() {
        return queue.toString();
    }    
}
