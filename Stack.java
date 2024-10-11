//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.Arrays;
/**
 * Write a description of class Stack here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Stack
{
    private int[] arr;
    private int topIndex; //the next available index to push an element to. 1 + top of stack. 
    
    public Stack (int size) {
        arr = new int[size];
        topIndex = 0;
    }
    
    public Stack() {
        arr = new int[10000];
        topIndex = 0;
    }
    
     public boolean isEmpty()
    {
        if (topIndex == 0)
        {
            return true;
        }
        else
        {
            return false; 
        }
    }
    
    public boolean isFull()
    {
        if (topIndex >= arr.length)
        {
            return true;
        }
        else
        {
            return false; 
        }
    }
    
    public void push(int newVal)
    {
        arr[topIndex] = newVal;
        topIndex++;
    }
    
    public int pop()
    {
        topIndex--;
        return arr[topIndex];
    }
    
    public int top()
    {
        return arr[topIndex-1];
    }
    
    public int size()
    {
        return topIndex;
    }
    
    public String toString()
    {
        return Arrays.toString(arr);
    }
}
