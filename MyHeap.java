import java.util.NoSuchElementException;

/**
 * A Min Heap Tree Implemented in an Array
 *
 * @author Zach Derhake
 * @version 1/10/25
 */
public class MyHeap<E extends Comparable<E>>
{
    private E[] heap; 
    private int last; //keeps track of index
    
    /**
     * Initializes the Heap
     */
    public MyHeap(){
        heap = (E[]) new Comparable[100]; 
        this.last = 0;
    } 
    
     /**
     * Adds Element to Heap.
     * 
     * @param Element to be Inserted in the Heap 
     */
    public void add(E element) {
        heap[last] = element;
        trickleUp(last);
        last++; 
    }
    
    private void trickleUp(int childIndex) {
        if (!(childIndex <= 0)) {
            int parentIndex = (childIndex-1)/2;
            if(heap[childIndex].compareTo(heap[parentIndex]) < 0) {
                E swap = heap[parentIndex];
                heap[parentIndex] = heap[childIndex];
                heap[childIndex] = swap;
                trickleUp(parentIndex);
            }
        }
    }
    
    /**
     *  Gets Minimum Element From Heap.
     *  
     *  @return The Minimum Element From the Heap.
     *  @throws NoSuchElementException if Heap is Empty.
     */
    public E getMin() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return heap[0];
        }
    }
    
    /**
     * Removes and returns minimum element from heap.
     * 
     * @return The minimum element that was removed from heap. 
     */
    public E removeMin() {
        return null; //fix this
    }
    
    /**
     * Indicates whether heap is empty.
     * 
     * @return True if the heap is empty, false otherwise
     */
    public boolean isEmpty() { 
        return last == 0;
    }
    
    /**
     * Returns number of elements in heap.
     * 
     * @return Number of element in heap. 
     */
    public int size() { 
        return last; 
    }
    
    /**
     * Returns The contents of the heap for testing purposes.
     * 
     * @return The string contents of the heap
     */
    public String toString() {
        String heapStr = "Heap: ";
        for (int i = 0; i < last; i++) {
            heapStr += "Element: " + heap[i] + " Index: " + i + " ";  
        }
        return heapStr; 
    }
    
    public static void main() {
        MyHeap<Integer> test = new MyHeap<Integer>(); 
        System.out.println(test);
        test.add(3);
        System.out.println(test);
        test.add(77);
        test.add(1242);
        test.add(2);
        System.out.println(test);
        test.add(1);
        System.out.println(test);


    } 
}
