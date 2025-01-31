import java.util.Arrays;

/**
 * Simple Hash Table of Strings
 *
 * @author Zach Derhake
 * @version 1/29/25
 */
public class MyHashTable
{
   
   private Node[] arr; 
   private int size;
   /**
    * Creates a new Hash Table Array with a length of 10
    */
   public MyHashTable(){
       arr = new Node[10];
       size = 0;
   }
   
   /**
    * Associate the specified value with the specified key in this hash table.
    * 
    * @param key identifer to find value
    * @param value of key
    * @throws NullPointerException if key or value is null
    */
   public void put(String key, String value) {
       if (key == null || value == null) {
            throw new NullPointerException();
       } else {
            int index = hash(key);

            Node existingNode = searchBucket(index, key);
            
            if(existingNode != null) {
                existingNode.setValue(value); //deals with duplicates
            } else{
                addToBucket(index, new Node(key, value));
                size++;
            }
            
            //OLD IMPLEMENTATION
            //if (arr[index] == null) { //adding a new value
            ///    size++; 
            //    arr[index] = new Node(key, value);
            //} else {
             //   arr[index].setValue(value);
            //}
            //} 
       }
   }
   
   /**
    * Returns the value to which the specified key is mapped, or null if this hash table contains no mapping for the key.
    * 
    * @param key value to search for in the array
    */
   public String get(String key) {
       if (key == null) {
           throw new NullPointerException(); 
       } else {
           Node node = searchBucket(hash(key), key);
           if (node == null) {
               return null; 
           } else {
               return node.getValue(); 
           }
       }
   }
   
   /**
    * Removes the key (and its corresponding value) and returns the value from this hash table.
    * 
    * @param key to be removed from the hash table array
    * @return the key value that was removed, null if no element was removed
    * @throws NullPointerException when key is null
    */
   public String remove(String key) {
       if (key == null) {
            throw new NullPointerException();
       } else {
           int index = hash(key);
           
           Node oldNode = searchBucket(index, key);

           if (oldNode == null) {
               return null; 
           } else {
               removeFromBucket(index, oldNode);
               size--;
               return oldNode.getValue();
           }
           
           // OLD IMPLEMENTATION 
           //if(arr[index] == null) {
               // return null; 
           // } else {
                // String removeValue = arr[index].getValue();
                // arr[index] = null;
                // size--;
                // return removeValue;
           // }
       }
    }
   
   private Node searchBucket(int bucket, String key){
       
       Node curNode = arr[bucket];
       
       while(curNode != null) {
           if (curNode.getKey().equals(key)) {
               return curNode; 
           } 
           curNode = curNode.getNext();
       }
       return null;
   }
   
   private void addToBucket(int bucket, Node newNode) {
       newNode.setNext(arr[bucket]);
       arr[bucket] = newNode;
   }
   
   private void removeFromBucket(int bucket, Node oldNode) {
       if(arr[bucket] == oldNode) {
           arr[bucket] = arr[bucket].getNext(); 
       }
       
       Node curNode = arr[bucket];
   
       while(curNode.getNext() != oldNode) {
           curNode = curNode.getNext();
       }
       curNode.setNext(curNode.getNext().getNext());
       oldNode.clearNode();
   }
    
   /**
    * Returns number of mappings in hash table.
    * 
    * @return the amount of values mapped in the hash array
    */
   public int size() {
       return size;      
   }
   
   public boolean isEmpty() {
       return size == 0; 
   }
   
   private int hash(String key) {
       return Math.abs(key.hashCode()) % arr.length;  
   }
   
   /**
    * Returns the hash table array
    * 
    * @return the hash table array in comma seperated order 
    */
   public String toString(){
        return Arrays.toString(arr); 
   }
   
   private class Node {
       
       private String key; 
       private String value;
       private Node next; 
       
       private Node(String key, String value) {
           this.key = key;
           this.value = value;
           this.next = null;
       }
       
       private void clearNode() {
           this.key = null;
           this.value = null;
           this.next = null;
       }
       
       private String getKey(){
           return key;
       }
       
       private String getValue() {
           return value; 
       }
       
       private Node getNext() {
           return next;
       }
       
       private void setValue(String value) {
           this.value = value; 
       }
       
       private void setNext(Node next) {
           this.next = next;
       }
       
       public String toString() {
           String toPrint = key + "->" + value;
           Node curNode = this;
           while(curNode.getNext() != null) {
               toPrint += "|" + curNode.getKey() + "->" + curNode.getValue();
           } 
           return toPrint; //TODO need to iterate through pointers 
       }
   }
   
}
