import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex<V>{
    private V data;
    private Map<Vertex<V>, Double> adjacentVertices = new HashMap<>();
    public void addAdjacentVertices(Vertex<V> destination, double weight){
        adjacentVertices.put(destination, weight);
    }
    public Vertex(V data){
        this.data = data;
    }
    public Map<Vertex<V>, Double> getAdjacentVertices(){
        return adjacentVertices;
    }
    public void display(){
        System.out.print(data + " ");
        for(Vertex<V> vertex : adjacentVertices.keySet()){
            System.out.println(vertex.data + " ");
        }
    }

    public V getData() {
        return data;
    }
}
