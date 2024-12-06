
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
       
       System.out.println("testing insert");
   }
}
