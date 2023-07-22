package DepthSearch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
class Graph {
    private int V; 
    private LinkedList<Integer>[] adjList;
    Graph(int v) {
        V = v;
        adjList = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adjList[i] = new LinkedList();
    }
    void addEdge(int v, int w) {
        if (v >= 0 && v < V && w >= 0 && w < V) {
            adjList[v].add(w);
        } else {
            System.out.println("Invalid edge: (" + v + ", " + w + ")");
        }
    }
    void DFS(int v) {
        boolean[] visited = new boolean[V]; 
        DFSUtil(v, visited);
    }
    void DFSUtil(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        Iterator<Integer> it = adjList[v].iterator();
        while (it.hasNext()) {
            int n = it.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("/Users/athi_macbookair/Desktop/graph-DFS-BFS.txt"));
            int numOfVertices = scanner.nextInt();
            Graph graph = new Graph(numOfVertices);

            int lineCount = 1; // To track the line number being read
            while (scanner.hasNextInt()) {
                try {
                    int source = scanner.nextInt();
                    int destination = scanner.nextInt();
                    graph.addEdge(source, destination);
                } catch (NoSuchElementException e) {
                    System.out.println("Error reading line " + lineCount + " in the file.");
                    break;
                }
                lineCount++;
            }

            scanner.close();
            System.out.println("Depth First Traversal (starting from vertex 2): ");
            graph.DFS(2);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}
