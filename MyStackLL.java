import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Write a description of class MyStackLL here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyStackLL<E>
{
   private MyLinkedList<E> stack;
    //head is end
   //use the linked List to dothis 
   public MyStackLL(){
         stack = new MyLinkedList<E>();
   }
   
   public void push(E element) {
       stack.addHead(element);
   }
   
   public E pop() {
       //do i also need to throw an exeption here if empty. bc linked list also does it
       if(stack.isEmpty()) {
            throw new EmptyStackException(); 
       }
       return stack.removeHead();
   }

   public boolean isEmpty()
   {
     return stack.isEmpty();
   }
   
   public E top() {
       if(stack.isEmpty()) {
            throw new EmptyStackException(); 
       }
       return stack.getHead();
   }
   
   public int size(){
       return stack.size();
   }
   
   public String toString() {
       return stack.toString();
   }
}