import java.util.NoSuchElementException;
/**
 * Write a description of class RobustLinkedList here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MyRobustLinkedList<E>

//just double check method names then we can call it a day 
{
    private Node<E> head;
    private Node<E> tail;
    private int size; 
    
    public void add(E element) {
        addTail(element);
    }
    
    public void add(int index, E element) {

        if (index < 0 || index >= size())
        {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addHead(element);
        } else if(index == size()-1) {
            addTail(element);
        } else {
            Node<E> newNode = new Node<E>(element);
            Node<E> temp = head;
            //implementation in the middle 
            for (int i = 0; i < index; i++) {
                 temp = temp.getNext();
            }
            newNode.setNext(temp);
            newNode.setPrev(temp.getPrev());
            temp.getPrev().setNext(newNode);
            temp.setPrev(newNode); 
            size++;
        }
    }
    
    public E get(int index) {
        Node<E> temp = head;
        //implementation in the middle 
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        
        return temp.getElement();
    }
    
    public void addHead(E element) {
        Node<E> newNode = new Node<E>(element);
        if(isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            newNode.getNext().setPrev(newNode);
            head = newNode;
        }
        size++;
    }
    
    public void set(int index, E element) { 
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        temp.setElement(element);
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeHead();
        } else if (index == size() - 1) { 
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            E removalVal = temp.getElement();
            temp.getPrev().setNext(null);
            temp = null;
            size--;
            return removalVal;
        } else {
            //remove middle  
            Node<E> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
            E removalVal = temp.getElement();
            
            temp.getNext().setPrev(temp.getPrev()); 
            temp.getPrev().setNext(temp.getNext());
            size--;
            temp = null; 
            return removalVal;
        }
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
            newNode.setPrev(tail);
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
            head.setPrev(null);
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
            //improve this toString a little so there is no comma on the end 
            print = print + temp.getElement() + ", "; 
            temp = temp.getNext(); 
        }
        return print; 
    }
    
    private class Node<E> {
        private E element;
        private Node<E> next; 
        private Node<E> prev;
        
        private Node(E element) {
            this.element = element;
            this.next = null; 
            this.prev = null; 
        }
        
        private E getElement() {
            return element;
        }
        
        private Node<E> getNext() {
            return next;
        }
        
        private Node<E> getPrev(){
            return prev;
        }
        
        private void setElement(E element) {
            this.element = element;
        }
        
        private void setNext (Node<E> next){
            this.next = next; 
        }
        
        private void setPrev (Node<E> prev) { 
            this.prev = prev;
        }
    }
}

