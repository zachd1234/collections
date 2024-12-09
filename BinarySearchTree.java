/**
 * A Binary Search Tree implementation with generic elements.
 *
 * @author Zach Derhake.
 * @version 12/4/24.
 */

import java.util.NoSuchElementException;


public class BinarySearchTree<E extends Comparable<E>> {
    
    private int size; 
    private Node<E> root;
    private int depth;

    /**
     * Initializes an empty binary search tree. 
     */
    public BinarySearchTree() {
        size = 0;
        root = null;
        depth = 0;
    } 
    
    /**
     * Inserts element into BST.
     *  
     * @param E element to be added into the tree 
     * @return true if the element was sorted, false otherwise
     * @throws NullPointerException if element is null
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
     * @return The matching element that was removed from BST, returns null if not found.
     * @throws NullPointerException if element is null.
     */
    public E remove(E element) {
        if (element == null) {
            throw new NullPointerException();
        } else if (root == null) {
            return null;
        } else {
            return root.remove(element, null);
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
     * @return the minimum element in BST.
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
     * @return the maximum element in BST.
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
     * @The minimum element that was removed from BST.
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
     * @The maximum element that was removed from BST.
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
     * @return number of levels in BST.
     */
    public int getDepth(){
        if (root == null) {
            return 0;
        } else {
             root.getDepth(1);
             return depth;
        }
    }
    
    /**
     * Indicates whether BST is empty.
     * 
     * @return true if the list is empty, false otherwise. 
     */
    public boolean isEmpty() {
        return size <= 0;
    }
    
    /**
     * Returns number of elements in BST.
     * 
     * @return number of elements in BST.
     */
    public int size() {
        return size;
    }   
    
    private void setRoot(Node<E> newRoot) {
        root = newRoot;
    }
    
    /**
     * Returns elements in sorted array.
     * 
     * @return a sorted array of generic elements in the BST
     *     public E[] toArray() {
     */
     public E[] toArray() {
         E[] arr = new E[size];
         if (root  == null) {
             return arr; 
         } else {
                
         }
    }
    
    /**
     * Returns elements in sorted order as a string.
     * 
     * @return string of BST elements in comma seperated sorted order
     */
    public String toString() {
        if (root == null) {
            return "";
        } else {
            return root.buildToString();
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
        
        private E remove(E element, Node<E> parent) {
            int comparison = element.compareTo(this.element);
        
            if (comparison == 0) { //if element matches
                //we found it
                if (right != null && left != null) { //remove two parents
                    E replacement = left.removeMax(this);
                    E temp = this.element;
                    this.element = replacement;
                    return temp;
                } else if (left != null) {
                    if (parent == null) { //root use case
                        root = left; 
                        return this.element;
                    } else {
                        if(parent.left == this) {
                            parent.left = left;
                        } else {
                            parent.right = left;
                        }
                        return this.element;
                    }
                } else if (right != null) {
                     if (parent == null) { //root use case
                        root = right; 
                        return this.element;
                    } else {
                        if(parent.right == this) {
                            parent.right = right;
                        } else {
                            parent.left = right;
                        }
                        return this.element;
                    }
                } else { //remove leaf
                    if (parent != null) {
                        //did it come from parents right or left?
                        if(parent.left == this) {
                            parent.left = null;
                        } else {
                            parent.right = null;
                        }
                        return this.element;
                    } else {
                        root = null;
                        return this.element;
                    }
                } 
            } else if (comparison > 0) { //go right
                if(right == null) {
                    return null;
                } else {
                    return right.remove(element, parent);
                }
            } else { //go left
                if(left == null) {
                    return null;
                } else {
                    return left.remove(element, parent);
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
                right = right.removeMin();
                return this;
            }
        }
        
        private void getDepth(int level) {
            if(left != null) {
                left.getDepth(level+1);
            } 
            
            if (right != null) {
                right.getDepth(level+1);
            } 
            
            if (level > depth) {
                depth = level;
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
                //when node doesn't have children 
                return "" + element;
            }
            
        }
   }
}