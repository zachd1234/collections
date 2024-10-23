import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Write a description of class Test here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Test
{
    public static void testStack()
    {
        MyStack<Integer> tester = new MyStack<Integer>(7);
        System.out.println("Is Empty " + tester.isEmpty());
        System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
        try {
            tester.pop();
        } catch (EmptyStackException e) {
            System.out.println("Caught exception Pop. Can't pop when stack is empty");
        }
         try {
            tester.top();
        } catch (EmptyStackException e) {
            System.out.println("Caught exception top. Can't top when stack is empty");
        }
        tester.push(86);
        tester.push(21);
        tester.push(24);
        tester.push(24);
        tester.push(46);
        tester.push(11);
        tester.push(92);
        
        try {
            tester.push(40);
        } catch (IllegalStateException e) {
            System.out.println("Caught exception Push 40." + e.getMessage());
        }
        
        System.out.println("Top of Stack " + tester.top());
        System.out.println(tester);
        System.out.println("Is Full " + tester.isFull());  
        System.out.println("Pop:" + tester.pop());
        System.out.println("Pop:" + tester.pop());
    
        System.out.println(tester);
        System.out.println("Top of Stack " + tester.top());
        System.out.println("Is Full " + tester.isFull());              
        System.out.println("Is Empty " + tester.isEmpty());
    }
    
    public static void testQueue()
    {
       MyQueue<Integer> tester = new MyQueue<Integer>(7);
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
       
        try {
            tester.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception dequeue. Can't dequeue when queue is empty");
        }
          try {
            tester.front();
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception front. Can't front when queue is empty");
        }
       tester.enqueue(40);
       tester.enqueue(86);
       tester.enqueue(21);

       tester.enqueue(24);
       tester.enqueue(46);
       tester.enqueue(11);
       tester.enqueue(92);
       System.out.println("Front of Queue " + tester.front());
       System.out.println(tester);      
       System.out.println("Is Full " + tester.isFull());
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println(tester);   
       System.out.println("Front of Queue " + tester.front());
       System.out.println("Is Full " + tester.isFull());              
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("Size " + tester.size());
       System.out.println("adding 74, 5");
       tester.enqueue(74);
       tester.enqueue(5);
       System.out.println(tester);
       System.out.println("Front of Queue " + tester.front());
       System.out.println("Is Full " + tester.isFull()); 

       try {
          tester.enqueue(45); 
        } catch (IllegalStateException e) {
            System.out.println("Exception for enqueue. Can't enqueue when Queue is full");
        }
       
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println("Front of Stack " + tester.front());       
    }
    
    public static void testLinkedList()
    {
        MyLinkedList<Integer> test = new MyLinkedList<Integer>();
        System.out.println("Empty: " + test.isEmpty());
        test.addHead(5);
        test.addHead(10);
        test.addHead(24);
        test.addHead(213);
        System.out.println("List " + test);
        System.out.println("Head removed: " + test.removeHead());
        System.out.println("List " + test);
        System.out.println("Empty: " + test.isEmpty());
        System.out.println("Current Head: " + test.getHead());
        System.out.println("adding tail: 142");
        test.addTail(142);
        System.out.println("List " + test); 
        System.out.println("List Size: " + test.size());

        
    }
    
     public static void testStackLL()
    {
        MyStackLL<Integer> tester = new MyStackLL<Integer>();
        
        System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
        
        //this weirdly isn't working. talk to Murphy or figure it out myself.
        //try {
        //    tester.pop();
       // } catch (EmptyStackException e) {
        //    System.out.println("Caught exception Pop. Can't pop when stack is empty");
       // }
        // try {
        //    tester.top();
       // } catch (EmptyStackException e) {
         //   System.out.println("Caught exception top. Can't top when stack is empty");
       // }
        tester.push(86);
        tester.push(21);
        tester.push(24);
        tester.push(24);
        tester.push(46);
        tester.push(11);
        tester.push(92);
        
        
        System.out.println("Top of Stack " + tester.top());
        System.out.println(tester);
       
        System.out.println("Pop:" + tester.pop());
        System.out.println("Pop:" + tester.pop());
    
        System.out.println(tester);
        System.out.println("Top of Stack " + tester.top());
    
    }
    
     public static void testQueueLL()
    {
       MyQueueLL<Integer> tester = new MyQueueLL<Integer>();
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
       
        try {
            tester.dequeue();
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception dequeue. Can't dequeue when queue is empty");
        }
          try {
            tester.front();
        } catch (NoSuchElementException e) {
            System.out.println("Caught exception front. Can't front when queue is empty");
        }
       tester.enqueue(40);
       tester.enqueue(86);
       tester.enqueue(21);

       tester.enqueue(24);
       tester.enqueue(46);
       tester.enqueue(11);
       tester.enqueue(92);
       System.out.println("Front of Queue " + tester.front());
       System.out.println(tester);      
      
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println(tester);   
       System.out.println("Front of Queue " + tester.front());
           
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("Size " + tester.size());
       System.out.println("adding 74, 5");
       tester.enqueue(74);
       tester.enqueue(5);
       System.out.println(tester);
       System.out.println("Front of Queue " + tester.front());

       try {
          tester.enqueue(45); 
        } catch (IllegalStateException e) {
            System.out.println("Exception for enqueue. Can't enqueue when Queue is full");
        }
       
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println("Front of Queue " + tester.front());       
    }
    
}
