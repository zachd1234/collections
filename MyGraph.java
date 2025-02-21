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
                
                if (toVertexResult == false) {
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
                depthFirstTraversal(visitChecklist, fromVertex);
                return visitChecklist;
            }
        }
    }
    
    /**
     * Performs a breadth-first traversal of the graph.
     * 
     * @param fromLabel - start vertex for the traversal
     * @returns list of labels in traversal order
     * @throws NullPointerException - when label is null
     * @throws NoSuchElementException - when vertex does not exist
     */
    public ArrayList <String > breadthFirstTraversal(String fromLabel) {
        if (fromLabel == null) {
            throw new NullPointerException();
        } else {
            //ensure fromLabel vertex exists
            Vertex fromVertex = nodeMap.get(fromLabel);
            if (fromVertex == null) {
                throw new NoSuchElementException();
            } else {
                ArrayList<String> visitChecklist = new ArrayList<String>();
                breadthFirstHelper(visitChecklist, fromVertex);
                return visitChecklist;
            }
        }
    }
    
    /**
     * Finds the shortest number of edges between fromLabel and toLabel. Utilizes a breadth-first traversal.
     * 
     * @param fromLabel - label of from vertex
     * @param toLabel - label of to vertex
     * @returns distance from fromLabel to toLabel, -1 if from vertex and to vertex are not connected
     * @throws NullPointerException - when either label is null
     * @throws NoSuchElementException - when either vertex does not exist
     */
    public int distance(String fromLabel,String toLabel) {
       if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = nodeMap.get(fromLabel);
            Vertex toVertex = nodeMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else {
                if (toLabel.equals(fromLabel)) {
                    return 0; 
                } else {
                    
                    ArrayList<String> visitChecklist = new ArrayList<String>();
                    MyQueueLL<TraversalNode> queue = new MyQueueLL<TraversalNode>();
                    queue.enqueue(new TraversalNode(fromLabel, 0));
                    
                    while (!queue.isEmpty()) {
                        TraversalNode curNode = queue.dequeue();
                        Vertex curVertex = nodeMap.get(curNode.getLabel());
                        if (!visitChecklist.contains(curVertex.label)){
                            visitChecklist.add(curVertex.label);
                            for (Vertex adj : curVertex.adjVerticies) {
                                int curDistance = curNode.getDistance();
                                if (adj.label.equals(toLabel)) { 
                                    return curDistance + 1;  //we found it 
                                } else {
                                    queue.enqueue(new TraversalNode(adj.label, curDistance + 1));
                                }
                            }
                        }
                    }
                    return -1; //could not find a path
                }
            }
        }
    }
    
    /**
     * Finds the shortest path from fromLabel to toLabel. Utilizes a breadth-first traversal.
     * 
     * @param fromLabel - label of from vertex
     * @param toLabel - label of to vertex
     * @returns list of vertex labels for path from fromLabel to toLabel, null if from vertex and to vertex are not connected
     * @throws NullPointerException - when label is null
     * @throws NoSuchElementException - when vertex does not exist
     */
    public ArrayList <String > shortestPath(String fromLabel,String toLabel) {
         if (fromLabel == null || toLabel == null) {
            throw new NullPointerException(); 
        } else {
            Vertex fromVertex = nodeMap.get(fromLabel);
            Vertex toVertex = nodeMap.get(toLabel);
            if (fromVertex == null || toVertex == null) {
                throw new NoSuchElementException();
            } else {
                if (toLabel.equals(fromLabel)) {
                    ArrayList<String> pathArr = new ArrayList<String>();
                    pathArr.add(fromLabel);
                    return pathArr;
                } else {
                    MyHashTable<String,TraversalNode> visitChecklist = new  MyHashTable<String,TraversalNode>();
                    MyQueueLL<TraversalNode> queue = new MyQueueLL<TraversalNode>();
                    TraversalNode fromNode = new TraversalNode(fromLabel, null);
                    queue.enqueue(fromNode);
                    
                    while (!queue.isEmpty()) {
                        TraversalNode curNode = queue.dequeue();
                        Vertex curVertex = nodeMap.get(curNode.getLabel());
                        if (visitChecklist.get(curVertex.label) == null) {
                            visitChecklist.put(curVertex.label, curNode);
                            System.out.println("Visted Checklist: " + visitChecklist);
                            for (Vertex adj : curVertex.adjVerticies) {
                                System.out.println(curVertex.label + " Adj Verticies " + curVertex.adjVerticies);
                                if (adj.label.equals(toLabel)) { //we found it 
                                    ArrayList<String> pathArr = new ArrayList<String>();
                                    TraversalNode nodeInPath = new TraversalNode(toLabel, curNode.getLabel());
                                    while (nodeInPath.getPreviousLabel() != null) {
                                        pathArr.add(0, nodeInPath.getLabel());
                                        nodeInPath = visitChecklist.get(nodeInPath.getPreviousLabel());
                                        System.out.println(nodeInPath.getLabel() + " " + nodeInPath.getPreviousLabel());
                                    }
                                    pathArr.add(0, fromLabel);
                                    return pathArr;
                                }
                                TraversalNode adjNode = new TraversalNode(adj.label, curNode.getLabel());
                                queue.enqueue(adjNode);
                            }
                        }
                    }
                    return null;
                } 
            }
        }
    }
    
    private void breadthFirstHelper(ArrayList<String> visitChecklist, Vertex fromVertex) {
            MyQueueLL<Vertex> queue = new MyQueueLL<Vertex>();
            queue.enqueue(fromVertex);
            
            while(!queue.isEmpty()) {
                Vertex curVertex = queue.dequeue();
                
                if (!visitChecklist.contains(curVertex)) {
                    visitChecklist.add(curVertex.label);
                    for (Vertex adj : curVertex.adjVerticies) {
                        queue.enqueue(adj);
                    }
                }
            }
        }

    private void depthFirstTraversal(ArrayList<String> visitChecklist, Vertex curVertex){
        visitChecklist.add(curVertex.label);
        for (Vertex adj : curVertex.adjVerticies) {
            if (visitChecklist.contains(adj.label) == false) {
                depthFirstTraversal(visitChecklist, adj);
            }
        }
    }

    /**
     * Returns hash table of vertices as a string for testing purposes.
     * 
     * @overrides toString in class Object
     * @returns vertices table as a string
     */
    public String toString() {
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
    
    private class TraversalNode { 
        private int distance;
        private String label;
        private String previousLabel;
    
        public TraversalNode(String label,int distance) {
            this.label = label;
            this.distance = distance;
            this.previousLabel = null;
        }
        
         public TraversalNode(String label,String previousLabel) {
            this.label = label;
            this.previousLabel = previousLabel;
            distance = -1;
        }
        
        public String getPreviousLabel() {
            return previousLabel;
        }
        
        public String getLabel() {
            return label;
        }
        
        public int getDistance() {
            return distance;
        }
    }
}