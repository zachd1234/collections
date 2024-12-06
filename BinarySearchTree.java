
/**
 * A Binary Search Tree implementation with generic elements.
 *
 * @author Zach Derhake.
 * @version 12/4/24.
 */
public class BinarySearchTree<E extends Comparable<E>> {
    
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
                    Node<E> insertNode = new Node<E>(newElement);
                    right = insertNode; 
                    return true;
                } else {
                    return right.insert(newElement);
                }
            } else if (comparison < 0) { //go left 
                 if(left == null) {
                    Node<E> insertNode = new Node<E>(newElement);
                    left = insertNode;
                    return true; 
                } else {
                    return left.insert(newElement);
                }
            } else {
                //if comparison == 0, newElement is a duplicate 
                return false;
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
        
        private void setLeft (Node<E> next){
            this.left = left; 
        }
        
        private void setRight (Node<E> right) { 
            this.right = right;
        }
    }
