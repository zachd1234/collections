/**
 * A robust linked list of a generic doubly linked list
 *
 * @param <E> type of element stored in the list that implement the comparable interface
 * @author Zach Derhake
 * @version Nov 21 11:59pm 2024
 */

import java.util.NoSuchElementException;

public class MyRobustLinkedList<E extends Comparable<E>> {
    
    private Node<E> head;
    private Node<E> tail;
    private int size; 
    
    /**
     * Initializes an empty RobustLinkedList with head and tail set to null and size set to zero 
     */
    public MyRobustLinkedList() {} 
    
    /**
     * Adds generic element to end of linked list (tail)
     * 
     * @param E type of element to be added that implements the comparable interface  
     */
    public void add(E element) {
        addTail(element);
    }
    
    /**
     * Inserts element to the specified index in the list
     * 
     * @param index that element should be inserted at 
     * @param E element to be inserted in the list
     * @throws IndexOutOfBoundsException if index is less than zero or greater than size
     */
    public void add(int index, E element) {

        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            addHead(element);
        } else if(index == size()) {
            addTail(element);
        } else {
            //implementation in the middle 
            Node<E> newNode = new Node<E>(element);
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
            newNode.setNext(cursor);
            newNode.setPrev(cursor.getPrev());
            cursor.getPrev().setNext(newNode);
            cursor.setPrev(newNode); 
            size++;
        }
    }
    
    /**
     * Finds and returns element at specified index 
     * 
     * @param index at which element is to be returned
     * @throws IndexOutOfBoundsException if index is less than zero or greater than size
     * @return E element at which index corresponds to 
     */
    public E get(int index) {
        Node<E> cursor;
        if (index < 0 || index >= size()) {
             throw new IndexOutOfBoundsException();  
        } else if ((size/2) > index) {
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
        return cursor.getElement();
    }   
    
    /**
     * Adds a new head to the front of the linked list with E element as the value
     * 
     * @param E element to serve as the data value for the new head
     */
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
    
    /**
     * Replaces a value within the linked list at specified index with given element
     * 
     * @param index to set with a new value
     * @param element to become the new value at specified index  
     * @throws IndexOutOfBoundsException if index is less than zero or greater than or equal to size
     */
    public void set(int index, E element) { 
       if (index < 0 || index >= size()) {
             throw new IndexOutOfBoundsException();  
       }
       Node<E> cursor; 
       //efficient traversal
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
       cursor.setElement(element);
    }
    
    /**
     * Remove an item in list at specified index 
     * 
     * @param index positiion in the list to remove value at 
     * @return element that was removed
     * @throws IndexOutOfBoundsException if index is less than zero or greater than or equal to size
     */
    public E remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0) {
            return removeHead();
        } else if (index == size() - 1) { 
            //remove tail
            Node<E> temp = tail;
            E removalVal = temp.getElement();
            temp.getPrev().setNext(null);
            tail = temp.getPrev();
            temp = null;
            size--;
            return removalVal;
        } else {
            //remove middle  
            Node<E> cursor; 
            //efficient traversal
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
            E removalVal = cursor.getElement();
            cursor.getNext().setPrev(cursor.getPrev()); 
            cursor.getPrev().setNext(cursor.getNext());
            size--;
            cursor = null; 
            return removalVal;
        }
    }

    /**
      * Adds specified element to the end of the list (at the tail)
      * 
      * @param element to be added to the end of the list 
      */
    public void addTail(E element) {
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
    
     /**
      * Removes and returns element at the front of list (head)
      * 
      * @return element that was removed from the head 
      * @throws NoSuchElementException if list is empty
      */
    public E removeHead() {
        if (isEmpty()) {
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
    
    /**
     * returns the element at the head of the linked list
     * 
     * @return element at the head of the linked list 
     * @throws NoSuchElementException if the list is empty 
     */
    public E getHead() {
        if (isEmpty()) {
            throw new NoSuchElementException(); 
        }
        return head.getElement();
    }
    
    /**
     * Returns whether the list is empty
     * 
     * @return whether the list is empty or not 
     */
    public boolean isEmpty() {
        return size <= 0;
    }
    
    /**
     * Returns the size of the list 
     * 
     * @return the size of the list 
     */
    public int size() {
        return size; 
    }
    
    /**
     * Finds whether an element exists in the list and returns the index of the first occurrence, or -1 if not found
     * 
     * @param element to search for in list
     * @return the index of the first occurrence of specified element in the list or -1 if not found  
     */
    public int indexOf(E element) {
        Node cursor = head; 
        for (int i = 0; i < size; i++) {  
            if ((element == null && cursor.getElement() == null) || 
            (element != null && element.equals(cursor.getElement()))) {
                return i;
            }
            cursor = cursor.getNext();
        }
        return -1; 
    }
    
    /**
     * Finds whether an element exists in the list and returns the index of the last occurrence, or -1 if not found
     * 
     * @param element to search for in list
     * @return the index of the last occurrence of specified element in the list or -1 if not found  
     */
    public int lastIndexOf(E element) {
        Node cursor = head; 
        int foundIndex = -1; 
        for (int i = 0; i < size; i++) { 
          if ((element == null && cursor.getElement() == null) || 
            (element != null && element.equals(cursor.getElement()))) {
                foundIndex = i;
            }
            cursor = cursor.getNext();
        }
        return foundIndex; 
    }
    
    
    /**
     * Removes first occurrence of matching element.
     * 
     * @param element to search for and remove (can be null) 
     * @return whether the element was found and removed from the list or false otherwise 
     */
    public boolean remove(E element) {
        
        int removeIndex = indexOf(element);
        if (removeIndex == -1) {
            return false;
        } else {
            remove(removeIndex);
            return true; 
        }
    }

    /**
     * Inserts element into sorted list.
     * 
     * @param element that implements comparable interface to insert into the list 
     * @throws IllegalArgumentException if element is null
     */
    public void insertSorted(E element) {
        if (element == null) {
            addHead(element);
        }
        Node<E> cursor = head;
         if (isEmpty()) {
            addHead(element);
            return;
        } else if (cursor.getElement().compareTo(element) > 0) {
            addHead(element);
            return;
        }
        
         for (int i = 0; i < size; i++) {
             if (cursor.getElement().compareTo(element) > 0) {
                Node<E> newNode = new Node<E>(element);
                newNode.setNext(cursor);
                newNode.setPrev(cursor.getPrev());
                cursor.getPrev().setNext(newNode);
                cursor.setPrev(newNode); 
                size++;
                return;
             }
             
             if(cursor == tail) {
                 addTail(element);
                 return;
             }
             cursor = cursor.getNext();
         }
    }
    
    /**
     * returns a string of the entire list with a comma delimiter
     * 
     * @return string of the entire list 
     */
    public String toString()  {
        String print = "";
        Node temp = head;
        
        for (int i = 0; i < size; i++) { 
            if (temp == tail) {
                print = print + temp.getElement();
            } else {
                print = print + temp.getElement() + ", "; 
            }
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

