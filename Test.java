//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

/**
 * Tests all the methods 
 *
 * @author Zach Derhake
 * @version 10/30/24
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
        System.out.println("Is Empty: " + tester.isEmpty());
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
        System.out.println("is empty: " + tester.isEmpty());
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
    
        
    public static void testRobustLinkedList()
    {
        MyRobustLinkedList<Integer> test = new MyRobustLinkedList<Integer>();
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
        test.addTail(100);
        System.out.println("List " + test); 
        System.out.println("Index of. 24 passed as parameter. Return value:" + test.lastIndexOf(24));
        System.out.println("List Size: " + test.size());
        System.out.println("add method testing");
        test.add(124);
        System.out.println(test);
        test.add(2, 21);
        System.out.println(test);
        test.add(5, 176);
        System.out.println(test);
        test.add(7, 22);
        System.out.println(test);
        try {
            test.add(-1, 176);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exeption caught when trying to add and index == -1");
        }
        try {
            test.add(21412, 176);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Exeption caught when trying to add and index ==  12412");
        }
        System.out.println(test);
        System.out.println("Getting index 3:" +test.get(3));
        System.out.println("Getting index 0:" +test.get(0));
        System.out.println("Getting index 6:" +test.get(6));
        
        System.out.println(test);
        test.set(3, 100);
        System.out.println("setting index 3:" + test);
        test.set(0, 100);
        System.out.println("setting index 0:" +test);
        test.set(6, 100);
        System.out.println("setting index 6" + test);
        
        System.out.println("\n testing remove");
        
        System.out.println(test);
        System.out.println("removing index 6: " + test.remove(6));
        System.out.println(test);
        System.out.println("removing index 3: " + test.remove(3));
        System.out.println(test);
        System.out.println("removing tail " + test.remove(5));
        System.out.println(test);
        
        System.out.println("new phase of testing");
        MyRobustLinkedList<ShowCharacter> list = CharacterDatabase.buildListDatabase(); 
        System.out.println(list);
        System.out.println("Index of Character Testing:");
        System.out.println("Fred Index of " + list
                .indexOf(new ShowCharacter("Fred", "Flintstone", "The Flintstones", "Alan Reed")));
        System.out.println("Fred Index of " + CharacterDatabase.buildListDatabase()
                .indexOf(new ShowCharacter("Phoebe", "Buffay", "", "")));
        System.out.println("Poopy Poop" + CharacterDatabase.buildListDatabase()
                .indexOf(new ShowCharacter("Poopy", "Poop", "", "")));        
         System.out.println("Nullers" + CharacterDatabase.buildListDatabase()
                .indexOf(null));
                
        //test my remove method. 
        System.out.println("Testing remove method");
        MyRobustLinkedList<Integer> test2 = new MyRobustLinkedList<Integer>();
        System.out.println(test2.remove((Integer)5));
        test2.add(2);
        test2.add(3);
        System.out.println("5" + test2.remove((Integer)5));
        System.out.println("3" + test2.remove((Integer)3));
        System.out.println(test2);
        System.out.println("remove 5" + test2.remove((Integer)5));
        System.out.println("insertion sorted List Testing");
        list.insertSorted(new ShowCharacter("Walter", "White", "", ""));
        list.insertSorted(new ShowCharacter("A", "A", "", ""));
        list.insertSorted(new ShowCharacter("hi", "hilly", "", ""));
        System.out.println(list);
        System.out.println("last minute testing");
        System.out.println("remove");
        System.out.println(test);
        System.out.println("Index of Testing");
        System.out.println(list.indexOf(null));
        System.out.println("Adding null in list");
        list.add(null);
        System.out.println(list);
        System.out.println(list.indexOf(null));
    }

    
    public static void testApplications() {
        System.out.println("Reverse testing: ");
        MyQueueLL<Integer> tester = new MyQueueLL<Integer>();
        tester.enqueue(40);
        tester.enqueue(86);
        tester.enqueue(21);
        tester.enqueue(24);
        tester.enqueue(46);
        tester.enqueue(11);
        tester.enqueue(92);
        System.out.println("Current Queue: " + tester);
        Applications.reverse(tester);
        System.out.println("After Reverse Method: " + tester);
        
        System.out.println("\nPostFix Testing");
        System.out.println(Applications.evalPostfix("1 2 +"));
        System.out.println(Applications.evalPostfix("12 2 * 11 +"));

    }
}