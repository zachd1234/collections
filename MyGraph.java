import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Graph implementation
 *
 * @author Zach Derhake
 * @version v1
 */
public class MyGraph
{
    private MyHashTable<String,Vertex> nodeMap;
    
    public MyGraph() {
        nodeMap = new MyHashTable<String, Vertex>();
    }

    /**
     * Adds vertex to graph.
     * 
     * @param label - value to associate with vertex
     * @throws NullPointerException - when label is null
     */
    public void addVertex(String label){
        if (label == null) {
            throw new NullPointerException();
        } else {
            nodeMap.put(label, new Vertex(label));
        }
    }
    
    /**
     * Adds directed edge between vertices of graph.
     * 
     * @paramfromLabel - from vertex
     * @param toLabel - to vertex
     * 
     * @throws NullPointerException - when either label is null
     * @throws NoSuchElementException - when either vertex does not exist
     * @throws IllegalArgumentException - when edge is a duplicate
     */
    public void addEdge(String fromLabel, String toLabel) {
        if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = nodeMap.get(fromLabel);
            Vertex toVertex = nodeMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else {
                boolean toVertexResult = toVertex.addAdjVertex(fromVertex);
                boolean fromVertexResult = fromVertex.addAdjVertex(toVertex);
                
                if (toVertexResult == false || fromVertexResult == false) {
                    throw new IllegalArgumentException(); //edge is a duplicate
                }
            }
        }
    }
    
    /**
     * Performs a depth-first traversal of the graph.
     * 
     * @param fromLabel - start vertex for the traversal
     * @returns list of labels in traversal order
     * @throws NullPointerException - when label is null
     * @throws NoSuchElementException - when vertex does not exist
     */
    public ArrayList <String > depthFirstTraversal(String fromLabel) {
        if (fromLabel == null) {
            throw new NullPointerException();
        } else {
            //ensure fromLabel vertex exists
            Vertex fromVertex = nodeMap.get(fromLabel);
            if (fromVertex == null) {
                throw new NoSuchElementException();
            } else {
                ArrayList <String > visitChecklist = new ArrayList<String>();
                fromVertex.depthFirstTraversal(visitChecklist);
                return visitChecklist;
            }
        }
    }
    
    /**
     * Returns hash table of vertices as a string for testing purposes.
     * 
     * @overrides toString in class Object
     * @returns vertices table as a string
     */
    public String toString(){
        return nodeMap.toString();
    }
    
    private class Vertex {
        private String label;
        private ArrayList<Vertex> adjVerticies;
        
        public Vertex(String label) {
            this.label = label;
            this.adjVerticies = new ArrayList<Vertex>();
        }
        
        public boolean addAdjVertex(Vertex newVertex) {
            if(adjVerticies.contains(newVertex)) {
                return false; //newVertex is a duplicate
            } else {
                adjVerticies.add(newVertex);
                return true;
            }
        }
        
        public void depthFirstTraversal(ArrayList<String > visitChecklist){
            visitChecklist.add(label);
            for (Vertex adj : adjVerticies) {
                if (visitChecklist.contains(label) == false) {
                    depthFirstTraversal(visitChecklist);
                }
            }
        }
        
        public String getLabel(){
            return label;
        }
        
        public String toString() {
            String adjVerticiesStr = "";
            for( Vertex vertex : adjVerticies){
                adjVerticiesStr += "[" + vertex.label + "]";
            }
            return label + ":" + adjVerticiesStr;
        }
    }
}