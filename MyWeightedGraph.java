//34567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890
import java.util.ArrayList;
import java.util.NoSuchElementException;


/**
 * Weighted Graph implementation
 *
 * @author Zach Derhake
 * @version v1
 */
public class MyWeightedGraph
{
    private MyHashTable<String,Vertex> vertexMap;
    
    /**
     * Constructor for MyWeightedGraph clas.
     */
    public MyWeightedGraph() {
        vertexMap = new MyHashTable<String, Vertex>();
    }
    
    /**
     * Adds vertex to graph.
     * 
     * @param label - value to associate with vertex
     * @throws NullPointerException - when label is null
     * @throws IllegalArgumentException - when label is duplicate 
     */
    public void addVertex(String label){
        if (label == null) {
            throw new NullPointerException();
        } else {
            if(vertexMap.get(label) != null) {
                throw new IllegalArgumentException(); 
            } else {
                vertexMap.put(label, new Vertex(label));
            }        
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
     * @throws IllegalArgumentException - when weight is negative
     */
    public void addEdge(String fromLabel, String toLabel, double weight) {
        if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = vertexMap.get(fromLabel);
            Vertex toVertex = vertexMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else if (0 > weight) {
                    throw new IllegalArgumentException(); 
            } else {
                fromVertex.addAdjVertex(toVertex, weight);
            }
        }
    }
    
    /**
     * Runs Dijkstra's algorithm. Precondition: Vertex for fromLabel exists in graph
     * 
     * @param fromLabel - label from vertex
     * @return table of visited TraversalNodes
     */
    public MyHashTable<String, MyWeightedGraph.TraversalNode> runDijkstra(String fromLabel) {
        MyHashTable<String, MyWeightedGraph.TraversalNode> visitedList = new MyHashTable<String, MyWeightedGraph.TraversalNode>();
        MyHeap<TraversalNode> heap = new MyHeap<TraversalNode>(true); 
        
        heap.add(new TraversalNode(fromLabel, fromLabel, 0));
        while (!heap.isEmpty()) { //should be a heap
            TraversalNode curNode = heap.removeTop();
            Vertex curVertex = vertexMap.get(curNode.getLabel());
            if (visitedList.get(curNode.getLabel()) == null) {
                visitedList.put(curNode.getLabel(), curNode);
                for (Edge adj : curVertex.adjEdges) {
                    heap.add(new TraversalNode(adj.toVertex().getLabel(), curNode.getLabel(), curNode.getWeight() + adj.getWeight()));
                }
            }
        }
        return visitedList;
    }
    
    /**
     * Returns hash table of vertices as a string for testing purposes.
     * 
     * @overrides toString in class Object
     * @return vertices table as a string
     */
    public String toString() {
        return vertexMap.toString();
    }
    
    /**
     * Finds the lowest total weight from the fromLabel to the toLabel. Utilizes Dijkstra's algorithm.
     * 
     * @param fromLabel - label of the from vertex
     * @param toLabel - label of the to vertex
     * @return cost from the fromLabel to the toLabel, -1 if from vertex and to vertex are not connected 
     * @throws NullPointerException - when either label is null
     * @throws NoSuchElementException - when either vertex does not exist 
     */
    public double weight(String fromLabel,String toLabel) {
         if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = vertexMap.get(fromLabel);
            Vertex toVertex = vertexMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else {
                MyHashTable<String, MyWeightedGraph.TraversalNode> traversedTable = runDijkstra(fromLabel);
                TraversalNode toNode = traversedTable.get(toLabel);
                if (toNode != null) {
                    return toNode.getWeight();
                } else {
                    return -1; 
                }  
            } 
        }
    }
    
    /**
     * Finds a lowest-weight path from the fromLabel to the toLabel. Utilizes Dijkstra's algorithm.
     * 
     * @param fromLabel - label of the from vertex
     * @param toLabel - label of the to vertex
     * @return list of vertex labels for path from fromLabel to toLabel, null if from vertex and to vertex are not connected
     * @throws NullPointerException - when either label is null
     * @throws NoSuchElementException - when either vertex does not exist
     */
    public ArrayList <String > path(String fromLabel, String toLabel) {
        if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = vertexMap.get(fromLabel);
            Vertex toVertex = vertexMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else {
                MyHashTable<String, MyWeightedGraph.TraversalNode> traversedTable = runDijkstra(fromLabel);
                TraversalNode curNode = traversedTable.get(toLabel);
                if (curNode == null) {
                    return null; 
                } else {
                    ArrayList<String> path = new ArrayList<String>(); 
                    while (curNode != null && !curNode.getLabel().equals(fromLabel)) {
                        path.add(0, curNode.getLabel());
                        curNode = traversedTable.get(curNode.getPreviousLabel()); 
                    } 
                    path.add(0, fromLabel);
                    return path;
                }
            } 
        }
    }
    private class Vertex {
        private String label;
        private ArrayList<Edge> adjEdges;
        
        public Vertex(String label) {
            this.label = label;
            this.adjEdges = new ArrayList<Edge>();
        }
        
        public void addAdjVertex(Vertex newVertex, double weight) {
            adjEdges.add(new Edge(newVertex, weight));
        }   
        
        public String getLabel(){
            return label;
        }
        
        public String toString() {
            String adjEdgesStr = "";
            for( Edge edge : adjEdges){
                adjEdgesStr += "[" + edge + "]";
            }
            return label + ":" + adjEdgesStr;
        }
    }
    
    private class TraversalNode implements Comparable<TraversalNode> { 
        private String label;
        private String previousLabel;
        private double weight; 
    
        public TraversalNode(String label,String previousLabel, double weight) {
            this.label = label;
            this.previousLabel = previousLabel;
            this.weight = weight;
        }
        
        public String getLabel() {
            return label;
        }
        
        public String getPreviousLabel() {
            return previousLabel;
        }
        
        public double getWeight() {
            return weight;
        }
        
        public void setWeight(double newWeight) {
            weight = newWeight;
        }
        
        public void setPreviousLabel(String newPreviousLabel) {
            previousLabel = newPreviousLabel;
        }
        
        /**
         * Returns a value <0 if this is less than other; returns zero if this is
         * equal to other; returns a value >0 if this is greater than other
         */
        @Override
        public int compareTo(TraversalNode other) {
           double otherWeight = other.getWeight();
           double thisWeight = this.getWeight();
           if (thisWeight > otherWeight) {
               return 1; 
           } else if (otherWeight > thisWeight) {
               return -1;  
           } else {
               return 0; 
           }
        }
        
        public String toString() {
            return label + "~" + weight + "~" + previousLabel; 
        }
    }
    
    private class Edge {
        private Vertex toVertex;
        private double weight;
        
        public Edge(Vertex toVertex, double weight) {
            this.toVertex = toVertex;
            this.weight = weight; 
        }
        
        public double getWeight() {
            return weight;
        }
        
        public Vertex toVertex() {
            return toVertex;
        }
        
        public String toString() {
            return toVertex.getLabel() + "~" + weight; 
        }        
    }
}
