 import java.util.NoSuchElementException;

/**
 * A Min or Max Heap Tree Implemented in an Array
 *
 * @author Zach Derhake
 * @version 1/10/25
 */
public class MyHeap<E extends Comparable<E>>
{
    private E[] heap; 
    private int last; //keeps track of index and size
    private boolean isMinHeap;
    
    /**
     * Constructs dynamic-sized heap as either min-heap or max-heap.
     * 
     * @param Boolean that sets the heap: true is min, false is max.  
     */
    public MyHeap(boolean isMinHeap){
        heap = (E[]) new Comparable[1]; 
        this.last = 0;
        this.isMinHeap = isMinHeap;
    } 
    
     /**
     * Adds Element to Heap.
     * 
     * @param Element to be Inserted in the Heap 
     */
    public void add(E element) {
        
        int arrSize = heap.length;
        
        if (last >= arrSize) {
            E[] newHeap =  (E[]) new Comparable[(arrSize * 2)];
            
            for (int i = 0; i < arrSize; i++) {
                newHeap[i] = heap[i];
            }
            
            heap = newHeap; 
        }
        
        heap[last] = element;
        trickleUp(last);
        last++; 
    }
    
    private void trickleUp(int childIndex) {
        if (!(childIndex <= 0)) {
            int parentIndex = (childIndex-1)/2;
            int compFactor;
            if(isMinHeap) {
                compFactor = 1;
            } else {
                compFactor = -1; 
            }
            
            if(((heap[childIndex]).compareTo(heap[parentIndex]) * compFactor) < 0) {
                E swap = heap[parentIndex];
                heap[parentIndex] = heap[childIndex];
                heap[childIndex] = swap;
                trickleUp(parentIndex);
            }
        }
    }
    
    /**
     *  Gets top element (minimum or maximum) from heap.  
     *  
     *  @return The (Minimum or Maximum) Element From the Heap.
     *  @throws NoSuchElementException if Heap is Empty.
     */
    public E getTop() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return heap[0];
        }
    }
    
    /**
     * Removes and returns top element (minimum or maximum) from heap.
     * 
     * @return The top element (minimum or maximum) that was removed from heap. 
     * @throws NoSuchElementException if Heap is Empty. 
     */
    public E removeTop(){
        
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        E top = getTop();
        
        //swap last to top
        heap[0] = heap[last-1];
        heap[last-1] = null;
        last--;

        trickleDown(0); 
        return top;
    }
    
    private void trickleDown(int parentIndex) {
        int leftChild = 2 * parentIndex + 1;
        int rightChild = 2 * parentIndex + 2; 

        int compFactor;
        if(isMinHeap) {
            compFactor = 1;
        } else {
            compFactor = -1; 
        }
    
        if (last > leftChild) { // base case
            
            //find the largest child element
            int priorityChild;
            if (last > rightChild) {  
                if ((heap[leftChild].compareTo(heap[rightChild]) * compFactor) <= 0) {
                    priorityChild = leftChild; 
                } else {
                    priorityChild = rightChild;
                }
            } else {
                priorityChild = leftChild;
            } 
            
            //swap with priority child if higher priority  
            if ((heap[parentIndex].compareTo(heap[priorityChild]) * compFactor) > 0) {
                E swap = heap[priorityChild]; 
                heap[priorityChild] = heap[parentIndex];
                heap[parentIndex] = swap;
                trickleDown(priorityChild);
            }
          
        }
        
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
        String heapStr = "";
        for (int i = 0; i < last; i++) {
            if(i == last - 1) {
                heapStr += heap[i];
            } else {
                heapStr += heap[i] + ", ";  
            }
        }
        return heapStr; 
    }
    
    /**
     * Prints elements as stored in the tree
     *
     * @param maxLabelWidth The maximum space allowed for the string form
     *                        of the element.
     */
    public void printTree(int maxLabelWidth) {
        int depth = (int) (Math.log(last + 1) / Math.log(2)) + 1;
        int maxSize = (int) Math.pow(2, depth) - 1;
        String[] labels = new String[maxSize];

        // Build array of element labels
        buildTreeLabels(labels, maxLabelWidth);

        // Print element properly spaced
        int fullWidth = (int) Math.pow(2, depth - 1) * (maxLabelWidth + 1);
        for (int i = 0; i < depth; i++) {
            String connectionsLevelStr = "";
            String labelsLevelStr = "";

            for (int j = (int) Math.pow(2, i) - 1; j < (int) Math.pow(2, i + 1) - 1; j++) {

                // Process arrows for this level
                String arrow = "  ";
                int arrowLength = arrow.length();
                if (labels[j] != null) {
                    if (j % 2 == 1) { // Odd is left child
                        arrow = " /";
                    } else { // Even is right child
                        arrow = "\\ ";
                    }
                }

                // Center within maxElementWidth
                String leftPadStr = ""; // Default
                String rightPadStr = ""; // Default
                int leftPadNum = (fullWidth / (int) Math.pow(2, i) - arrowLength) / 2;
                int rightPadNum = fullWidth / (int) Math.pow(2, i) - arrowLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }
                connectionsLevelStr += leftPadStr + arrow + rightPadStr;

                // Process elements for this level
                int labelLength = 0;
                if (labels[j] != null) {
                    labelLength = labels[j].length();
                }

                // Center within maxLabelWidth
                leftPadStr = ""; // Default
                rightPadStr = ""; // Default
                leftPadNum = (fullWidth / (int) Math.pow(2, i) - labelLength) / 2;
                rightPadNum = fullWidth / (int) Math.pow(2, i) - labelLength - leftPadNum;
                if (leftPadNum > 0) {
                    leftPadStr = String.format("%" + leftPadNum + "s", " ");
                }
                if (rightPadNum > 0) {
                    rightPadStr = String.format("%" + rightPadNum + "s", " ");
                }

                if (labels[j] != null) {
                    labelsLevelStr += leftPadStr + labels[j] + rightPadStr;
                } else {
                    labelsLevelStr += leftPadStr + rightPadStr;
                }
            }

            if (i > 0) { // Do not print arrows for root
                System.out.println(connectionsLevelStr);
            }
            System.out.println(labelsLevelStr);
        }
    }

      // build array of element strings
        private void buildTreeLabels(String[] labels, int maxLabelWidth) {
        for (int i = 0; i <= last-1; i++) {
            labels[i] = heap[i].toString();
            if (labels[i].length() > maxLabelWidth) {
                labels[i] = labels[i].substring(0, maxLabelWidth);
            }
        }
    }


    
    public static void main() {
        MyHeap<Integer> test = new MyHeap<Integer>(false);
        System.out.println("Delete Testing: ");
        test.add(50);
        test.add(32);
        test.add(20);
        test.add(10);
        test.add(5);
        test.add(3);
        test.add(1);
        test.add(100);
        test.add(150);
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);
        System.out.println(test.removeTop());
        test.printTree(3);

        System.out.println(test.removeTop());
        test.printTree(3);

    } 
}
