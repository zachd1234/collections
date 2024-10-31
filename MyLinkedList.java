//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890

import java.util.NoSuchElementException;

/**
 * a linked List Implementation 
 *
 * @author Zach Derhake
 * @version 10/30/24 
 */
public class MyLinkedList<E>
{
    
    private Node<E> head;
    private Node<E> tail;
    private int size; 
    
    /**
     * creates a new node and inserts it as the first element 
     * @param the data element to be added to the start of the list  
     */
    public void addHead(E element) {
        Node<E> newNode = new Node<E>(element);
        newNode.setNext(head);
        head = newNode;
        if (isEmpty()) { 
            tail = head; 
        }
        size++;
    }
    
    /**
     * creates a new node and inserts it at the end of the list 
     * @param the data element to be added to the end of the list 
     */
    public void addTail(E element) {
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
    
    /**
     * removes the first element of the list and returns it 
     * @return the data element of the first element before it was removed 
     * @throws NoSuchElementException if the list is empty  
     */
    public E removeHead() {
        if (isEmpty())
        {
            throw new NoSuchElementException(); 
        } else if (size == 1) { 
            E firstItem = head.getElement(); //holds return value
            head = null;
            tail = null;
            size--;
            return firstItem;
        } else {
        E firstItem = head.getElement(); //holds return value
        head = head.getNext();
        size--;
        return firstItem;
        }
    }
    
    /**
     * returns the first element in the list 
     * @return the data element of the first element in the list 
     * @throws NoSuchElementException if the list is empty 
     */
    public E getHead() {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        }
        return head.getElement();
    }
    
   /**
     *  Returns whether the list is empty 
     *  @return whether the list is empty or not 
     */
    public boolean isEmpty() {
        if (size <= 0) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * returns the amount of elements in the list 
     * @returns the amount of elements in the list  
     */
    public int size() {
        return size; 
    }
    
    /**
     * turns the list into a string and returns it 
     * @return the list in a String format with comma seperated values  
     */
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
        
        private void setNext(Node<E> next) {
            this.next = next; 
        }
    }
}
