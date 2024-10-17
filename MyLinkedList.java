import java.util.NoSuchElementException;

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
    private int size; 
    
    
    public void addHead(int data) {
        size++;
        Node newHead = new Node(data, head); 
        head = newHead; 
    }
    
    public void newTail(int data) {
        
        //confused about tail. what if the tail is the first element added.
        //do i then also have to set the head to tail as well? 
        

        size++;
        Node newTail = new Node(data, null);
        
        tail = newTail; 
        //tail.setNode(newTail);
        
        //comes at end
        tail = newTail;
        
        //create new tail
        //attach current tail to new tail 
        //update tail to new tail 
    }
    
    public int removeHead() {
        if (isEmpty())
        {
            throw new NoSuchElementException(); 
        }
        size--;
        int firstItem = head.getData();
        head = head.getNext();
        return firstItem;
    }
    
    public int getHead() {
        if (isEmpty())
        {
            throw new NoSuchElementException(); 
        }
        return head.getData();
    }
    
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public int size() {
        return size; 
    }
    
    public String toString() 
    {
        String print = "";
        Node temp = head;
        
        for (int i = 0; i < size; i++) { 
            print = print + " " + temp.getData(); 
            temp = temp.getNext(); 
        }
        return print; 
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
        
        public void setNode (Node next){
            this.next = next; 
        }
    }
}
