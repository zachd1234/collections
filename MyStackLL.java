//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.EmptyStackException;
import java.util.NoSuchElementException;


/**
 * a stack implementation (last in first out) based around a Linked List.
 *
 * @author Zach Derhake
 * @version 10/30/24
*/ 
public class MyStackLL<E>
{
    
   private MyLinkedList<E> stack;
   
    /**
     * initalizes an empty stack
     */
   public MyStackLL() {
       stack = new MyLinkedList<E>();
   }
   
    /** adds an element to the end of the stack 
    * @param the element to be added to the end of the stack 
    */
   public void push(E element) {
       stack.addHead(element);
   }
   
    /**
     * removes the element at the top of the stack and returns it 
     * @return the element that was removed at the top of the stack 
     * @throws EmptyStackException if stack is Empty
     */
   public E pop() {
       if(stack.isEmpty()) {
            throw new EmptyStackException(); 
       }
       return stack.removeHead();
   }
   
    /**
     * returns the top element on the stack 
     * @return the top element on the stack  
     * @throws EmptyStackException if stack is Empty 
     */
   public E top() {
       if(stack.isEmpty()) {
            throw new EmptyStackException(); 
       }
       return stack.getHead();
   }
   
   /**
     *  Returns whether the stack is empty 
     *  @return whether the stack is empty or not 
     */
   public boolean isEmpty() {
     return stack.isEmpty();
   }
   
    /**
     * returns the amount of elements in the stack 
     * @returns the amount of elements in the stack  
     */
   public int size() {
       return stack.size();
   }
   
   /**
     * calls Arrays.ToString and returns it 
     * @return the Stack in a String format  
     */
   public String toString() {
       return stack.toString();
   }
}