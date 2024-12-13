/**
 * A Binary Search Tree implementation with generic elements.
 *
 * @author Zach Derhake.
 * @version 12/4/24.
 */

import java.util.NoSuchElementException;
import java.util.Iterator;


public class BinarySearchTree<E extends Comparable<E>> implements Iterable {
    
    private int size; 
    private Node<E> root;

    /**
     * Initializes an empty binary search tree. 
     */
    public BinarySearchTree() {
        size = 0;
        root = null;
    } 
    
    /**
     * Inserts element into BST.
     *  
     * @param E element to be added into the tree.
     * @return True if the element was sorted, false otherwise.
     * @throws NullPointerException if element is null.
     */
    public boolean insert(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (root == null) {
            root = new Node(element);
            size++;
            return true;
        } else {
            if(root.insert(element)) {
                size++;
                return true;
            } else {
                return false;
            }
        }
    }
    
    /**
     * Removes and returns matching element.
     * 
     * @param E element that will be searched, removed and returned from BST.
     * @return The matching element that was removed from BST, null if not found.
     * @throws NullPointerException if element is null.
     */
    public E remove(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (root == null) {
            return null;
        } else {
            E searchVal = root.search(element);
            if (searchVal != null) {
                size--;
                root = root.remove(element);
            }
            return searchVal; 
        }
    }
    
    /**
     * Searches for and returns matching element.
     * 
     * @param E element to search for in the tree. 
     * @return The matching element in the tree, null if not found.
     * @throws NullPointerException if the element is null.
     */
    public E search(E element) {
        if (element == null) {
            throw new NullPointerException(); 
        } else if (root == null) {
            return null;
        } else {
            return root.search(element);
        } 
    }
    
