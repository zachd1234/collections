
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
    
    private class Node<E> {
        
        private E element;
        private Node<E> left; 
        private Node<E> right;
        
        private Node(E element) {
            this.element = element;
            this.left = null; 
            this.right = null; 
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
}
