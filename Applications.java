import java.util.ArrayList;

 import java.util.Arrays;
/**
 * Write a description of class Applications here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class Applications
{
    public static <E> void reverse(MyQueueLL<E> queue) {
        //use a stack to reverse a queue
        //load it off the queue to stack
        //load stack back to the queue 
        
        MyStackLL<E> temp = new MyStackLL<E>();
        
        while(!queue.isEmpty()) {
            temp.push(queue.dequeue());
        }
        
        while(!temp.isEmpty()) {
            queue.enqueue(temp.pop());
        }
    }

    public static boolean checkSyntax(String code) {
        MyStackLL<String> temp = new MyStackLL<String>();
        int i = 0;
        while (i < code.length()) {
            if ("({[<".indexOf(code.substring(i, i+1)) != -1) {
                temp.push(code.substring(i,i+1));
            } else if (")}]>".indexOf(code.substring(i, i+1)) != -1) {
                //if temp.top is empty it will throw an exeption. when really it should return false; 
                if (temp.isEmpty()) { 
                    return false;
                }
                
                String top = temp.pop(); 
                
                if (")}]>".indexOf(code.substring(i, i+1)) != ("({[<".indexOf(top))) {
                        return false;
                }
            }
            i++;
        }
        return temp.isEmpty();
    }   
    
    public static double evalPostfix(String expression) {
        String[] arr = expression.split(" ");
        MyStackLL<Double> temp = new MyStackLL<Double>();
        for (int i = 0; i < arr.length; i++) {
            if ("*+-/%".indexOf(arr[i]) != -1) { 
                double value2 = temp.pop();
                double value1 = temp.pop();
                double newValue;
                if ("*+-/%".indexOf(arr[i]) == 0) {
                     newValue = value1 * value2;
                } else if ("*+-/%".indexOf(arr[i]) == 1) {
                     newValue = value1 + value2;
                } else if ("*+-/%".indexOf(arr[i]) == 2) {
                     newValue = value1 - value2; //make sure that this is right
                } else if ("*+-/%".indexOf(arr[i]) == 3) {
                     newValue = value1 / value2; //make sure that this is right
                } else { 
                     newValue = value1 % value2; //make sure order is right
                }
                temp.push(newValue);
            } else {
                temp.push(Double.parseDouble(arr[i]));
            }
            
        }
        return temp.top(); 
    }
    
    /**
     * Determines the lowest 20 numbers randomly generated and prints them in ascending order.
     * 
     */
    public static void top20() {
        MyHeap<Integer> heap = new MyHeap<Integer>(false);
        for (int i = 0; i < 1000; i++) {
            int ranNum = (int)(Math.random() * 1000);
            if(heap.size() < 20) {
                heap.add(ranNum);
            } else {
                heap.add(ranNum);
                heap.removeTop();
            }
        }
        System.out.println(heap);
    }
    
    /**
     * Determines whether array contains duplicates.
     * 
     * @param arr array to evaluate the duplicates of.
     * @return true if the arr contains duplicates, false otherwise. 
     */
    public boolean containsDuplicate(int[] arr) { //change to E[]. 
        //go through. 
        //remove. 
        //then put. 
        //evaluate the size change. 
        return true; 
    }
}