import java.util.*;

public class WeightedGraph<V> {
    private boolean undirected;
    private ArrayList<Vertex<V>> vertices = new ArrayList<>();

    public WeightedGraph(){
        undirected = true;
    }

    public WeightedGraph(boolean undirected){
        this.undirected = undirected;
    }

    public void addVertex(V data){
        Vertex<V> newVertex = new Vertex<>(data);
        vertices.add(newVertex);
    }

    public boolean hasVertex(V vertex){
        for(Vertex<V> v : vertices){
            if(v.getData() == vertex){
                return true;
            }
        }
        return false;
    }

    public boolean hasEdge(V source, V dest){
        for(Vertex<V> vertex : vertices){
            if(vertex.getData() == source){
                for(Vertex<V> v2 : vertex.getAdjacentVertices().keySet()){
                    if(v2.getData()==dest){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void addEdge(V source, V dest, double weight){
        Vertex<V> VertexSource = new Vertex<>(source);
        Vertex<V> VertexDest = new Vertex<>(dest);
        if(!hasVertex(source)){
            addVertex(source);
        }
        if(!hasVertex(dest)){
            addVertex(dest);
        }
        if(hasEdge(source,dest) || VertexSource.equals(VertexDest)){
            return;
        }
        for(Vertex<V> vertex : vertices){
            if(vertex.getData()==source){
                vertex.addAdjacentVertices(VertexDest,weight);
            }
        }
        if(undirected){
            for(Vertex<V> vertex: vertices){
                if(vertex.getData()==dest){
                    vertex.addAdjacentVertices(VertexSource, weight);
                }
            }

        }
    }

    public int getVerticesCount(){
        return vertices.size();
    }

    public int getEdgesCount(){
        int count = 0;
        for(Vertex<V> vertex : vertices){
            Set<Vertex<V>> set = vertex.getAdjacentVertices().keySet();
            count+=set.size();
        }
        return count;
    }

    public void display(){
        for(Vertex<V> vertex: vertices){
            vertex.display();
        }
    }

}
