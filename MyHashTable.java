import java.util.Arrays;

/**
 * Simple Hash Table of Strings
 *
 * @author Zach Derhake
 * @version 1/29/25
 */
public class MyHashTable
{
   
   private String[] arr; 
   private int size;
   /**
    * Creates a new Hash Table Array with a length of 10
    */
   public MyHashTable(){
       arr = new String[10];
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
            if (arr[index] == null) { //adding a new value
               size++; 
            } 
            arr[index] = value;
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
           return arr[hash(key)];
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
           if(arr[index] != null) {
               size--; 
           }
           
           String removeValue = arr[index];
           arr[index] = null;
           return removeValue;
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
}
