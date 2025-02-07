import java.util.Arrays;

/**
 * Simple Hash Table of Strings
 *
 * @author Zach Derhake
 * @version 1/29/25
 */
public class MyHashTable<K,V>
{
   
   private Node<K,V>[] arr; 
   private int size;
   private double loadFactor; 
   
   /**
    * Creates a new Hash Table Array with a length of 10
    */
   public MyHashTable(){
       arr =  (Node<K,V>[]) new Node[10];
       size = 0;
       loadFactor = 0.7;
   }
   
   /**
    * Associate the specified value with the specified key in this hash table.
    * 
    * @param key identifer to find value
    * @param value of key
    * @throws NullPointerException if key or value is null
    */
   public void put(K key, V value) {
       if (key == null || value == null) {
            throw new NullPointerException();
       } else {
            int index = hash(key);

            Node<K,V> existingNode = searchBucket(index, key);
            
            if(existingNode != null) {
                existingNode.setValue(value); //deals with duplicates
            } else{
                addToBucket(index, new Node(key, value));
                size++;
                if (size > loadFactor * arr.length) { //refactor hash table 
                    expandHashTable(); 
                }
            }
       }
   }
   
   /**
    * Returns the value to which the specified key is mapped, or null if this hash table contains no mapping for the key.
    * 
    * @param key value to search for in the array
    */
   public V get(K key) {
       if (key == null) {
           throw new NullPointerException(); 
       } else {
           Node<K,V> node = searchBucket(hash(key), key);
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
   public V remove(K key) {
       if (key == null) {
            throw new NullPointerException();
       } else {
           int index = hash(key);
           
           Node<K,V> oldNode = searchBucket(index, key);

           if (oldNode == null) {
               return null; 
           } else {
               removeFromBucket(index, oldNode);
               size--;
               return oldNode.getValue();
           }
       }
    }
    
   private void expandHashTable() {
       
       Node<K,V>[] oldArr = arr;
       arr = (Node<K,V>[]) new Node[oldArr.length*2];
       
       for (int i = 0; i < oldArr.length; i++) {
           Node<K,V> curNode = oldArr[i];
           if (curNode != null) {
               while (curNode.getNext() != null) {
                   Node<K,V> nextNode = curNode.getNext();
                   int index = curNode.getHashCode() % arr.length;
                   addToBucket(index, curNode);
                   curNode = nextNode;
               }
               oldArr[i] = null;
           }
       }
   }
   
   private Node searchBucket(int bucket, K key){
       
       Node<K,V> curNode = arr[bucket];
       
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
       Node<K,V> curNode = arr[bucket];
       if(arr[bucket] == oldNode) {
           arr[bucket] = arr[bucket].getNext();
           curNode.clearNode();
       } else {
   
           while(curNode.getNext() != oldNode) {
               curNode = curNode.getNext();
           }
       
           curNode.setNext(oldNode.getNext());
           oldNode.clearNode();
       }
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
   
   private int hash(K key) {
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
   
   private class Node<K,V> {
       
       private K key; 
       private V value;
       private Node next; 
       private int hashCode;
       
       private Node(K key, V value) {
           this.key = key;
           this.value = value;
           this.next = null;
           this.hashCode = Math.abs(key.hashCode());
       }
       
       private void clearNode() {
           this.key = null;
           this.value = null;
           this.next = null;
       }
       
       private K getKey(){
           return key;
       }
       
       private V getValue() {
           return value; 
       }
       
       private Node getNext() {
           return next;
       }
       
       private int getHashCode() {
           return hashCode; 
       }
       
       private void setValue(V value) {
           this.value = value; 
       }
       
       private void setNext(Node next) {
           this.next = next;
       }
       
       public String toString() {
           String toPrint = key + "->" + value;
           Node curNode = this;
           while(curNode.getNext() != null) {
               curNode = curNode.getNext();
               toPrint += "|" + curNode.getKey() + "->" + curNode.getValue();
           } 
           return toPrint; //TODO need to iterate through pointers 
       }
   }
   
}
