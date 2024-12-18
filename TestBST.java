  import java.util.NoSuchElementException;
import java.util.Arrays;
/**
 * Testing the Binary Search Tree Class
 *
 * @author Zach Derhake
 * @version 12/4/24
 */
public class TestBST
{
   public static void basicTesting() {
       BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();
       if (intTree.isEmpty()) {
           System.out.println("isEmpty: pass");
       } else {
           System.out.println("isEmpty: fail");
       }
       if (intTree.size() == 0) {
           System.out.println("size: pass");
       } else {
           System.out.println("size: fail");
       }
       System.out.println("testing toString");
       System.out.println("toString with emtpy: " + intTree.toString().equals(""));
       
       System.out.println("testing insert");
       BinarySearchTree<String> strTree = new BinarySearchTree<String>();
       try {
           strTree.insert(null);
           System.out.println("fail. Null insertion did not throw an error");
       } catch(NullPointerException e) {
           System.out.println("pass (when inserting null) " + e);
       }
       System.out.println("insert at root: ");
       System.out.println("mm " + strTree.insert("mm"));
       System.out.println("t " + strTree.insert("t"));
       System.out.println("F" + strTree.insert("f"));
       System.out.println("z " + strTree.insert("z"));
       System.out.println("adding a duplicate");
       if(!strTree.insert("z")) {
           System.out.println("pass");
       } else {
           System.out.println("fail"); 
       }
       System.out.println("the not null use case");
       System.out.println("c " + strTree.insert("c"));
       System.out.println("n " + strTree.insert("n"));
       System.out.println(strTree.toString());
   }
   
   public static void searchTesting() {
       BinarySearchTree<String> strTree = new BinarySearchTree<String>();
       try {
           strTree.search(null);
           System.out.println("fail. Null search did not throw an error when it should of");
       } catch(NullPointerException e) {
           System.out.println("pass (when searching for null) " + e);
       }
       System.out.println("seraching for an element in empty list: " + strTree.search("hi"));
       System.out.println("Loading up the tree");
       System.out.println("mm " + strTree.insert("mm"));
       System.out.println("t " + strTree.insert("t"));
       System.out.println("F" + strTree.insert("f"));
       System.out.println("z " + strTree.insert("z"));
       System.out.println("c " + strTree.insert("c"));
       System.out.println("n " + strTree.insert("n"));
       System.out.println("searching for root");
       System.out.println("root search works?" + ("mm".equals(strTree.search("mm"))));
       System.out.println("works when equals right child? " + "t".equals(strTree.search("t")));
       System.out.println("works when equals left child? " + "f".equals(strTree.search("f")));
       System.out.println("when element isn't in tree but valid " + (null == (strTree.search("q"))));
       System.out.println("One more layer " + "z".equals(strTree.search("z")));
   }
   
   public static void minMaxTesting() {
      BinarySearchTree<String> strTree = new BinarySearchTree<String>();
      System.out.println("testing with an empty list");
      try {
           strTree.getMin();
       } catch (NoSuchElementException e) {
           System.out.println("pass. (when finding min in empty list) " + e);
      }
      
       try {
           strTree.getMax();
       } catch (NoSuchElementException e) {
           System.out.println("pass. (when finding max in empty list) " + e);
      }
      
      strTree.insert("mm");
      System.out.println("min works when only element is root? " + "mm".equals(strTree.getMin()));
      System.out.println("max works when only element is root? " + "mm".equals(strTree.getMax()));
      strTree.insert("f");
      strTree.insert("t");
      System.out.println("min works when there are children " + "f".equals(strTree.getMin()));
      System.out.println("max works when there are children " + "t".equals(strTree.getMax()));
      strTree.insert("a");
      strTree.insert("z");
      System.out.println("min works when there are many children " + "a".equals(strTree.getMin()));
      System.out.println("max works when there are many children " + "z".equals(strTree.getMax()));
   }
   
