import java.util.Arrays;
/**
 * Write a description of class MyQueue here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyQueue
{
    private int[] arr;
    private int frontIndex;
    private int endIndex;
    private int queueSize;
    //top of index
    
    public MyQueue (int size) {
        arr = new int[size];
        frontIndex = 0;
        endIndex = 0;
        queueSize = 0; 
    }
    
    public MyQueue() {
        arr = new int[100];
        frontIndex = 0; 
        endIndex = 0;
        queueSize = 0;
    }
    
    public boolean isEmpty()
    {
        if (queueSize == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public int size() 
    {
        return queueSize;
    }
    
    public void enqueue(int element) 
    {
       //assumes that element is not full.
       //assume that endIndex is in place going into this method call 
       //
       arr[endIndex] = element;
       endIndex = (endIndex + 1) % arr.length;
       queueSize++;
    }
    
    public int dequeue()
    {
        int rValue = arr[frontIndex];
        frontIndex++;
        queueSize--;
        return rValue;
    }
    
     public String toString()
    {
        return Arrays.toString(arr);
    }
}