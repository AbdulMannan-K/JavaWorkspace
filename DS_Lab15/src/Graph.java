import java.util.ArrayList;

public class Graph {

    int numberOfVertices;
    ArrayList<LinkedList<Integer>> adjList;

    public Graph(int size){
        numberOfVertices=size;
        adjList = new ArrayList<>(size);
        for(int i=0 ; i < size ; i++) adjList.add(new LinkedList<>());
    }

    public void addEdge(int src, int dest){
        adjList.get(src).addNode(dest);
        adjList.get(dest).addNode(src);
    }

    public void showGraphStructure(){
        int i=0;
        for(LinkedList<Integer> L : adjList) {
            if (L.getSize() == 0) i++;
            else L.printList();
        }
        if(i==4) {
            System.out.println("Graph is Empty");
            return;
        }
    }

    public void BFT(int vertex){
        boolean visited[] = new boolean[V];

        Queue<Integer> queue = new Queue<>();

        visited[vertex]=true;
        queue.enqueue(vertex);

        while (queue.getSize() != 0)
        {
            vertex = queue.dequeue();
            
        }
    }

}
