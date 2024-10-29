
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
    //untested 
    public static boolean checkSyntax(String code) {
        MyStackLL<String> temp = new MyStackLL<String>();
        int i = 0;
        while (i < code.length()) {
            if ("({[<".indexOf(code.substring(i, i+1)) != -1) {
                temp.push(code.substring(i,i+1));
            } else if (")}]>".indexOf(code.substring(i, i+1)) != -1) {
                //if temp.top is empty it will throw an exeption. when really it should return false; 
                if (!temp.isEmpty()) { 
                    if (")}]>".indexOf(code.substring(i, i+1)) == (")}]>".indexOf(temp.top()))) {
                        temp.pop();
                    } else {
                        return false;
                    }
                } else {
                    return false; 
                }
            }
            i++;
        }
        if (temp.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
