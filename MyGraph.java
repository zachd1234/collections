import java.util.ArrayList;

/**
 * Graph implementation
 *
 * @author Zach Derhake
 * @version v1
 */
public class MyGraph<String,Vertex>
{
    private MyHashTable<String,Vertex> nodeMap;
    
    public MyGraph() {
        nodeMap = new MyHashTable<String, Vertex>();
    }

    public void addVertex(Vertex newVertex){
        if (newVertex == null) {
            throw new NullPointerException();
        } else {
            
            
            nodeMap.put(newVertex.getLabel(), newVertex);
        }
    }
    
    
    public String toString(){
        return nodeMap;
    }
    
    private class Vertex {
        private String label;
        private ArrayList<Vertex> adjVerticies;
        
        public Vertex(String label, ArrayList<Vertex> adjVerticies) {
            this.label = label;
            this.adjVerticies = adjVerticies;
        }
        
        public String getLabel(){
            return label;
        }
    }
}
