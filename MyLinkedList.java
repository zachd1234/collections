
/**
 * Write a description of class MyLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyLinkedList
{
    private Node head;
    private Node tail;
    
    public void addHead(int data)
    {
    
    }
    
    public class Node
    {
        private int data;
        private Node next; 
        
        public Node(int data, Node next) {
            this.data = data;
            this.next = next; 
        }
        
        public int getData() {
            return data;
        }
        
        public Node getNext() {
            return next;
        }
        
        public void setData(int data) {
            this.data = data;
        }
        
        public void SetNode (Node next){
            this.next = next; 
        }
    }
}