   public static void treeCutDownTesting() {
          BinarySearchTree<String> strTree = new BinarySearchTree<String>();
          System.out.println("toDepth works at empty? " + (strTree.getDepth() == 0));
          try {
              strTree.removeMin();
              System.out.println("fail. remove min doesn't work at empty");
          } catch(NoSuchElementException e) {
              System.out.println("pass. remove min works at empty tree" + e); 
          }
          
          try {
              strTree.removeMax();
              System.out.println("fail. remove max doesn't work at empty");
          } catch(NoSuchElementException e) {
              System.out.println("pass. remove max works at empty tree" + e); 
          }
          
          strTree.insert("mm");
          System.out.println(strTree.toString());
          System.out.println(Arrays.toString(strTree.toArray()));
          System.out.println("toDepth works? " + (strTree.getDepth() == 1));
          strTree.insert("f");
          System.out.println(strTree.toString());
          System.out.println(Arrays.toString(strTree.toArray()));
          System.out.println("toDepth works? " + (strTree.getDepth() == 2));
          strTree.insert("t");
          System.out.println(strTree.toString());
          System.out.println(Arrays.toString(strTree.toArray()));
          System.out.println("toDepth works? " + (strTree.getDepth() == 2));
          strTree.insert("a");
          System.out.println("toDepth works? " + (strTree.getDepth() == 3));
          strTree.insert("z");
          System.out.println(strTree.toString());
          System.out.println(Arrays.toString(strTree.toArray()));
          strTree.insert("j");
          System.out.println("toDepth works? " + (strTree.getDepth() == 3));
          strTree.insert("s");
          System.out.println("toDepth works? " + (strTree.getDepth() == 3));
          System.out.println(strTree.toString());
          System.out.println(Arrays.toString(strTree.toArray()));
          System.out.println(strTree.removeMin());
          System.out.println(Arrays.toString(strTree.toArray()));
          System.out.println(strTree.removeMax());
          System.out.println(strTree.toString());  
          System.out.println(strTree.remove("j"));    
          System.out.println(strTree.remove("s"));   
          System.out.println(strTree.toString());    
        }
   
   public static void removeMethodsTesting() {
       BinarySearchTree<String> strTree = new BinarySearchTree<String>();
       System.out.println("Removing when empty " + strTree.remove("f"));
       strTree.insert("mm");
       System.out.println("searching for non existant element " + strTree.remove("f"));
       try {
           strTree.remove(null);
           System.out.println("fail when adding null to tree");
       } catch(NullPointerException e) {
           System.out.println("Pass when adding null to tree " + e);
       }
       
       
       
       if (strTree.removeMax().equals("mm")) {
           System.out.println("pass when max is root"); 
       } else {
           System.out.println("fail when max is root"); 
       }
       System.out.println(strTree.toString());
       
       strTree.insert("mm");
       if (strTree.removeMin().equals("mm")) {
           System.out.println("pass when min is root"); 
       } else {
           System.out.println("fail when min is root"); 
       }
       System.out.println(strTree.toString());
       strTree.insert("mm");
       strTree.insert("t");
       System.out.println(strTree.removeMin());
       System.out.println(strTree.toString());
       strTree.removeMin();
       strTree.insert("mm");       
       strTree.insert("f");
       System.out.println(strTree.removeMax());
       System.out.println(strTree.toString());
       strTree.removeMin();
       strTree.insert("mm");       
       strTree.removeMin();
       System.out.println(strTree.toString());
       strTree.insert("mm");       
       strTree.removeMax();
       System.out.println(strTree.toString());
       strTree.insert("mm");
       System.out.println(strTree.remove("mm"));
       System.out.println("string: " + strTree.toString());
       strTree.insert("mm");
       strTree.insert("f");
       System.out.println("removed: " + strTree.remove("f"));
       System.out.println("string: " + strTree.toString());
       strTree.insert("f");
       strTree.remove("mm"); 
       System.out.println("string: " + strTree.toString());
       System.out.println("removed: " + strTree.remove("f"));
       strTree.insert("mm");
       strTree.insert("z");
       System.out.println("removed: " + strTree.remove("mm"));
       System.out.println("string: " + strTree.toString());
       System.out.println("removed: " + strTree.remove("z"));
       strTree.insert("mm");
       strTree.insert("f");
       strTree.insert("t");
       strTree.insert("q");
       strTree.insert("c");
       System.out.println("string: " + strTree.toString());
       System.out.println("removed: " + strTree.remove("mm"));
       System.out.println("string: " + strTree.toString());
       strTree.insert("e");
       System.out.println("string: " + strTree.toString());
       System.out.println("removed: " + strTree.remove("f"));
       System.out.println("string: " + strTree.toString());
    }
    
   public static void testIterator(){
       BinarySearchTree<String> strTree = new BinarySearchTree<String>();
       System.out.println("Loading up the tree");
       System.out.println("mm " + strTree.insert("mm"));
       System.out.println("t " + strTree.insert("t"));
       System.out.println("F" + strTree.insert("f"));
       System.out.println("z " + strTree.insert("z"));
       System.out.println("c " + strTree.insert("c"));
       System.out.println("n " + strTree.insert("n"));
       for(String element : strTree) {
           System.out.print(element + ", ");
       }
       System.out.println();
       int size = 0;
       for(String element2 : strTree) {
           System.out.print(element2 + ", ");
           if(size >= 3) {
               break; 
           }
           size++;
       }
   }
   
   public static void testEval() {
       System.out.println(ArithmeticExpressionEval.evaluate("(1+2)*3"));
   }
}