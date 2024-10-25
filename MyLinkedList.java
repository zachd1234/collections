import java.util.NoSuchElementException;

/**
 * Write a description of class MyLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)* 

 */
public class MyLinkedList<E>
{
    private Node<E> head;
    private Node<E> tail;
    private int size; 
    
    
    public void addHead(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(head);
        head = newNode;
        if (isEmpty()) { 
            tail = head;
        }
        size++;
    }
    
    public void addTail(E element) {
        
        //confused about tail. what if the tail is the first element added.
        //do i then also have to set the head to tail as well? 
        Node<E> newNode = new Node<E>(element);
        
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;  
        }
        size++;
        
    }
    
    public E removeHead() {
        if (isEmpty())
        {
            throw new NoSuchElementException(); 
        } else if (size == 1) { 
            E firstItem = head.getElement();
            head = null;
            tail = null;
            size--;
            return firstItem;
        } else {
        E firstItem = head.getElement();
        head = head.getNext();
        size--;
        return firstItem;
        }
    }
    
    public E getHead() {
        if (isEmpty())
        {
            throw new NoSuchElementException(); 
        }
        return head.getElement();
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
            print = print + " " + temp.getElement(); 
            temp = temp.getNext(); 
        }
        return print; 
    }
    
    
    
    private class Node<E> {
        private E element;
        private Node<E> next; 
        
        private Node(E element) {
            this.element = element;
            this.next = null; 
        }
        
        private E getElement() {
            return element;
        }
        
        private Node<E> getNext() {
            return next;
        }
        
        private void setElement(E element) {
            this.element = element;
        }
        
        private void setNext (Node<E> next){
            this.next = next; 
        }
    }
}
