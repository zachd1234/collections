
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
        Stack tester = new Stack(7);
        System.out.println("Is Empty " + tester.isEmpty());
        System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
        tester.push(40);
        tester.push(86);
        tester.push(21);

        tester.push(24);
        tester.push(46);
        tester.push(11);
        tester.push(92);
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
       MyQueue tester = new MyQueue(7);
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("adding 40, 86, 21, 24, 46, 11, 92");
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
       System.out.println("Front of Stack " + tester.front());
       System.out.println("Is Full " + tester.isFull());              
       System.out.println("Is Empty " + tester.isEmpty());
       System.out.println("Size " + tester.size());
       System.out.println("adding 74, 5");
       tester.enqueue(74);
       tester.enqueue(5);
       System.out.println(tester);
       System.out.println("Front of Stack " + tester.front());
       System.out.println("Is Full " + tester.isFull()); 
       System.out.println("Dequeue:" + tester.dequeue());
       System.out.println("Front of Stack " + tester.front());       
    }
    
}
