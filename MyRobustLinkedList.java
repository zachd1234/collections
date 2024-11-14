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
            //implementation in the middle 
            Node<E> cursor; 
            
            if ((size/2) > index) {
                cursor = head;
                 for (int i = 0; i < index; i++) {
                 cursor = cursor.getNext();
                }
            } else {
                cursor = tail; 
                for (int i = size-1; i > index; i--) {//could be wrong
                    cursor = cursor.getPrev();
                }
            }
            newNode.setNext(cursor);
            newNode.setPrev(cursor.getPrev());
            cursor.getPrev().setNext(newNode);
            cursor.setPrev(newNode); 
            size++;
        }
    }
    
    public E get(int index) {
        Node<E> cursor; 
            if ((size/2) > index) {
                cursor = head;
                 for (int i = 0; i < index; i++) {
                 cursor = cursor.getNext();
                }
            } else {
                cursor = tail; 
                for (int i = size-1; i > index; i--) {//could be wrong
                    cursor = cursor.getPrev();
                }
            }
        return cursor.getElement();
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
       Node<E> cursor; 
            if ((size/2) > index) {
                cursor = head;
                 for (int i = 0; i < index; i++) {
                 cursor = cursor.getNext();
                }
            } else {
                cursor = tail; 
                for (int i = size-1; i > index; i--) {//could be wrong
                    cursor = cursor.getPrev();
                }
            }
        cursor.setElement(element);
    }
    
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeHead();
        } else if (index == size() - 1) { 
            //efficent traverse  
            Node<E> cursor; 
            if ((size/2) > index) {
                cursor = head;
                 for (int i = 0; i < index; i++) {
                 cursor = cursor.getNext();
                }
            } else {
                cursor = tail; 
                for (int i = size-1; i > index; i--) {
                    cursor = cursor.getPrev();
                }
            }
            E temp = cursor.getElement();
            cursor.getPrev().setNext(null);
            cursor = null;
            size--;
            return temp;
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
    
    
    public int indexOf(E element) {
        //could theoretically throw exeption when LL is empty
        Node cursor = head; 
        for (int i = 0; i < size; i++) {     
            if(cursor.getElement().equals(element)) {
                return i;
            }
            cursor = cursor.getNext();
        }
        return -1; 
    }
    
    public int lastIndexOf(E element) {
        Node cursor = head; 
        int foundIndex = -1; 
        for (int i = 0; i < size; i++) {     
            if(cursor.getElement().equals(element)) {
                foundIndex = i;
            }
            cursor = cursor.getNext();
        }
        return foundIndex; 
    }
    
    
    /**
     * Removes first occurrence of matching element.
     * 
     * @param .
     * @returns .
     * @throws .
     */
    //ask Mr Murphy about the conflict between these two remove methods 
    public boolean removey(E element) {
        
        // index of (E element)
        //if index Of = -1 , false
        //else remove and return true 
        
        int valIndex = indexOf(element);
        if (valIndex == -1) {
            return false;
        } else {
            remove(valIndex);
            return true; 
        }
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