    /**
     * Returns minimum element in BST.
     * 
     * @return The minimum element in BST.
     * @throws NoSuchElementException if the tree is empty. 
     */
    public E getMin() {
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            return root.getMin();
        }
    }
    
    /**
     * Returns maximum element in BST.
     * 
     * @return The maximum element in BST.
     * @throws NoSuchElementException if the tree is empty. 
     */
    public E getMax() {
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            return root.getMax();
        }
    }
    
    /**
     * Removes and returns minimum element.
     * 
     * @return The minimum element that was removed from BST.
     * @throws NoSuchElementException if the tree is empty 
     */
    public E removeMin(){
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            E min = getMin();
            root = root.removeMin();
            size--;
            return min;
        }
    }
    
    /**
     * Removes and returns maximum element.
     * 
     * @return The maximum element that was removed from BST.
     * @throws NoSuchElementException if the tree is empty.  
     */
    public E removeMax(){
        if (root == null) {
            throw new NoSuchElementException();
        } else {
            E max = getMax();
            root = root.removeMax();
            size--;
            return max;
        }
    }
    
     /**
     * Returns number of levels in BST.
     * 
     * @return Number of levels in BST.
     */
    public int getDepth(){
        if (root == null) {
            return 0;
        } else {
             return root.getDepth();
        }
    }
    
    /**
     * Indicates whether BST is empty.
     * 
     * @return True if the list is empty, false otherwise. 
     */
    public boolean isEmpty() {
        return size <= 0;
    }
    
    /**
     * Returns number of elements in BST.
     * 
     * @return Number of elements in BST.
     */
    public int size() {
        return size;
    }   
    
    /**
     * Returns elements in sorted array.
     * 
     * @return A sorted array of generic elements in the BST.
     */
     public E[] toArray() {
         E[] arr = (E[]) new Comparable[size];
         if (root  == null) {
             return arr; 
         } else {
              root.toArray(0, arr);
              return arr; 
         }
    }
    
    /**
     * Returns elements in sorted order as a string.
     * 
     * @return String of BST elements in comma seperated sorted order
     */
    public String toString() {
        if (root == null) {
            return "";
        } else {
            return root.buildToString();
        }
    }
 
    public Iterator<E> iterator() {
        return new BSTIterator(root);
    }

    private class BSTIterator implements Iterator<E> {
        private MyStackLL stack; 
        
        public BSTIterator(Node<E> root) {
            stack = new MyStackLL();
        }
        
        
        public boolean hasNext() {
        
        }
        
        public E next() {
            
        }

    }
   
    private class Node<E extends Comparable<E>> {
        
        private E element;
        private Node<E> left; 
        private Node<E> right;
        
        private Node(E element) {
            this.element = element;
            this.left = null; 
            this.right = null;  
        }
        
        private boolean insert(E newElement) {
            int comparison = newElement.compareTo(this.element);

            if (comparison > 0) { //go right 
                if(right == null) { 
                    right = new Node<E>(newElement); 
                    return true;
                } else {
                    return right.insert(newElement);
                }
            } else if (comparison < 0) { //go left 
                 if(left == null) {
                    left = new Node<E>(newElement);
                    return true; 
                } else {
                    return left.insert(newElement);
                }
            } else {
                //if comparison == 0, newElement is a duplicate 
                return false;
            }
        }
            
        private Node<E> remove(E element) {
            int comparison = element.compareTo(this.element);
            
              if (comparison == 0) {
                // we found it
                if (right != null && left != null) { //remove when two children
                    E replacement = left.getMax();
                    left = left.removeMax();
                    this.element = replacement;
                    return this;
                } else if (left != null) {
                    return left;
                } else if (right != null) {
                    return right; 
                } else { //remove leaf
                    return null;
                }
            } else if (comparison < 0) { //go left            
                if(left == null) {
                    return this;
                } else {
                    left = left.remove(element);
                    return this; 
                }
            } else { //go right
                if(right == null) {
                    return this;
                } else {
                    right = right.remove(element);
                    return this;
                }
            } 

        }
        
        private E search(E target) {
            int comparison = target.compareTo(this.element);
        
            if (comparison == 0) { //if element matches
                return this.element; 
            } else if (comparison > 0) { //go right
                if(right == null) {
                    return null; 
                } else {
                    return right.search(target);
                }
            } else { //go left
                if(left == null) {
                    return null;
                } else {
                    return left.search(target);
                }
            }
        }
        
        private E getMin() {
            if(left == null) {
                return element; 
            } else {
                return left.getMin();
            }
        }
        
         private E getMax() {
            if(right == null) {
                return element; 
            } else {
                return right.getMax();
            }
        }
        
        private Node<E> removeMin() {
              if(left == null) {
                if(right == null) {
                    return null;
                } else {
                    return right;
                }
            } else {                
                left = left.removeMin();
                return this;

            }
        }
        
        private Node<E> removeMax() {
               if(right == null) {
                if(left == null) {
                    return null;
                } else {
                    return left;
                }
            } else {                
                right = right.removeMax();
                return this;
            }
        }
        
        private int getDepth() {            
            if(left != null && right != null) {
                int leftDepth = 1 + left.getDepth();
                int rightDepth = 1 + right.getDepth();
                if (leftDepth > rightDepth) {
                    return leftDepth;
                } else {
                    return rightDepth; 
                }
            } else if (left != null) {
                return 1 + left.getDepth(); 
            } else if (right != null) {
                return 1 + right.getDepth(); 
            } else {
                return 1; 
            }
        }
        
         private E getElement() {
             return element;
        }
        
        private Node<E> getLeft() {
            return left;
        }
        
        private Node<E> getRight(){
            return right;
        }
        
        private void setElement(E element) {
            this.element = element;
        }
        
        private void setLeft (Node<E> next) {
            this.left = left; 
        }
        
        private void setRight (Node<E> right) { 
            this.right = right;
        }
        
        private int toArray(int index, E[] arr) {
            
            if (left != null) {
                index = left.toArray(index, arr); 
            }
            
            arr[index] = this.element; 
            index++; 
            
            if (right != null) {
                index = right.toArray(index, arr);
            }
            return index;
        }
                
        private String buildToString() {
            boolean hasLeft = left != null;
            boolean hasRight = right != null;
        
            if (hasLeft && hasRight) {
                return "" + left.buildToString() + ", " + element + ", " + right.buildToString();
            } else if (hasLeft) {
                return "" + left.buildToString() + ", " + element;
            } else if (hasRight) {
                return "" + element + ", " + right.buildToString();
            } else {
                //when node is leaf
                return "" + element;
            }
            
        }
    }
}