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
        
        System.out.println("Testing Syntax Use Cases");
        System.out.println("Empty " + Applications.checkSyntax(""));
        System.out.println("()" + Applications.checkSyntax("()"));
        System.out.println("(()" + Applications.checkSyntax("(()"));
        System.out.println("\nPostFix Testing");
        System.out.println(Applications.evalPostfix("1 2 +"));
        System.out.println(Applications.evalPostfix("12 2 * 11 +"));
        System.out.println(Applications.evalPostfix("1 2 /"));
        System.out.println(Applications.evalPostfix("1 2 -"));
        System.out.println(Applications.evalPostfix("1 2 %"));
        System.out.println(Applications.evalPostfix("2 4 6 + 3 * -"));

    }
    
    public static void testHashTable() {
        
        System.out.println("TESTING WITH LETTERS");
        MyHashTable<String, String> test = new MyHashTable<String, String>();
        System.out.println(test.toString());
        test.put("A", "a");
        System.out.println(test.size());
        System.out.println(test.toString());
        test.put("B", "b");
        System.out.println(test.size());
        System.out.println(test.toString());
        test.put("A", "aa");
        test.remove("A");
        System.out.println(test.size());
        System.out.println(test.toString());
        
        System.out.println("TESTING THIS WEIRD ERROR");
        MyHashTable<String, String> test5 = new MyHashTable<String, String>();

        test5.put("A", "a");
        test5.put("AA", "aa");
        test5.put("AAA","aaa");
        test5.put("AAAA","aaaa");
        test5.put("AAAAA","aaaaa");
        System.out.println(test5.size());
        System.out.println(test5.toString());
        test5.put("A", "aa");
        test5.put("AA", "aaa");
        test5.put("AAA","aaaa");
        test5.put("AAAA","aaaaa");
        test5.put("AAAAA","aaaaaa");
        System.out.println(test5.size());
        System.out.println(test5.toString());

        System.out.println("TESTING WITH CHARACTERS");
        ShowCharacter fred = new ShowCharacter("Fred", "Flintstone", "The Flintstones", "Alan Reed");
        ShowCharacter fred1 = new ShowCharacter("Barney", "Rubble", "The Flintstones", "Mel Blanc");
        ShowCharacter fred2 = new ShowCharacter("Betty", "Rubble", "The Flintstones", "Bea Benaderet");
        ShowCharacter fred3 = new ShowCharacter("Fred", "Flintstone", "The Flintstones", "Alan Reed");
        ShowCharacter fred4 = new ShowCharacter("Ross", "Geller", "Friends", "David Schwimmer");
        ShowCharacter fred5 = new ShowCharacter("Phoebe", "Buffay", "Friends", "Lisa Kudrow");

        MyHashTable<String, ShowCharacter> test2 = new MyHashTable<String, ShowCharacter>();
        System.out.println(test2.toString());
        test2.put(fred.getKey(), fred);
        System.out.println(test2.size());
        System.out.println(test2.toString());
        test2.put(fred1.getKey(), fred1);
        System.out.println(test2.size());
        System.out.println(test2.toString());
        test2.put(fred5.getKey(), fred5);
        test2.remove(fred.getKey());
        System.out.println(test2.size());
        System.out.println(test2.toString());
        
        
        MyHashTable<Integer, Integer> test3 = new MyHashTable<Integer, Integer>();
        test3.put(1,5);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4,3);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(23,2);
        System.out.println(test3.size());
        System.out.println(test3.toString());  
        test3.put(42,1233);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4123123,3565);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(764,332);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4798,33);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(324,3432);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(854,43263);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4324623,37432);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(234674,3245);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(2344,389);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(82542,875343);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(849,3324662);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4869,23435);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4452,3345653);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(4234323,34643);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(445676543,345637);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(487654,345678);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(21446,3589);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(1242,36437);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(3464364,3346346);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(47547,343268);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(432467,432535);
        System.out.println(test3.size());
        System.out.println(test3.toString());
        test3.put(46432634,3351271);
        System.out.println(test3.size());
        System.out.println(test3.toString());

    }
    
    public static void testHashApplications() {
        Integer[] intTest = {10, 11, 12, 13, 14, 15, 16, 17};
        Integer[] intTest2 = {10, 11, 12, 13, 10, 15, 16, 17};
        
        boolean noDup = Applications.containsDuplicate(intTest);
        boolean dup = Applications.containsDuplicate(intTest2);
        System.out.println("Array without duplicate " + noDup);
        System.out.println("Array with duplicate " + dup);
        
        System.out.println("TESTING SUBSET");
        //Integer[] intTest3 = {10, 11, 12};
        //Integer[] intTest4 = {10, 11, 12, 13, 10, 15, 16, 17};
        //System.out.println(Applications.isSubset(intTest3, intTest4));
        //System.out.println(Applications.isSubset(intTest4, intTest3));
        
        Integer[] intTest6 = {15, 11, 12};
        Integer[] intTest5 = {10, 11, 12, 13, 14, 21, 16, 17};
        System.out.println(Applications.isSubset(intTest5, intTest6));

    }
}