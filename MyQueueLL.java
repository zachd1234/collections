import java.util.NoSuchElementException;

/**
 * Write a description of class MyQueueLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueueLL<E>
{
    //head is front
    private MyLinkedList<E> queue;
    
    public MyQueueLL() {
        queue = new MyLinkedList<E>();
    }
    
    public void enqueue(E element){
        queue.newTail(element);
    }
        
    /**
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E dequeue()  {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        return queue.removeHead();
    }
    
    public boolean isEmpty(){
        return queue.isEmpty();
    }
    
    /**
     * @throws NoSuchElementException if Queue is Empty 
     */
    public E front() {
        if (isEmpty()){
            throw new NoSuchElementException(); 
        }
        return queue.getHead();
    }
    
    public int size() {
        return queue.size();
    }

    public String toString() {
        return queue.toString();
    }    
}
